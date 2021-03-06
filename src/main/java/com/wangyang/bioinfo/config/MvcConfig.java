package com.wangyang.bioinfo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wangyang.bioinfo.interceptor.BioInterceptor;
import com.wangyang.bioinfo.interceptor.SpringWebSocketHandlerInterceptor;
import com.wangyang.bioinfo.util.SpringWebSocketHandler;
import com.wangyang.bioinfo.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wangyang
 * @date 2021/4/24
 */
@Configuration
@EnableWebSocket
public class MvcConfig  extends WebMvcConfigurationSupport implements WebSocketConfigurer {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:/home/wy/.bioinfo/")
                .addResourceLocations("classpath:/static/html/");
        super.addResourceHandlers(registry);
    }

    /**
     * ??????????????????spring context????????????????????????
     * @return
     */
    @Bean
    public BioInterceptor bioInterceptor(){
        return new BioInterceptor();
    }
    /**
     * ???????????????
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bioInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/api/user/login", "/logout/**", "/loginPage/**", "/error/**");
    }

    /**
     * ??????ResponseBody??????????????????????????????json??????
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * ????????????Json???,????????????Long??????String
         * ??????js???????????????????????????????????????java Long???
         */
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        // ?????????double??????????????????????????????
//        simpleModule.addSerializer(Double.class, CustomerDoubleSerialize.instance);
//        simpleModule.addSerializer(Double.TYPE, CustomerDoubleSerialize.instance);

        /**
         * ???????????????
         * yyyy-MM-dd HH:mm:ss
         * https://blog.csdn.net/kylin_tam/article/details/106683981
         */
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        /**
         * ????????????????????????
         */
        JavaTimeModule javaTimeModule=new JavaTimeModule();
        javaTimeModule.addDeserializer(Date.class,jsonDateDeserializer());
        objectMapper.registerModule(javaTimeModule);

        objectMapper.registerModule(simpleModule);
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);

        converters.add(jackson2HttpMessageConverter);
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                Charset.forName("UTF-8"));
//        converters.add(responseBodyConverter());
    }

    /**
     * ???????????????????????????
     * https://blog.csdn.net/weixin_34290096/article/details/92334617
     * @return
     */
    @Bean
    public JsonDateDeserializer jsonDateDeserializer() {
        return new JsonDateDeserializer();
    }

    /**
     * ??????Pageable pageable???????????????????????????
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add( new PageableHandlerMethodArgumentResolver());
    }


    @Override
    protected void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").
                    allowedOriginPatterns("*").
                    allowedMethods("*"). //?????????????????????post???get??????
                    allowedHeaders("*"). //?????????????????????
                    allowCredentials(true); //??????cookie??????
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //springwebsocket 4.1.5???????????????????????????????????????????????????????????????????????????????????????.setAllowedOrigins("*")
        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").setAllowedOrigins("*")
                .addInterceptors(new SpringWebSocketHandlerInterceptor());
//
//        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do")
//                .addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler webSocketHandler() {
        return new SpringWebSocketHandler();
    }

}

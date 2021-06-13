package com.wangyang.bioinfo.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author wangyang
 * @date 2021/6/13
 * https://blog.csdn.net/weixin_33705053/article/details/89649399
 * https://blog.csdn.net/weixin_34290096/article/details/92334617
 * https://www.cnblogs.com/jifeng/p/9700911.html
 *
 */
//@JsonComponent
public class JsonDateDeserializer  extends JsonDeserializer<Date> {
//    private String[] patterns = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd"};
    private static String[] patterns =
            new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.S",
                    "yyyy.MM.dd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss.S",
                    "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.S","yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"};
//2021-06-16T00:29:18.284Z"
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateAsString = jsonParser.getText();
        Date parseDate = null;
        try {
            parseDate = DateUtils.parseDate(dateAsString, patterns);
//            parseDate.
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getCause());
        }

        return parseDate;
    }

    /**
     * 全局的配置必须重写handledType()方法
     * {@link MvcConfig#jackson2ObjectMapperFactoryBean(JsonDateDeserializer)}
     * @return
     */
    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}

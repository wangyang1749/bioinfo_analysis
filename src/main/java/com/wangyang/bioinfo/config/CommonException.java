package com.wangyang.bioinfo.config;

import com.wangyang.bioinfo.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author wangyang
 * @date 2021/6/11
 */
@Slf4j
@RestControllerAdvice({"com.wangyang"})
public class CommonException {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse cmsException(Exception e) {
        BaseResponse<Map<String, String>> baseResponse = handleBaseException(e);
        baseResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return baseResponse;
    }
    private <T> BaseResponse<T> handleBaseException(Throwable t) {
        Assert.notNull(t, "Throwable must not be null");

        log.error("Captured an exception", t);

        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setMessage(t.getMessage());

        /**
         * 如果是debug模式前端显示详细错误
         */
        if (log.isDebugEnabled()) {
           // baseResponse.setDevMessage(ExceptionUtils.getStackTrace(t));
        }

        return baseResponse;
    }
}

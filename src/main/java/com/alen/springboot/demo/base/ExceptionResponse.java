package com.alen.springboot.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;

import java.util.Calendar;

/**
 * 通用异常返回类
 *
 * @author alen
 * @create 2018-12-02 16:21
 **/
public class ExceptionResponse {
    private Long timestamp;
    private Integer status;
    private String message;

    public ExceptionResponse(HttpStatus statusEnum, String message) {
        this.timestamp = Calendar.getInstance().getTimeInMillis();
        this.status = statusEnum.value();
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}


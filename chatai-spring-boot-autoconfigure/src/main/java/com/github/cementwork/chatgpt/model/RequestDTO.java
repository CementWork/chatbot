package com.github.cementwork.chatgpt.model;

import java.util.Map;

/**
 * DATE: 2022/8/30
 * Description:
 * Author: gdq
 */
public class RequestDTO {
    /**
     * 请求方式静态变量
     */
    public static final Integer METHOD_GET = 1;
    public static final Integer METHOD_POST = 2;
    public static final Integer METHOD_PUT = 3;
    public static final Integer METHOD_DELETE = 4;

    /**
     * 请求方式类型静态变量
     */
    public static final Integer TYPE_FORM_DATA = 1;
    public static final Integer TYPE_X_WWW_FORM_URLENCODED = 2;
    public static final Integer TYPE_JSON = 3;

    /** 请求地址*/
    private String url;

    /** 请求方式*/
    private Integer method;

    /** 请求类型(选填 GET请求不用填 POST请求要填)*/
    private Integer methodType;

    /** 请求参数*/
    private Map<String,String> param;

    /** 请求体*/
    private Map<String,Object> body;

    /** 请求头*/
    private Map<String,String > headers;

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Integer getMethodType() {
        return methodType;
    }

    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}

package com.github.cementwork.chatgpt.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSONObject;
import com.github.cementwork.chatgpt.model.RequestDTO;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.Map;

/**
 * DATE: 2022/9/9
 * Description:
 * Author: gdq
 */
public class HttpClientUtil {

    public static JSONObject doRequest(String url, Map<String,String> param, Map<String,Object> body , Map<String,String> headers, Integer method, Integer methodType){
        URIBuilder uriBuilder = null;

        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //组装param到url
        if(ObjectUtil.isNotEmpty(param)){
            for (String key : param.keySet()){
                uriBuilder.addParameter(key,param.get(key));
            }
        }


        url = uriBuilder.toString();

        //构建http请求类型
        HttpRequest request = null;
        if(method.equals(RequestDTO.METHOD_GET)){
            request = HttpUtil.createRequest(Method.GET, url);
        }
        if(method.equals(RequestDTO.METHOD_DELETE)){
            request = HttpUtil.createRequest(Method.DELETE, url);
        }
        if(method.equals(RequestDTO.METHOD_POST)){
            request = HttpUtil.createRequest(Method.POST, url);
        }
        if(method.equals(RequestDTO.METHOD_PUT)){
            request = HttpUtil.createRequest(Method.PUT, url);
        }

        //构建body类型
        if(ObjectUtil.isNotEmpty(methodType)){
            if(methodType.equals(RequestDTO.TYPE_JSON)){
                request.body(JSONObject.toJSONString(body));
            }
            if(methodType.equals(RequestDTO.TYPE_FORM_DATA) || methodType.equals(RequestDTO.TYPE_X_WWW_FORM_URLENCODED)){
                request.form(body);
            }

        }
        //构建头
        if(ObjectUtil.isNotEmpty(headers)){
            request.addHeaders(headers);
        }

        HttpResponse execute = request.execute();
        String response = execute.body();
        return JSONObject.parseObject(response);

    }

}

package com.github.cementwork.chatgpt.domain.impl;

import cn.hutool.Hutool;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.github.cementwork.chatgpt.config.ChatGptConfig;
import com.github.cementwork.chatgpt.domain.ChatGptService;
import com.github.cementwork.chatgpt.model.ImageResponse;
import com.github.cementwork.chatgpt.model.RequestDTO;
import com.github.cementwork.chatgpt.model.TextResponse;
import com.github.cementwork.chatgpt.util.HttpClientUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DATE: 2023/2/14
 * Description:
 * @author CementWork
 */
public class DefaultChatGptServiceImpl implements ChatGptService {

    private ChatGptConfig chatGptConfig;

    public DefaultChatGptServiceImpl(ChatGptConfig chatGptConfig){
        this.chatGptConfig = chatGptConfig;
    }

    @Override
    public List<String> sendMessageOfText(String message) {
        Map<String,Object> body = new HashMap<>(8);
        body.put("model",chatGptConfig.getModel());
        body.put("prompt",message);
        body.put("max_tokens",chatGptConfig.getMaxTokens());
        body.put("temperature",chatGptConfig.getTemperature());
        body.put("n",chatGptConfig.getTextN());
        Map<String,String> header = new HashMap<>(8);
        header.put("Content-Type","application/json");
        header.put("Authorization","Bearer " + chatGptConfig.getApiKey());
        JSONObject jsonObject = HttpClientUtil.doRequest("https://api.openai.com/v1/completions", null, body, header, RequestDTO.METHOD_POST, RequestDTO.TYPE_JSON);
        TextResponse textResponse = JSONObject.parseObject(jsonObject.toJSONString(), TextResponse.class);
        if (ObjectUtil.isEmpty(textResponse) || ObjectUtil.isEmpty(textResponse.getChoices())){
           return null;
        }
        return textResponse.getChoices().stream().map(item -> item.getText()).collect(Collectors.toList());
    }

    @Override
    public List<String> sendMessageOfImages(String message) {
        Map<String,Object> body = new HashMap<>(8);
        body.put("prompt",message);
        body.put("n",chatGptConfig.getImageN());
        body.put("size",chatGptConfig.getSize());
        Map<String,String> header = new HashMap<>(8);
        header.put("Content-Type","application/json");
        header.put("Authorization","Bearer " + chatGptConfig.getApiKey());
        JSONObject jsonObject = HttpClientUtil.doRequest("https://api.openai.com/v1/images/generations", null, body, header, RequestDTO.METHOD_POST, RequestDTO.TYPE_JSON);
        ImageResponse imageResponse = JSONObject.parseObject(jsonObject.toJSONString(), ImageResponse.class);
        if (ObjectUtil.isEmpty(imageResponse) || ObjectUtil.isEmpty(imageResponse.getData())){
            return null;
        }
        return imageResponse.getData().stream().map(item -> item.getUrl()).collect(Collectors.toList());
    }

}

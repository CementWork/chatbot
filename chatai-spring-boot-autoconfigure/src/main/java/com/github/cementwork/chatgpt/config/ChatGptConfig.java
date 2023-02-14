package com.github.cementwork.chatgpt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DATE: 2023/2/14
 * Description:
 * @author CementWork
 */
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGptConfig {

    private String apiKey = "";

    private String model = "text-davinci-003";

    private Integer maxTokens = 2048;

    private Double temperature = 0.0;

    private Integer textN = 1;

    private Integer imageN = 1;

    private String size = "1024x1024";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getTextN() {
        return textN;
    }

    public void setTextN(Integer textN) {
        this.textN = textN;
    }

    public Integer getImageN() {
        return imageN;
    }

    public void setImageN(Integer imageN) {
        this.imageN = imageN;
    }
}

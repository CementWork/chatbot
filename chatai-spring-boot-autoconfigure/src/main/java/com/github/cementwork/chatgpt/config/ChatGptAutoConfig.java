package com.github.cementwork.chatgpt.config;

import com.github.cementwork.chatgpt.domain.impl.DefaultChatGptServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DATE: 2023/2/14
 * Description:
 * Author: gdq
 */
@Configuration
@EnableConfigurationProperties(ChatGptConfig.class)
public class ChatGptAutoConfig {


    @Bean(name = "chatGptService")
    public DefaultChatGptServiceImpl initChatGptService(ChatGptConfig chatGptConfig){
        return new DefaultChatGptServiceImpl(chatGptConfig);
    }
}

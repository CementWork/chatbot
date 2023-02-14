package com.github.cementwork.chatgpt.domain;

import java.util.List;

/**
 * DATE: 2023/2/14
 * Description:
 * @author CementWork
 */
public interface ChatGptService {

    /**
     * 消息问答
     * @param message
     * @return
     */
    List<String> sendMessageOfText(String message);


    /**
     * 图片生成
     * @param message
     * @return
     */
    List<String> sendMessageOfImages(String message);

}

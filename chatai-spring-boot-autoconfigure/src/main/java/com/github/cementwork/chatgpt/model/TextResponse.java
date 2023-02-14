package com.github.cementwork.chatgpt.model;

import java.util.List;

/**
 * DATE: 2023/2/14
 * Description:
 * Author: gdq
 */
public class TextResponse {
    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

    private Usage usage;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObject(){
        return this.object;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }
    public void setUsage(Usage usage){
        this.usage = usage;
    }
    public Usage getUsage(){
        return this.usage;
    }

    public static class Choices {
        private String text;

        private int index;

        private String logprobs;

        private String finish_reason;

        public void setText(String text){
            this.text = text;
        }
        public String getText(){
            return this.text;
        }
        public void setIndex(int index){
            this.index = index;
        }
        public int getIndex(){
            return this.index;
        }
        public void setLogprobs(String logprobs){
            this.logprobs = logprobs;
        }
        public String getLogprobs(){
            return this.logprobs;
        }
        public void setFinish_reason(String finish_reason){
            this.finish_reason = finish_reason;
        }
        public String getFinish_reason(){
            return this.finish_reason;
        }
    }

    public static class Usage {

        private int prompt_tokens;

        private int completion_tokens;

        private int total_tokens;

        public void setPrompt_tokens(int prompt_tokens){
            this.prompt_tokens = prompt_tokens;
        }
        public int getPrompt_tokens(){
            return this.prompt_tokens;
        }
        public void setCompletion_tokens(int completion_tokens){
            this.completion_tokens = completion_tokens;
        }
        public int getCompletion_tokens(){
            return this.completion_tokens;
        }
        public void setTotal_tokens(int total_tokens){
            this.total_tokens = total_tokens;
        }
        public int getTotal_tokens(){
            return this.total_tokens;
        }
    }

}

package com.github.cementwork.chatgpt.model;

import java.util.List;

/**
 * DATE: 2023/2/14
 * Description:
 * Author: gdq
 */
public class ImageResponse {


    private int created;

    private List<Data> data;

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }



}

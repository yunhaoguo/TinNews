package com.yunhaoguo.tinnews.retrofit.response;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.retrofit.response
 * 文件名:     News
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/9 6:22 PM
 * 描述:      TODO
 */

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class News {

    public String author;
    @NonNull
    public String title;
    public String description;
    public String url;
    @SerializedName("urlToImage")
    public String image;
    @SerializedName("publishedAt")
    public String time;

    public News() {

    }

    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }
}


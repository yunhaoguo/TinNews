package com.yunhaoguo.tinnews.retrofit.response;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.retrofit.response
 * 文件名:     BaseResponse
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/16 5:27 PM
 * 描述:      TODO
 */


import java.util.List;

public class BaseResponse {

    public String status;
    public int totalResults;
    public List<News> articles;
}

package com.yunhaoguo.tinnews.retrofit;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.retrofit
 * 文件名:     NewsRequestApi
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/16 5:34 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsRequestApi {

    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);
}

package com.yunhaoguo.tinnews.save;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save
 * 文件名:     SavedNewsContract
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/23 5:08 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.mvp.MvpContract;
import com.yunhaoguo.tinnews.retrofit.response.News;

import java.util.List;

public interface SavedNewsContract  {

    interface View extends MvpContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
    }
}

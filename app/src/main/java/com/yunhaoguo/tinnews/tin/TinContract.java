package com.yunhaoguo.tinnews.tin;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.tin
 * 文件名:     TinContract
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 5:59 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.mvp.MvpContract;
import com.yunhaoguo.tinnews.retrofit.response.News;

import java.util.List;

public interface TinContract {

    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData(String country);
        void saveFavoriteNews(News news);
    }
}

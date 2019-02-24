package com.yunhaoguo.tinnews.save;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save
 * 文件名:     SavedNewsPresenter
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/23 5:12 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.retrofit.response.News;

import java.util.List;

public class SavedNewsPresenter implements SavedNewsContract.Presenter {

    private final SavedNewsContract.Model model;
    private SavedNewsContract.View view;

    public SavedNewsPresenter() {
        model = new SavedNewsModel();
        model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
        this.view = view;
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null) {
            view.loadSavedNews(newsList);
        }
    }
}

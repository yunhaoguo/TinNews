package com.yunhaoguo.tinnews.tin;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.tin
 * 文件名:     TinPresenter
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 6:04 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.retrofit.response.News;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {

    private TinContract.View view;
    private TinContract.Model model;

    @Override
    public void onCreate() {
        this.model = new TinModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onViewAttached(TinContract.View view) {
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
    public void showNewsCard(List<News> newsList) {
        if (view != null) {
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);
    }
}

package com.yunhaoguo.tinnews.tin;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.tin
 * 文件名:     TinModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 6:01 PM
 * 描述:      TODO
 */


import android.annotation.SuppressLint;

import com.yunhaoguo.tinnews.TinApplication;
import com.yunhaoguo.tinnews.database.AppDatabase;
import com.yunhaoguo.tinnews.retrofit.NewsRequestApi;
import com.yunhaoguo.tinnews.retrofit.RetrofitClient;
import com.yunhaoguo.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TinModel implements TinContract.Model {

    private TinContract.Presenter presenter;


    private final NewsRequestApi newsRequestApi;

    private final AppDatabase database;

    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        database = TinApplication.getDataBase();
    }

    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void fetchData(String country) {
        newsRequestApi.getNewsByCountry(country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
            .subscribe(baseResponse -> {
                presenter.showNewsCard(baseResponse.articles);
            }, error -> {

            });
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Disposable disposable = Completable.fromAction(() -> database.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{

        }, error -> {

        });
    }
}

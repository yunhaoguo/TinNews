package com.yunhaoguo.tinnews.save;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save
 * 文件名:     SavedNewsModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/23 5:10 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.TinApplication;
import com.yunhaoguo.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {

    private SavedNewsContract.Presenter presenter;
    private final AppDatabase database;

    SavedNewsModel() {
        database = TinApplication.getDataBase();
    }

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        Disposable disposable = database.newsDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> {
                    presenter.loadSavedNews(news);
                }, error -> {
                    System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }
}

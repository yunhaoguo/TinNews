package com.yunhaoguo.tinnews.profile;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.profile
 * 文件名:     ProfileModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/7 9:47 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.TinApplication;
import com.yunhaoguo.tinnews.database.AppDatabase;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = TinApplication.getDataBase();

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void deleteAllNewsCache() {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            presenter.onCacheCleared();
        }, error -> {

        });

    }

    @Override
    public void setDefaultCountry(String country) {
        EventBus.getDefault().post(new CountryEvent(country));
    }

}

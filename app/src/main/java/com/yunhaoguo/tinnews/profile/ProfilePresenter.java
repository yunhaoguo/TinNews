package com.yunhaoguo.tinnews.profile;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.profile
 * 文件名:     ProfilePresenter
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/7 9:49 PM
 * 描述:      TODO
 */


import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View view;
    private ProfileContract.Model model;


    ProfilePresenter() {
        this.model = new ProfileModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
        }
    }

    @Override
    public void onViewAttached(ProfileContract.View view) {
        this.view = view;
        this.view.setView();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onCacheCleared() {
        if (view != null) {
            view.onCacheCleared();
        }

    }

    @Override
    public View.OnClickListener getCacheClearListener() {
        return view -> {
            model.deleteAllNewsCache();
        };

    }

    @Override
    public View.OnClickListener getOnCountryChangeListener(String country) {
        return view -> {
            model.setDefaultCountry(country);
        };

    }

}

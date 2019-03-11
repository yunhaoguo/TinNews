package com.yunhaoguo.tinnews.profile;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.profile
 * 文件名:     ProfileContract
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/7 9:47 PM
 * 描述:      TODO
 */


import com.yunhaoguo.tinnews.mvp.MvpContract;

public interface ProfileContract {

    interface View extends MvpContract.View<Presenter> {
        void setView();

        void onCacheCleared();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void onCacheCleared();

        android.view.View.OnClickListener getCacheClearListener();

        android.view.View.OnClickListener getOnCountryChangeListener(String country);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void deleteAllNewsCache();

        void setDefaultCountry(String country);
    }

}

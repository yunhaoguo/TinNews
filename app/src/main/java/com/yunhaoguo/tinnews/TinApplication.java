package com.yunhaoguo.tinnews;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews
 * 文件名:     TinApplication
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/5 5:09 PM
 * 描述:      TODO
 */


import android.app.Application;

import com.facebook.stetho.Stetho;

public class TinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

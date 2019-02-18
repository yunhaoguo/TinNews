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
import android.arch.persistence.room.Room;

import com.facebook.stetho.Stetho;
import com.yunhaoguo.tinnews.database.AppDatabase;

public class TinApplication extends Application {

    //Init the Room in the TinApplication
    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        //Init the Room in the TinApplication
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tin_db").build();
    }

    //Init the Room in the TinApplication
    public static AppDatabase getDataBase() {
        return database;
    }

}

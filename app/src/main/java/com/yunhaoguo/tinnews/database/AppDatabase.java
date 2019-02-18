package com.yunhaoguo.tinnews.database;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.database
 * 文件名:     AppDatabase
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 6:46 PM
 * 描述:      TODO
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.yunhaoguo.tinnews.retrofit.response.News;

@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();
}

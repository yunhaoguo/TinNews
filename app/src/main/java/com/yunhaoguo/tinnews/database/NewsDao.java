package com.yunhaoguo.tinnews.database;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.database
 * 文件名:     NewsDao
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 6:45 PM
 * 描述:      TODO
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.yunhaoguo.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

}

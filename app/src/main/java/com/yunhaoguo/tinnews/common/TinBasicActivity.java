package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     TinBasicActivity
 * 创建者:     yunhaoguo
 * 创建时间:    2019/1/29 11:21 PM
 * 描述:      TODO
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class TinBasicActivity extends AppCompatActivity implements TinFragmentManager{

    protected static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    @LayoutRes
    protected abstract int getLayout();

    @Override
    public void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra(BUNDLE, bundle);
        this.startActivity(intent);
        if (isFinished) {
            finish();
        }
    }

}

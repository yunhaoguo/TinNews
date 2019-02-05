package com.yunhaoguo.tinnews;

import android.os.Bundle;

import com.yunhaoguo.tinnews.common.TinBasicActivity;

public class MainActivity extends TinBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {

    }
}

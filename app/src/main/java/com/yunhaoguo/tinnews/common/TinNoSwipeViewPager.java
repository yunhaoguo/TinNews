package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     TinNoSwipeViewPager
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/7 10:15 PM
 * 描述:      TODO
 */


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class TinNoSwipeViewPager extends ViewPager {

    public TinNoSwipeViewPager(Context context) {
        super(context);
    }

    public TinNoSwipeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}

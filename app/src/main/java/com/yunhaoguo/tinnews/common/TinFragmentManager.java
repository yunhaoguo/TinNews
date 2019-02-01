package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     TinFragmentManager
 * 创建者:     yunhaoguo
 * 创建时间:    2019/1/29 11:20 PM
 * 描述:      TODO
 */


import android.os.Bundle;

public interface TinFragmentManager {

    //    void doFragmentTransaction(TinBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);
}

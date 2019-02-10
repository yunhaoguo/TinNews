package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     Util
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/9 6:24 PM
 * 描述:      TODO
 */

public class Util {

    private Util() {

    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0;
    }
}

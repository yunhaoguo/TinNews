package com.yunhaoguo.tinnews;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews
 * 文件名:     TinFragmentPageAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/7 10:11 PM
 * 描述:      TODO
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yunhaoguo.tinnews.common.ContainerFragment;

public class TinFragmentPagerAdapter extends FragmentPagerAdapter {
    public static final int FRAGMENT_NUMBER = 3;
    private Fragment[] fragments = new Fragment[FRAGMENT_NUMBER];


    public TinFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        for (int i = 0; i < fragments.length; i++) {
            fragments[i] = ContainerFragment.newInstance(i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return FRAGMENT_NUMBER;
    }
}

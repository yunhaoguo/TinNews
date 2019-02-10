package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     ContainerFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/7 10:34 PM
 * 描述:      TODO
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunhaoguo.tinnews.R;
import com.yunhaoguo.tinnews.save.SavedNewsFragment;
import com.yunhaoguo.tinnews.tin.TinGalleryFragment;

public class ContainerFragment extends TinBasicFragment {

    private int pageIndex;

    public static final int HOME_PAGE = 0;
    public static final String HOME_PAGE_TAG = "home_page";
    public static final int SAVE_PAGE = 1;
    public static final String SAVE_PAGE_TAG = "save_page";
    public static final int PROFILE_PAGE = 2;
    public static final String PROFILE_PAGE_TAG = "profile_page";

    private Fragment initFragment;

    public static ContainerFragment newInstance(int pageIndex) {
        ContainerFragment containerFragment = new ContainerFragment();
        containerFragment.pageIndex = pageIndex;
        containerFragment.initFragment = createInitFragmentByIndex(pageIndex);
        return containerFragment;
    }

    private static Fragment createInitFragmentByIndex(int pageIndex) {
        switch (pageIndex) {
            case HOME_PAGE:
                return TinGalleryFragment.newInstance();
            case SAVE_PAGE:
                return SavedNewsFragment.newInstance();
            case PROFILE_PAGE:
                return null;
            default:
                return null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment_container, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (initFragment != null && !initFragment.isAdded()) {
            //getChildFragmentManager is Container fragment's manager
            getChildFragmentManager().beginTransaction().replace(R.id.child_fragment_container, initFragment, getCurrentTag(pageIndex))
                    .commit();
        }
    }

    private String getCurrentTag(int pageIndex) {
        switch (pageIndex) {
            case R.id.action_tin:
                return HOME_PAGE_TAG;
            case R.id.action_save:
                return SAVE_PAGE_TAG;
            case R.id.action_profile:
                return PROFILE_PAGE_TAG;
            default:
                return "";
        }
    }

    public static int getPositionById(int id) {
        switch (id) {
            case R.id.action_tin:
                return HOME_PAGE;
            case R.id.action_save:
                return SAVE_PAGE;
            case R.id.action_profile:
                return PROFILE_PAGE;
            default:
                return -1;
        }
    }


}

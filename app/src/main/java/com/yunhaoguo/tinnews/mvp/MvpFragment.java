package com.yunhaoguo.tinnews.mvp;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.mvp
 * 文件名:     MvpFragment
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/17 5:53 PM
 * 描述:      TODO
 */


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yunhaoguo.tinnews.common.TinBasicFragment;

public abstract class MvpFragment<P extends MvpContract.Presenter> extends TinBasicFragment implements MvpContract.View<P> {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onViewAttached(this);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onViewDetached();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

}

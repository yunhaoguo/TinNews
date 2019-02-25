package com.yunhaoguo.tinnews.common;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.common
 * 文件名:     BaseViewModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/24 6:48 PM
 * 描述:      TODO
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewModel<V extends RecyclerView.ViewHolder> {

    private final int itemResourceId;


    public BaseViewModel(int itemResourceId) {
        this.itemResourceId = itemResourceId;
    }


    public V createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemResourceId, parent, false);
        return createItemViewHolder(view);
    }


    public abstract V createItemViewHolder(View view);


    public abstract void bindViewHolder(V holder);


    public int getViewType() {
        return itemResourceId;
    }
}

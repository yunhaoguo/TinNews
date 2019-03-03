package com.yunhaoguo.tinnews.save.detail;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save.detail
 * 文件名:     ReadmoreViewModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/2 6:35 PM
 * 描述:      TODO
 */


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yunhaoguo.tinnews.R;
import com.yunhaoguo.tinnews.WebViewActivity;
import com.yunhaoguo.tinnews.common.BaseViewModel;
import com.yunhaoguo.tinnews.common.TinFragmentManager;

import static com.yunhaoguo.tinnews.WebViewActivity.URL;

public class ReadmoreViewModel extends BaseViewModel<ReadmoreViewModel.ReadmoreViewModelHolder> {

    private final String uri;
    private final TinFragmentManager fragmentManager;
    public ReadmoreViewModel(String uri, TinFragmentManager fragmentManager) {
        super(R.layout.readmore_layout);
        this.uri = uri;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ReadmoreViewModelHolder createItemViewHolder(View view) {
        return new ReadmoreViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(ReadmoreViewModelHolder holder) {
        holder.readMore.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.readMore.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(URL, uri);
            fragmentManager.startActivityWithBundle(WebViewActivity.class, false, bundle);
        });
    }

    static class ReadmoreViewModelHolder extends RecyclerView.ViewHolder {
        TextView readMore;
        ReadmoreViewModelHolder(View itemView) {
            super(itemView);
            readMore = itemView.findViewById(R.id.readmore);
        }
    }
}


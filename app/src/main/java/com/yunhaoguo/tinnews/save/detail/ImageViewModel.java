package com.yunhaoguo.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yunhaoguo.tinnews.R;
import com.yunhaoguo.tinnews.common.BaseViewModel;

/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save.detail
 * 文件名:     ImageViewModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/2 6:32 PM
 * 描述:      TODO
 */


public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder> {

    private final String uri;
    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }

    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }

    static class ImageViewModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageViewModelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}


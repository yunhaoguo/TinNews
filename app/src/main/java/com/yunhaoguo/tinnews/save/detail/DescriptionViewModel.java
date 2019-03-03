package com.yunhaoguo.tinnews.save.detail;
/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save.detail
 * 文件名:     DescriptionViewModel
 * 创建者:     yunhaoguo
 * 创建时间:    2019/3/2 6:34 PM
 * 描述:      TODO
 */


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yunhaoguo.tinnews.R;
import com.yunhaoguo.tinnews.common.BaseViewModel;

public class DescriptionViewModel extends BaseViewModel<DescriptionViewModel.DescriptionViewHolder> {

    private final String description;

    public DescriptionViewModel(String description) {
        super(R.layout.description_layout);
        this.description = description;
    }

    @Override
    public DescriptionViewHolder createItemViewHolder(View view) {
        return new DescriptionViewHolder(view);
    }

    @Override
    public void bindViewHolder(DescriptionViewHolder holder) {
        holder.description.setText(description);
    }

    static class DescriptionViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        DescriptionViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
        }
    }
}


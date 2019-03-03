package com.yunhaoguo.tinnews.save;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhaoguo.tinnews.R;
import com.yunhaoguo.tinnews.common.TinFragmentManager;
import com.yunhaoguo.tinnews.retrofit.response.News;
import com.yunhaoguo.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.LinkedList;
import java.util.List;

/*
 * 项目名:     TinNews
 * 包名:      com.yunhaoguo.tinnews.save
 * 文件名:     SavedNewsAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2019/2/24 5:49 PM
 * 描述:      TODO
 */


public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {

    private List<News> newsList;
    private TinFragmentManager fragmentManager;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsAdapter(TinFragmentManager tinFragmentManager) {
        this.fragmentManager = tinFragmentManager;
        this.newsList = new LinkedList<>();
    }

    public void setNewsList(List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        this.notifyDataSetChanged();
    }

    @Override
    public SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SavedNewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.author.setText(news.getAuthor());
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
            }
        });
    }

    @DrawableRes
    private int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView description;
        ImageView icon;
        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }
}

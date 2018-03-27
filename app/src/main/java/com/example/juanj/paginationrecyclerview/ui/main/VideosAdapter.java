package com.example.juanj.paginationrecyclerview.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.juanj.paginationrecyclerview.R;
import com.example.juanj.paginationrecyclerview.models.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by juanj on 27/03/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {

    private List<Item> videos;

    public VideosAdapter() {
        videos = new ArrayList<>();
    }

    @Override
    public VideosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VideosAdapter.ViewHolder holder, int position) {
        holder.bind(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void refreshData(List<Item> items){
        if(items != null)
            videos.addAll(items);
        notifyItemChanged(videos.size() - 1 );
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_logo)
        public ImageView itemLogo;
        @BindView(R.id.item_title)
        public TextView itemTitle;
        @BindView(R.id.item_description)
        public TextView itemDescription;
        @BindView(R.id.item_date)
        public TextView itemDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Item item) {
            itemTitle.setText(item.getSnippet().getTitle());
            itemDescription.setText(item.getSnippet().getDescription());
            itemDate.setText(item.getSnippet().getPublishedAt());

            Glide.with(itemLogo.getContext()).load(item.getSnippet().getThumbnails().getDefault().getUrl()).into(itemLogo);
        }
    }
}

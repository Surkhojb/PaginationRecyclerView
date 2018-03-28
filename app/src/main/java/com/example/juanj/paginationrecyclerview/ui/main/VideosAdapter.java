package com.example.juanj.paginationrecyclerview.ui.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.juanj.paginationrecyclerview.R;
import com.example.juanj.paginationrecyclerview.models.Item;
import com.example.juanj.paginationrecyclerview.ui.utils.OnRecyclerItemClicked;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by juanj on 27/03/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {

    private List<Item> videos;
    private OnRecyclerItemClicked onRecyclerItemClicked;

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
        holder.bind(videos.get(position),position + 1 );
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

    public void setRecyclerItemClicked(OnRecyclerItemClicked listener){
        this.onRecyclerItemClicked = listener;
    }

    public Item getVideo(int position) {
        return videos.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_card_view)
        CardView itemCard;
        @BindView(R.id.item_logo)
        public ImageView itemLogo;
        @BindView(R.id.item_title)
        public TextView itemTitle;
        @BindView(R.id.item_date)
        public TextView itemDate;
        @BindView(R.id.item_num)
        public TextView itemNum;

        public ViewHolder(View itemView)  {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Item item,int num) {
            itemTitle.setText(item.getSnippet().getTitle());
            itemDate.setText(item.getSnippet().getPublishedAt());
            itemNum.setText(String.format("%d / %d",num,getItemCount()));
            Glide.with(itemLogo.getContext()).load(item.getSnippet().getThumbnails().getDefault().getUrl()).into(itemLogo);
            itemCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRecyclerItemClicked.onItemClicked(v,getAdapterPosition());
        }
    }
}

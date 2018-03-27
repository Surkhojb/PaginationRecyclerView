package com.example.juanj.paginationrecyclerview.ui.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by juanj on 27/03/2018.
 */

public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener{
    private LinearLayoutManager layoutManager;
    private int visibleItemCount = 0;
    private int totalItemCount = 0;
    private int firstVisibleItemPosition = 0;

    public OnLoadMoreListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount = layoutManager.getChildCount();
        totalItemCount = layoutManager.getItemCount();
        firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        if (!isLoading()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreData();
            }
        }
    }

    public abstract void loadMoreData();
    public abstract boolean isLoading();
}

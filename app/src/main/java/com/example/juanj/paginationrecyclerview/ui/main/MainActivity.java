package com.example.juanj.paginationrecyclerview.ui.main;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


import com.example.juanj.paginationrecyclerview.MyApplication;
import com.example.juanj.paginationrecyclerview.R;
import com.example.juanj.paginationrecyclerview.di.DaggerMainComponent;
import com.example.juanj.paginationrecyclerview.di.modules.MainModule;
import com.example.juanj.paginationrecyclerview.ui.detail.DetailActivity;
import com.example.juanj.paginationrecyclerview.ui.utils.OnLoadMoreListener;
import com.example.juanj.paginationrecyclerview.ui.utils.OnRecyclerItemClicked;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements OnRecyclerItemClicked{
    private boolean isLoadingMore = false;

    @BindView(R.id.pb_loading_more)
    ProgressBar pbLoading;
    @BindView(R.id.rv_list_videos)
    RecyclerView rvList;

    VideosAdapter rvAdapter;

    @Inject
    MainViewModelFactory factory;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        injectDependencies();
        initView();

        mainViewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        mainViewModel.listVideos().observe(this,items -> {
            rvAdapter.refreshData(items);
            pbLoading.setVisibility(View.GONE);
            isLoadingMore = false;
        });
        mainViewModel.search(isLoadingMore);
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvAdapter = new VideosAdapter();
        rvList.setAdapter(rvAdapter);

        rvList.addOnScrollListener(new OnLoadMoreListener(layoutManager) {
            @Override
            public void loadMoreData() {
                isLoadingMore = true;
                pbLoading.setVisibility(View.VISIBLE);
                mainViewModel.search(isLoadingMore);
            }

            @Override
            public boolean isLoading() {
                return isLoadingMore;
            }
        });

    }

    @Override
    public void onItemClicked(View v, int position) {
        Intent intentToDetails = new Intent(this, DetailActivity.class);
        intentToDetails.putExtra(DetailActivity.EXTRA_VIDEO,rvAdapter.getVideo(position));

        startActivity(intentToDetails);
    }

    private void injectDependencies() {
       DaggerMainComponent.builder()
               .appComponent(MyApplication.getComponent())
               .mainModule(new MainModule())
               .build()
               .inject(this);
    }
}

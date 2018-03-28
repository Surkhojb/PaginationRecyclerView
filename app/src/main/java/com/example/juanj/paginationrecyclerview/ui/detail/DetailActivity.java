package com.example.juanj.paginationrecyclerview.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juanj.paginationrecyclerview.BuildConfig;
import com.example.juanj.paginationrecyclerview.R;
import com.example.juanj.paginationrecyclerview.models.Video;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_VIDEO = "video";

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Video video = (Video) getIntent().getExtras().get(EXTRA_VIDEO);
        ButterKnife.bind(this);
        loadView(video);

    }

    private void loadView(Video video) {
        System.out.println(video.toString());
        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.youtubeFragment);

        youTubePlayerFragment.initialize(BuildConfig.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(video.getVideoId());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
               Toast.makeText(getApplicationContext(),"Error loading video",Toast.LENGTH_SHORT).show();
            }
        });
        tvTitle.setText(video.getTitle());
        tvDescription.setText(video.getDescription());
    }

    }

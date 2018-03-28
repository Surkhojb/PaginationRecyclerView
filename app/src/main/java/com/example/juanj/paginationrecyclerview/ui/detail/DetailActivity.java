package com.example.juanj.paginationrecyclerview.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juanj.paginationrecyclerview.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_VIDEO = "video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}

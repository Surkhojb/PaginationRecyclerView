package com.example.juanj.paginationrecyclerview.models;

import com.example.juanj.paginationrecyclerview.data.remote.model.Item;
import com.example.juanj.paginationrecyclerview.data.remote.model.YoutubeResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by juanj on 28/03/2018.
 */

public class VideoTransformer implements Mapper<Video,Item>{

    @Inject
    public VideoTransformer(){}

    @Override
    public Video map(Item itemVO) {
        Video video = new Video();
        video.setVideoId(itemVO.getId().getVideoId());
        video.setTitle(itemVO.getSnippet().getTitle());
        video.setDescription(itemVO.getSnippet().getDescription());
        video.setThumbnailHigh(itemVO.getSnippet().getThumbnails().getHigh().getUrl());
        video.setPublishedAt(itemVO.getSnippet().getPublishedAt());
        return video;
    }

    @Override
    public Item inverse(Video model) {
        return null;
    }

    public List<Video> transform(YoutubeResponse response){
        List<Video> videos = new ArrayList<>();
        for(Item item : response.getItems())
            videos.add(map(item));

        return videos;
    }
}


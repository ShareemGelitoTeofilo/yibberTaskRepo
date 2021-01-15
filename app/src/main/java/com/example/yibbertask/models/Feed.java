package com.example.yibbertask.models;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private String author;
    private String title;
    private String uploadTime;
    private String duration;
    private long durationInSec;
    private String thumbnail;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getThumbnailName() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public static List<Feed> createRecords() {
        List<Feed> feeds = new ArrayList<>();
        Feed feed = new Feed();
        feed.setAuthor("shareemteofilo");
        feed.setDurationInSec(95);
        feed.setTitle("Boracay Escapade");
        feed.setUploadTime("1 min ago");
        feed.setThumbnail("beach");
        feeds.add(feed);
        Feed nightBeachFeed = new Feed();
        nightBeachFeed.setAuthor("shareemteofilo");
        nightBeachFeed.setDurationInSec(300);
        nightBeachFeed.setTitle("Night Beach");
        nightBeachFeed.setUploadTime("1 week ago");
        nightBeachFeed.setThumbnail("nightbeach");
        feeds.add(nightBeachFeed);
        Feed surfFeed = new Feed();
        surfFeed.setAuthor("shareemteofilo");
        surfFeed.setDurationInSec(165);
        surfFeed.setTitle("Surfing");
        surfFeed.setUploadTime("3 week ago");
        surfFeed.setThumbnail("surf");
        feeds.add(surfFeed);
        return feeds;
    }

    public long getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(long durationInSec) {
        this.durationInSec = durationInSec;
    }
}

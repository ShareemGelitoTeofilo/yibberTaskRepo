package com.example.yibbertask.models;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private String author;
    private String title;
    private String uploadTime;
    private String duration;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        feed.setDuration("41:90");
        feed.setTitle("Boracay Escapade");
        feed.setUploadTime("1 min ago");
        feed.setThumbnail("beach");
        feeds.add(feed);
        Feed nightBeachFeed = new Feed();
        nightBeachFeed.setAuthor("shareemteofilo");
        nightBeachFeed.setDuration("12:45");
        nightBeachFeed.setTitle("Night Beach");
        nightBeachFeed.setUploadTime("1 week ago");
        nightBeachFeed.setThumbnail("nightbeach");
        feeds.add(nightBeachFeed);
        Feed surfFeed = new Feed();
        surfFeed.setAuthor("shareemteofilo");
        surfFeed.setDuration("23:45");
        surfFeed.setTitle("Surfing");
        surfFeed.setUploadTime("3 week ago");
        surfFeed.setThumbnail("surf");
        feeds.add(surfFeed);
        return feeds;
    }
}

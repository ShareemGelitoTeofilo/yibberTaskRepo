package com.example.yibbertask.models

data class FeedData(var author: String, var title: String, var uploadTime: String, var durationInSec: Long, var thumbnail: String) {
    companion object {
        fun createRecords(): List<FeedData> {
            val feeds = ArrayList<FeedData>()

            val feed = FeedData("shareemteofilo", "Boracay Escapade", "1 min ago", 95, "beach")
            val nighBeachFeed =
                FeedData("shareemteofilo", "Night Beach", "1 week ago", 300, "nightbeach")
            val surfFeed = FeedData("shareemteofilo", "Surfing", "3 weeks ago", 165, "surf")

            feeds.addAll(listOf(feed, nighBeachFeed, surfFeed))
            return feeds
        }
    }
}
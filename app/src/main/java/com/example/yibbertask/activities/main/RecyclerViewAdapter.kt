package com.example.yibbertask.activities.main

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yibbertask.R
import com.example.yibbertask.models.FeedData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewAdapter(var feeds: List<FeedData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val mView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_feeds_item, parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feed: FeedData = feeds[position]

        val thumbnailContext: Context = holder.thumbnail.context
        val thumbnailId: Int = thumbnailContext.resources.getIdentifier(
            feed.thumbnail,
            "drawable",
            thumbnailContext.packageName
        )
        holder.thumbnail.setImageResource(thumbnailId)
        //holder.thumbnail.clipToOutline = true

        holder.title.text = feed.title
        holder.uploadTime.text = feed.uploadTime
        holder.author.text = feed.author
        holder.durationStatus.text = convertTimeToText(feed.durationInSec - holder.progress)
        holder.progressBar.max = feed.durationInSec.toInt()

        val handler = Handler()
        val progressBarAnimationRunnable = Runnable {
            while (holder.progress < feed.durationInSec && holder.playing) {
                holder.progress += 1
                handler.post {
                    holder.progressBar.progress = holder.progress.toInt()
                    holder.durationStatus.text =
                        convertTimeToText(feed.durationInSec - holder.progress)
                }
                Thread.sleep(1000)
            }
        }

        holder.playButton.setOnClickListener {
            holder.progressBar.visibility = View.VISIBLE
            holder.playing = !holder.playing
            Thread(progressBarAnimationRunnable).start()
            val playButtonImageRes =
                if (holder.playing) R.drawable.baseline_pause_white_18dp else R.drawable.baseline_play_arrow_white_18dp
            holder.playButton.setImageResource(playButtonImageRes)
        }
    }

    override fun getItemCount(): Int {
        return feeds.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var progress: Long = 0
        var playing: Boolean = false
        var title: TextView = itemView.findViewById(R.id.titleText)
        var author: TextView = itemView.findViewById(R.id.authorText)
        var uploadTime: TextView = itemView.findViewById(R.id.uploadTimeText)
        var durationStatus: TextView = itemView.findViewById(R.id.durationStatusText)
        var thumbnail: ImageView = itemView.findViewById(R.id.feedThumbnailImageView)
        var progressBar: ProgressBar = itemView.findViewById(R.id.my_progressBar)
        var playButton: FloatingActionButton = itemView.findViewById(R.id.playButton)

        init {
            thumbnail.clipToOutline = true
        }
    }

    private fun convertTimeToText(timeInSec: Long): String {
        var remainder: Long;
        val minutes = timeInSec / 60;
        remainder = timeInSec - (minutes * 60);
        val seconds = remainder;
        val minutesString = if (minutes > 9) minutes.toString() else String.format("0%s", minutes)
        val secondsString = if (seconds > 9) seconds.toString() else String.format("0%s", seconds);
        return String.format("%s:%s", minutesString, secondsString)
    }
}
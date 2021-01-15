package com.example.yibbertask.activities.main;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yibbertask.R;
import com.example.yibbertask.models.Feed;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Feed> feeds;

    public RecyclerViewAdapter(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_feeds_item, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Feed feed = feeds.get(position);

        // Set thumbnail
        Context context = holder.thumbnail.getContext();
        int thumbnailId = context.getResources().getIdentifier(feed.getThumbnailName(), "drawable", context.getPackageName());
        holder.thumbnail.setImageResource(thumbnailId);
        holder.thumbnail.setClipToOutline(true);

        holder.title.setText(feed.getTitle());
        holder.uploadTime.setText(feed.getUploadTime());
        holder.author.setText(feed.getAuthor());
        holder.durationStatus.setText(convertTimeToText(feed.getDurationInSec() - holder.progress));
        holder.progressBar.setMax((int) feed.getDurationInSec());

        final Handler handler = new Handler();

        holder.playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                holder.progressBar.setVisibility(View.VISIBLE);
                holder.playing = !holder.playing;
                new Thread(new Runnable() {
                    public void run() {
                        while (holder.progress < feed.getDurationInSec() && holder.playing) {
                            holder.progress += 1;
                            // Update the progress bar and display the
                            //current value in the text view
                            handler.post(new Runnable() {
                                public void run() {
                                    holder.progressBar.setProgress((int) holder.progress);
                                    holder.durationStatus.setText(convertTimeToText(feed.getDurationInSec() - holder.progress));
                                }
                            });
                            try {
                                // Sleep for 200 milliseconds.
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                if (holder.playing) {
                    holder.playButton.setImageResource(R.drawable.baseline_pause_white_18dp);
                } else {
                    holder.playButton.setImageResource(R.drawable.baseline_play_arrow_white_18dp);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        long progress = 0;
        boolean playing = false;
        TextView title, author, uploadTime, durationStatus;
        ImageView thumbnail;
        ProgressBar progressBar;
        FloatingActionButton playButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            author = itemView.findViewById(R.id.authorText);
            uploadTime = itemView.findViewById(R.id.uploadTimeText);
            thumbnail = itemView.findViewById(R.id.feedThumbnailImageView);
            durationStatus = itemView.findViewById(R.id.durationStatusText);
            progressBar = itemView.findViewById(R.id.my_progressBar);
            playButton = itemView.findViewById(R.id.playButton);

            thumbnail.setClipToOutline(true);
        }
    }

    private String convertTimeToText(long timeInSec) {
        long remainder = 0;
        long minutes = timeInSec / 60;
        remainder = timeInSec - (minutes * 60);
        long seconds = remainder;
        String minutesString = minutes > 9 ? String.valueOf(minutes) : String.format("0%s", minutes);
        String secondsString = seconds > 9 ? String.valueOf(seconds) : String.format("0%s", seconds);
        return String.format("%s:%s", minutesString, secondsString);
    }
}

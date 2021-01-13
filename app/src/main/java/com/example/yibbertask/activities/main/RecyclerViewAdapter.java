package com.example.yibbertask.activities.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yibbertask.R;
import com.example.yibbertask.models.Feed;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feed feed = feeds.get(position);

        // Set thumbnail
        Context context = holder.thumbnail.getContext();
        int thumbnailId = context.getResources().getIdentifier(feed.getThumbnailName(), "drawable", context.getPackageName());
        holder.thumbnail.setImageResource(thumbnailId);

        holder.title.setText(feed.getTitle());
        holder.uploadTime.setText(feed.getUploadTime());
        holder.author.setText(feed.getAuthor());
        holder.durationStatus.setText(feed.getDuration());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, author, uploadTime, durationStatus;
        ImageView thumbnail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            author = itemView.findViewById(R.id.authorText);
            uploadTime = itemView.findViewById(R.id.uploadTimeText);
            thumbnail = itemView.findViewById(R.id.feedThumbnailImageView);
            durationStatus = itemView.findViewById(R.id.durationStatusText);
        }
    }
}

package com.example.yibbertask.activities.main.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yibbertask.R;
import com.example.yibbertask.activities.main.RecyclerViewAdapter;
import com.example.yibbertask.models.Feed;

import java.util.ArrayList;
import java.util.List;

public class FragmentPosts extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    public FragmentPosts() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_posts, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewPosts);

        List<Feed> feeds = Feed.createRecords();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(feeds);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
package com.example.yibbertask.activities.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yibbertask.R
import com.example.yibbertask.activities.main.RecyclerViewAdapter
import com.example.yibbertask.models.FeedData

class FragmentShared : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_shared, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewPosts)
        val adapter = RecyclerViewAdapter(FeedData.createRecords())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        return view
    }
}
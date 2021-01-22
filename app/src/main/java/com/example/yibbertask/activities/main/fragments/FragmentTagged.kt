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

class FragmentTagged: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_tagged, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewPosts)
        val recyclerViewAdapter = RecyclerViewAdapter(FeedData.createRecords())
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        return view
    }
}
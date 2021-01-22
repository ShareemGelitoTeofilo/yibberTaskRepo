package com.example.yibbertask.activities.main

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.yibbertask.R
import com.example.yibbertask.activities.main.fragments.*
import com.google.android.material.tabs.TabLayout

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val profileImageView: ImageView = findViewById(R.id.profileImageView)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FragmentPosts(), "Posts");
        viewPagerAdapter.addFragment(FragmentThreads(), "Threads");
        viewPagerAdapter.addFragment(FragmentShared(), "Shared");
        viewPagerAdapter.addFragment(FragmentTagged(), "Tagged");

        // setup adapter and tabs
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.isTabIndicatorFullWidth = false

        // update profile photo shape according to background using clipping technique
        profileImageView.clipToOutline = true
    }
}
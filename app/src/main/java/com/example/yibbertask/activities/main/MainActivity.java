package com.example.yibbertask.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.yibbertask.R;
import com.example.yibbertask.activities.main.fragments.FragmentPosts;
import com.example.yibbertask.activities.main.fragments.FragmentShared;
import com.example.yibbertask.activities.main.fragments.FragmentTagged;
import com.example.yibbertask.activities.main.fragments.FragmentThreads;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.viewPager);
        profileImageView = findViewById(R.id.profileImageView);
        // add fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentPosts(), "Posts");
        adapter.addFragment(new FragmentThreads(), "Threads");
        adapter.addFragment(new FragmentShared(), "Shared");
        adapter.addFragment(new FragmentTagged(), "Tagged");
        // adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabIndicatorFullWidth(false);
        // update profile photo shape
        profileImageView.setClipToOutline(true);
    }
}
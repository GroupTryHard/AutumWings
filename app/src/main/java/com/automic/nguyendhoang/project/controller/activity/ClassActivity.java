package com.automic.nguyendhoang.project.controller.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.automic.nguyendhoang.project.R;
import com.automic.nguyendhoang.project.adapter.TabFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    TabFragmentAdapter mTabFragmentAdapter;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        ButterKnife.bind(this);

        setupView();
    }

    private void setupView() {
        setupToolBar();
        setupTablayout();
    }

    private void setupTablayout() {
        mTabFragmentAdapter = new TabFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(mTabFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i=0; i<tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setCustomView(mTabFragmentAdapter.getView(i));
        }
    }


    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Class Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}

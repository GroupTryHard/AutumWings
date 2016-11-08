package com.automic.nguyendhoang.project.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.automic.nguyendhoang.project.R;
import com.automic.nguyendhoang.project.controller.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen.D.Hoang on 11/8/2016.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> mFragmentPagerAdapters;

    private int[] icons = new int[]{
            R.drawable.ic_import_contacts,
            R.drawable.ic_person
    };

    private final String[] mTitles = new String[]{
            "Home", "Personal"
    };

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        mFragmentPagerAdapters = new ArrayList<>();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SimpleFragment().newInstance(getPageTitle(position).toString());
        mFragmentPagerAdapters.add(fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public View getView(int position) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
        ImageView ivIcon = (ImageView) tabView.findViewById(R.id.ivIcon);
        ivIcon.setImageDrawable(ContextCompat.getDrawable(mContext, icons[position]));
        TextView tvTitle = (TextView) tabView.findViewById(R.id.tvTitle);
        tvTitle.setText(getPageTitle(position));
        return tabView;
    }
}

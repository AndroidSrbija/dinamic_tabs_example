package com.example.android_srbija.tabbedactivityexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Tab> mTabs;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        mTabs = new ArrayList<>();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return mTabs.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }

    public void addTab(final ViewPager viewPager, TabLayout tabLayout) {
        mTabs.add(new Tab("Tab ", (getCount() + 1), new TabFragment()));

        notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(getCount() - 1, true);
    }
}
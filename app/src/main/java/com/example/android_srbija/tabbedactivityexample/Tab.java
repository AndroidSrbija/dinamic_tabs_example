package com.example.android_srbija.tabbedactivityexample;

public class Tab {

    private String mTitle;
    private BaseTabFragment mFragment;

    public Tab(String title, int itemCount, BaseTabFragment fragment) {
        mTitle = title + " " + itemCount;

        mFragment = fragment;
        mFragment.setSectionNumber(itemCount);
    }

    public String getTitle() {
        return mTitle;
    }

    public BaseTabFragment getFragment() {
        return mFragment;
    }
}

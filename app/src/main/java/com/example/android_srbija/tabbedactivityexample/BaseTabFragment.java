package com.example.android_srbija.tabbedactivityexample;

import android.support.v4.app.Fragment;

public abstract class BaseTabFragment extends Fragment {

    protected int mSectionNumber;

    public BaseTabFragment() {
        super();
    }

    public void setSectionNumber(int sectionNumber) {
        mSectionNumber = sectionNumber;
    }
}

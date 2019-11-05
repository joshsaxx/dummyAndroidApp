package com.example.mydummyproj;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int NumOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumofTabs) {
        super(fm);
        this.NumOfTabs=NumofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new StoriesTabFragment();
            case 1: return new EventsTabFragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}

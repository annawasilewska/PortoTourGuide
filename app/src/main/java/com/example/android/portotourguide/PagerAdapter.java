package com.example.android.portotourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by soonsoon on 2017-03-16.
 */

    public class PagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CenterFragment();
        } else if (position == 1){
            return new ShoreFragment();
        } else if (position == 2){
            return new FoodFragment();
        } else {
            return new DanceFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.title_center);
        } else if (position == 1) {
            return mContext.getString(R.string.title_shore);
        } else if (position == 2) {
            return mContext.getString(R.string.title_food);
        } else {
            return mContext.getString(R.string.title_dance);
        }
    }
}

package com.qianfeng.hyh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 16-9-5.
 */
public class HeaderVideoVpAdapter extends FragmentStatePagerAdapter {


    List<Fragment> list;

    public HeaderVideoVpAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {

        Log.d("hyh","HeaderVideoVpAdapter+++getItem======"+list.get(position));
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}

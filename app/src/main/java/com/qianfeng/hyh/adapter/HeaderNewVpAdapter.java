package com.qianfeng.hyh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by Administrator on 16-9-5.
 */
public class HeaderNewVpAdapter extends FragmentStatePagerAdapter {

    List<Fragment> list;

    public HeaderNewVpAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("zsp","99999====="+list.get(position));
        return list.get(position);
    }

    @Override
    public int getCount() {
        Log.d("zsp","99999====="+list.size());
        return list.size();
    }



}

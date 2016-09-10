package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.hyh.adapter.Fragment1VpAdapter;
import com.qianfeng.hyh.bean.Bean1;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment implements ViewPager.OnPageChangeListener {

     ViewPager viewPager;
    LinearLayout modelLayout;
    View navigationView;
    List<Fragment> list;
    Fragment1VpAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment1,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.FragmentViewpagerId);
        modelLayout= (LinearLayout) view.findViewById(R.id.liearlayoutHead);
        navigationView=view.findViewById(R.id.textViewLine);
        initData();
        adapter=new Fragment1VpAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        modelLayoutEvent();

    }
    private void modelLayoutEvent() {
        TextView textView;
        for (int i = 0; i < modelLayout.getChildCount(); i++) {
            textView=(TextView) modelLayout.getChildAt(i);
            textView.setTag(i);
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int position=(Integer) v.getTag();
                    viewPager.setCurrentItem(position);

                }
            });
        }

    }

    private void initData() {
        list=new ArrayList<>();
       Fragmentjingxuan jingXuan=new Fragmentjingxuan();
        Fragmentqicai qiCai=new Fragmentqicai();
        Fragmentyingxiang yingXiang=new Fragmentyingxiang();
        Fragmentxueyuan xueYuan=new Fragmentxueyuan();
        list.add(jingXuan);
        list.add(qiCai);
        list.add(yingXiang);
        list.add(xueYuan);
        Log.d("hyh","LIST================"+list.size());

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        LinearLayout.LayoutParams params=
                (LinearLayout.LayoutParams) navigationView.getLayoutParams();
        params.leftMargin=(int) ((position+positionOffset)
                *navigationView.getWidth());
        navigationView.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        TextView textView;
        for (int i = 0; i < modelLayout.getChildCount(); i++) {
            textView=(TextView) modelLayout.getChildAt(i);
            if (position==i) {
                textView.setTextColor(Color.RED);
            }else {
                textView.setTextColor(Color.BLACK);
            }


        }
        textView=(TextView) modelLayout.getChildAt(position);

        int left=textView.getLeft();

        int displayWidth=getResources().getDisplayMetrics().widthPixels;
        int textWidth=textView.getWidth();

        int offset=left-displayWidth/2+textWidth/2;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

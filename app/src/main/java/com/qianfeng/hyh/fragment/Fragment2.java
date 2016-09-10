package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianfeng.hyh.adapter.Fragment2VpAdapter;
import com.qianfeng.hyh.lepai.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment implements ViewPager.OnPageChangeListener {


    ViewPager viewPager;
    LinearLayout modelLayout1;
    View navigationView;
    List<Fragment> list;
    Fragment2VpAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment2,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager= (ViewPager) view.findViewById(R.id.f2viewpager);
        modelLayout1= (LinearLayout) view.findViewById(R.id.liearlayoutHead2);
        navigationView=view.findViewById(R.id.f2viewLineId);
        initData();

        adapter=new Fragment2VpAdapter(getFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);


        modelLayoutEvent();
    }

    private void modelLayoutEvent() {
        TextView textView;
        for (int i = 0; i < modelLayout1.getChildCount(); i++) {
            textView=(TextView) modelLayout1.getChildAt(i);
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
        Fragmentrenxiang renxiang=new Fragmentrenxiang();
        Fragmentfengguang fengguan=new Fragmentfengguang();
        Fragmentshengtai shengtai=new Fragmentshengtai();
        Fragmentshuma shuma=new Fragmentshuma();
        list.add(renxiang);
        list.add(fengguan);
        list.add(shengtai);
        list.add(shuma);


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
        for (int i = 0; i < modelLayout1.getChildCount(); i++) {
            textView=(TextView) modelLayout1.getChildAt(i);
            if (position==i) {
                textView.setTextColor(Color.RED);



            }else {
                textView.setTextColor(Color.BLACK);
            }


        }
        textView=(TextView) modelLayout1.getChildAt(position);

        int left=textView.getLeft();

        int displayWidth=getResources().getDisplayMetrics().widthPixels;
        int textWidth=textView.getWidth();

        int offset=left-displayWidth/2+textWidth/2;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

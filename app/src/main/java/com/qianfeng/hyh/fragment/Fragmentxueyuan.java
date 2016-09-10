package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import com.qianfeng.hyh.adapter.CollegeGridAdapter;
import com.qianfeng.hyh.adapter.HeaderCollegeVpAdapter;
import com.qianfeng.hyh.bean.CollegeBean;
import com.qianfeng.hyh.bean.VideoBean;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;


public class Fragmentxueyuan extends Fragment {
     PullToRefreshGridView gridView;
     Handler handler;
     List<CollegeBean.ListBean> dataList;
      final  String URL_STRING="http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=190&page=";
      int page=1;
     CollegeGridAdapter adapter;

    ViewPager viewPager;
    List<Fragment> ftList;
    LinearLayout potLayout;//放置导航圈圈资源
    private static int prePosition=0;//记录上次被选择的页数
    HeaderCollegeVpAdapter headerCollegeVpAdapter;

    // 判断是否自动滚动viewPager
    private boolean isRunning = true;
    private Handler handler2 = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //执行滑动到下一个页面
            if(prePosition==2){
                viewPager.setCurrentItem(0);

            }else{
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
            if (isRunning) {
                // 在发一个handler延时
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler2.sendEmptyMessageDelayed(0, 3000);
                    }
                }).start();
            }
        }
    };
     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_fragmentxueyuan,null);
          gridView= (PullToRefreshGridView) view.findViewById(R.id.collegeGridViewId);
          handler=new Handler();
          dataList=new ArrayList<>();
         viewPager= (ViewPager) view.findViewById(R.id.collegeheaderpergerId);
         potLayout= (LinearLayout) view.findViewById(R.id.collegedotnewViewpagerId);
         return view;
     }

    private void initData() {
        ftList=new ArrayList<>();
        CollegeHeaderFragment chf=new CollegeHeaderFragment();
        CollegeHeaderFragment2 chf2=new CollegeHeaderFragment2();
        CollegeHeaderFragment3 chf3=new CollegeHeaderFragment3();
        ftList.add(chf);
        ftList.add(chf2);
        ftList.add(chf3);
        Log.d("hyh","学院ininDataftList================"+ftList.size());
    }

    @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated(view, savedInstanceState);

        initData();
        Log.d("hyh","学院headerCollegeVpAdapterftList================"+ftList.size());
        headerCollegeVpAdapter=new HeaderCollegeVpAdapter(getFragmentManager(),ftList);

        Log.d("hyh","学院headerCollegeVpAdapter================"+headerCollegeVpAdapter);
        for (int i = 0; i <ftList.size() ; i++) {
            View view1=new View(getActivity());
            LinearLayout.LayoutParams params1=new
                    LinearLayout.LayoutParams(15, 15);//给view设置一个宽高
            params1.leftMargin=5;//设置间隔
            Log.d("hyh","学院ftList==============="+ftList.size());
            view1.setLayoutParams(params1);
            view1.setBackgroundResource(R.drawable.point_hui);
            //设置默认的dot图片给view做背景
            potLayout.addView(view1);//将view添加给导航布局

            view1.setTag(i);
            //给view设置点击事件---点击后viewpager要联动
            view1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO 用view来携带点击的位置信息,
                    //将viewpager设置成点击的页面
                    int position=(Integer) v.getTag();
                    viewPager.setCurrentItem(position);
                }
            });
        }

        //使用Linearlayout去子控件来设置默认的选项
        potLayout.getChildAt(0).setBackgroundResource(R.drawable.point_h);

        viewPager.setAdapter(headerCollegeVpAdapter);
        Log.d("hyh","学院setAdapter==============="+headerCollegeVpAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                potLayout.getChildAt(position).
                        setBackgroundResource(R.drawable.point_h);
                //将上次选择的导航圈还原
                potLayout.getChildAt(prePosition).
                        setBackgroundResource(R.drawable.point_hui);
                prePosition=position;
            }
            @Override
            public void onPageScrolled(int position, float
                    positionOffset, int positionOffsetPixels) {
                // TODO 监听页面滑动变化  参数1---页数  参数2---次页数滑动的偏移量(0--1)
                //参数3----次页数实际滑动的偏移值
                Log.d("hyh", "position==="+position);
                Log.d("hyh", "positionOffset==="+positionOffset);
                Log.d("hyh", "positionOffsetPixels==="+positionOffsetPixels);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // TODO 监听滑动状态的改变    SCROLL_STATE_IDLE
            }
        });
        //发送轮播消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler2.sendEmptyMessageDelayed(0, 3000);
            }
        }).start();

         new Thread(new Runnable() {
              @Override
              public void run() {
                String jsonstr= DownLoadUtils.getJsonString(URL_STRING+page);
                  Log.d("hyh","我在学院解析json=============="+jsonstr);
                  Log.d("hyh","我在学院解析上面");
              CollegeBean collegeBean=JSONObject.parseObject(jsonstr,CollegeBean.class);
                  Log.d("hyh","我在学院解析下面");
                   dataList=collegeBean.getList();
                   handler.post(new Runnable() {
                        @Override
                        public void run() {
                         adapter=new CollegeGridAdapter(getActivity(),dataList);
                             gridView.setAdapter(adapter);
                        }
                   });

              }
         }).start();
         gridView.setMode(PullToRefreshBase.Mode.BOTH);
         gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
             @Override
             public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {

             }

             @Override
             public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         page=page+1;
                         String jsonstr=DownLoadUtils.getJsonString(URL_STRING+page);
                         CollegeBean collegeBean=JSONObject.parseObject(jsonstr,CollegeBean.class);
                         List<CollegeBean.ListBean> preList=new ArrayList<CollegeBean.ListBean>();
                         preList=collegeBean.getList();
                         for (int i = 0; i <preList.size() ; i++) {
                             dataList.add(preList.get(i));

                         }
                         handler.post(new Runnable() {
                             @Override
                             public void run() {
                                 adapter.notifyDataSetChanged();
                                 gridView.onRefreshComplete();
                             }
                         });

                     }
                 }).start();
             }
         });


     }

}

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
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.hyh.adapter.HeaderNewVpAdapter;
import com.qianfeng.hyh.adapter.MyAdapter1;
import com.qianfeng.hyh.bean.Bean1;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragmentjingxuan extends Fragment {
    PullToRefreshListView pListView;
    Handler handler;
    MyAdapter1 adapter1;
    final String URL_STRING = "http://api.fengniao.com/app_ipad/news_jingxuan.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=";
    int page=1;
    List<Bean1.OneBean> dataList;
    List<Bean1.TwoBean> dataList2;

    ViewPager viewPager;
    List<Fragment> ftList;
    HeaderNewVpAdapter hnvAdapter;
    LinearLayout potLayout;//放置导航圈圈资源
    private static int prePosition=0;//记录上次被选择的页数

    // 判断是否自动滚动viewPager
    private boolean isRunning = true;
    private Handler handler1 = new Handler() {
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
                       handler1.sendEmptyMessageDelayed(0, 3000);
                   }
               }).start();
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        handler = new Handler();
        return inflater.inflate(R.layout.fragment_fragmentjingxuan, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pListView = (PullToRefreshListView) view.findViewById(R.id.jxPlistId);
        View headerView = View.inflate(getActivity(), R.layout.header1_viewpeger, null);

        viewPager= (ViewPager) headerView.findViewById(R.id.headerpergerId);
        ininData();
        hnvAdapter=new HeaderNewVpAdapter(getFragmentManager(),ftList);
        potLayout= (LinearLayout) headerView.findViewById(R.id.dotnewViewpagerId);

        for (int i = 0; i <ftList.size() ; i++) {
            View view1=new View(getActivity());
            LinearLayout.LayoutParams params1=new
                    LinearLayout.LayoutParams(15, 15);//给view设置一个宽高
            params1.leftMargin=5;//设置间隔
            Log.d("hyh","ftList==============="+ftList.size());
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
        viewPager.setAdapter(hnvAdapter);

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
                Log.d("zsp", "position==="+position);
                Log.d("zsp", "positionOffset==="+positionOffset);
                Log.d("zsp", "positionOffsetPixels==="+positionOffsetPixels);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                // TODO 监听滑动状态的改变    SCROLL_STATE_IDLE
            }
        });

       new Thread(new Runnable() {
           @Override
           public void run() {
               handler1.sendEmptyMessageDelayed(0, 3000);
           }
       }).start();

        Log.d("hyh","9999-----"+headerView);
        pListView.getRefreshableView().addHeaderView(headerView);
        dataList = new ArrayList<>();
        dataList2= new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonString = DownLoadUtils.getJsonString(URL_STRING+page);
                Log.d("hyh", "jsonString===========" + jsonString);
                String str1 = jsonString.replace("160120", "one");
                String str2 = str1.replace("280280", "two");
                Gson gson = new Gson();
                Bean1 bean1 = gson.fromJson(str2, Bean1.class);
                Log.d("hyh", "bean1==============" + bean1);
                Log.d("hyh","bean1.getOne()============"+bean1.getOne());
                dataList=bean1.getOne();
                Log.d("hyh", "dataList=============" + dataList.size());
                dataList2=bean1.getTwo();
                Log.d("hyh", "dataList2==============" + dataList2.size());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter1 = new MyAdapter1(getActivity(), dataList,dataList2);
                        pListView.setAdapter(adapter1);

                    }
                });
            }
        }).start();
        pListView.setMode(PullToRefreshBase.Mode.BOTH);
        pListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                      new Thread(new Runnable() {
                          @Override
                          public void run() {
                          page=page+1;
                              String jsonstr=DownLoadUtils.getJsonString(URL_STRING+page);
                              String oneStrPage=jsonstr.replace("160120","one");
                              String twoStrPage=oneStrPage.replace("280280","two");
                              Bean1 bean2=JSONObject.parseObject(twoStrPage,Bean1.class);
                              List<Bean1.OneBean> onePage=new ArrayList<Bean1.OneBean>();
                              List<Bean1.TwoBean> twoBeenPage=new ArrayList<Bean1.TwoBean>();
                              onePage=bean2.getOne();
                              twoBeenPage=bean2.getTwo();
                              for (int i = 0; i <onePage.size() ; i++) {
                                  dataList.add(onePage.get(i));

                              }
                              for (int i = 0; i <twoBeenPage.size() ; i++) {
                                  dataList2.add(twoBeenPage.get(i));
                              }
                              handler.post(new Runnable() {
                                  @Override
                                  public void run() {
                                      adapter1.notifyDataSetChanged();
                                      pListView.onRefreshComplete();
                                  }
                              });
                          }
                      }).start();
            }
        });

    }

    private void ininData() {
        ftList=new ArrayList<>();
      HeaderFragment1 hf1=new HeaderFragment1();
      HeaderFragment2 hf2=new HeaderFragment2();
      headerFragment3 hf3=new headerFragment3();
        ftList.add(hf1);
        ftList.add(hf2);
        ftList.add(hf3);
        Log.d("hyh","ftList==============="+ftList.size());
    }

}

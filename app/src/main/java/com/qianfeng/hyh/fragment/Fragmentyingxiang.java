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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.hyh.adapter.HeaderVideoVpAdapter;
import com.qianfeng.hyh.adapter.MyAdapter2;
import com.qianfeng.hyh.adapter.MyVideoptpgListAdapter;
import com.qianfeng.hyh.bean.HeaderNewBean1;
import com.qianfeng.hyh.bean.QiCaiBean;
import com.qianfeng.hyh.bean.VideoBean;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Fragmentyingxiang extends Fragment {
     PullToRefreshListView pListView;
     Handler handler1;
     MyVideoptpgListAdapter adapter;
     List<VideoBean.ListBean> dataList1;
     final String URL_STRING1="http://api.fengniao.com/app_ipad/news_list.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&cid=192&page=";
     int page=1;
     ViewPager viewPager;
     List<Fragment> ftList;
     LinearLayout potLayout;//放置导航圈圈资源
     private static int prePosition=0;//记录上次被选择的页数
     HeaderVideoVpAdapter hvvAdapter;

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
          handler1=new Handler();
          Log.d("hyh","影像videohandler========="+handler1);
          dataList1=new ArrayList<>();
          return inflater.inflate(R.layout.fragment_fragmentyingxiang,null);
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated(view, savedInstanceState);
          Log.d("hyh","影像onViewCreated==============");
          pListView= (PullToRefreshListView) view.findViewById(R.id.videoptrlistviewId);
          View headerView = View.inflate(getActivity(), R.layout.headervideo_viewpager, null);
          viewPager= (ViewPager) headerView.findViewById(R.id.VideoheaderpergerId);
          ininData();
          Log.d("hyh","影像的ftList上============="+ftList.size());
          hvvAdapter=new HeaderVideoVpAdapter(getFragmentManager(),ftList);
          Log.d("hyh","影像的ftList下============"+ftList.size());
          potLayout= (LinearLayout) headerView.findViewById(R.id.VideodotvideoViewpagerId);
          for (int i = 0; i <ftList.size() ; i++) {
               View view1=new View(getActivity());
               LinearLayout.LayoutParams params1=new
                       LinearLayout.LayoutParams(15, 15);//给view设置一个宽高
               params1.leftMargin=5;//设置间隔
               Log.d("hyh","影像ftList==============="+ftList.size());
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
          viewPager.setAdapter(hvvAdapter);
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
          pListView.getRefreshableView().addHeaderView(headerView);

          new Thread(new Runnable() {
               @Override
               public void run() {
                    Log.d("hyh","我在影像解析上面");
                    String jsonString1= DownLoadUtils.getJsonString(URL_STRING1+page);
                    Log.d("hyh","影像VideojsonString1================"+jsonString1);
                     VideoBean videoBean= JSONObject.parseObject(jsonString1, VideoBean.class);
                     dataList1=videoBean.getList();
                    Log.d("hyh","videoBean==========="+dataList1);
                 //   dataList1=videoBean.getList();
                    handler1.post(new Runnable() {
                         @Override
                         public void run() {
                              Log.d("hyh","影像的的dataList上============"+dataList1.size());
                              adapter=new MyVideoptpgListAdapter(getActivity(),dataList1);
                              Log.d("hyh","影像的的dataList下============"+dataList1.size());
                              pListView.setAdapter(adapter);
                              Log.d("hyh","======================影像pListView.setAdapter(adapter)的下面");
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
                              String jsonstr=DownLoadUtils.getJsonString(URL_STRING1+page);
                              VideoBean videoBean= JSONObject.parseObject(jsonstr, VideoBean.class);
                              List<VideoBean.ListBean> preList=new ArrayList<VideoBean.ListBean>();
                              preList=videoBean.getList();
                              for (int i = 0; i <preList.size() ; i++) {
                                   dataList1.add(preList.get(i));

                              }
                              handler1.post(new Runnable() {
                                   @Override
                                   public void run() {
                                        adapter.notifyDataSetChanged();
                                        pListView.onRefreshComplete();
                                   }
                              });

                         }
                    }).start();
               }
          });
          pListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getContext(),"你点击了影像"+position,Toast.LENGTH_LONG).show();
               }
          });

     }

     private void ininData() {
          ftList=new ArrayList<>();

          VideoHeaderFragment1 vhf1=new VideoHeaderFragment1();
          VideoHeaderFragment2 vhf2=new VideoHeaderFragment2();
          VideoHeaderFragment3 vhf3=new VideoHeaderFragment3();
          ftList.add(vhf1);
          ftList.add(vhf2);
          ftList.add(vhf3);
         Log.d("hyh","影像ininDataftList================"+ftList.size());
     }
}

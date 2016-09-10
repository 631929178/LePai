package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alibaba.fastjson.JSONObject;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.qianfeng.hyh.adapter.NumGridAdpter;
import com.qianfeng.hyh.adapter.zoologyGridAdpter;
import com.qianfeng.hyh.bean.PorTraitBean;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;


public class Fragmentshuma extends Fragment {
    PullToRefreshGridView gridView;
    Handler handler;
    List<PorTraitBean.ListBean> dataList;
    final  String URL_STRING="http://api.fengniao.com//app_ipad/pic_bbs_list_v2.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&fid=24&page=";
    int page=1;
    NumGridAdpter adpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragmentshuma,null);
        gridView= (PullToRefreshGridView) view.findViewById(R.id.numGridViewId);
        handler=new Handler();
        dataList=new ArrayList<>();
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonstr= DownLoadUtils.getJsonString(URL_STRING+page);
                Log.d("hyh","我在人像解析json=============="+jsonstr);
                Log.d("hyh","我在人像解析上面");
                PorTraitBean porTraitBean= JSONObject.parseObject(jsonstr,PorTraitBean.class);
                Log.d("hyh","我在人像解析下面");
                dataList=porTraitBean.getList();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adpter=new NumGridAdpter(getActivity(),dataList);
                        gridView.setAdapter(adpter);
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
                        PorTraitBean porTraitBean=JSONObject.parseObject(jsonstr,PorTraitBean.class);
                        List<PorTraitBean.ListBean> preList=new ArrayList<PorTraitBean.ListBean>();
                        preList=porTraitBean.getList();
                        for (int i = 0; i <preList.size() ; i++) {
                            dataList.add(preList.get(i));

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                adpter.notifyDataSetChanged();
                                gridView.onRefreshComplete();
                            }
                        });

                    }
                }).start();
            }
        });


    }

}

package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.qianfeng.hyh.bean.RetieBean;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener {
    RadioGroup radioGroup;
    ListView listView;
    List<String> datas;
    ArrayAdapter adpter;

    boolean isClick = false;
    final String url="http://api.fengniao.com/app_ipad/bbs_all_hot.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&page=";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, null);
        radioGroup = (RadioGroup) view.findViewById(R.id.bgradiogroupId);
        listView = (ListView) view.findViewById(R.id.bgListviewid);
        datas = new ArrayList<>();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String[] forum = {
                "热帖", "精华帖", "最新帖子", "最新回复"
        };
        for (int i = 0; i < forum.length; i++) {
            datas.add(forum[i]);
        }
        notiy();

        radioGroup.setOnCheckedChangeListener(this);

    }

    public void notiy() {
        adpter = new ArrayAdapter(getActivity(), R.layout.item_bglistview, datas);

        listView.setAdapter(adpter);
        adpter.notifyDataSetChanged();
        listView.setOnItemClickListener(this);

    }

    public void textcolor(int num) {
        RadioButton button;
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            button = (RadioButton) radioGroup.getChildAt(i);
            if (num == i) {
                button.setTextColor(Color.RED);
            } else {
                button.setTextColor(Color.BLACK);
            }
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        datas.clear();
        switch (checkedId) {
            case R.id.bgradiobutton1Id:
                textcolor(0);

                String[] forum = {
                        "热帖", "精华帖", "最新帖子", "最新回复"
                };
                for (int i = 0; i < forum.length; i++) {
                    datas.add(forum[i]);
                }
                notiy();

                break;
            case R.id.bgradiobutton2Id:
                textcolor(1);

                String[] works = {
                        "人像", "风光", "纪实", "人体", "儿童", "人体", "建筑", "生态", "宠物"
                };
                for (int i = 0; i < works.length; i++) {
                    datas.add(works[i]);
                }

                notiy();

                break;
            case R.id.bgradiobutton3Id:
                textcolor(2);

                String[] films = {
                        "商业", "女性视觉", "新手", "数码", "黑白", "实验", "生活摄影", "高校", "手机", "葡萄酒"
                };
                for (int i = 0; i < films.length; i++) {
                    datas.add(films[i]);
                }

                notiy();

                break;
            case R.id.bgradiobutton4Id:
                textcolor(3);

                String[] trades = {
                        "交易警示", "二手交易", "器材维修"
                };
                for (int i = 0; i < trades.length; i++) {
                    datas.add(trades[i]);
                }

                notiy();

                break;
            case R.id.bgradiobutton5Id:
                textcolor(4);

                String[] subs = {
                        "北京", "上海", "武汉"
                };

                for (int i = 0; i < subs.length; i++) {
                    datas.add(subs[i]);
                }
                notiy();

                break;
            case R.id.bgradiobutton6Id:
                textcolor(5);

                String[] discuss = {
                        "单反和镜头", "大中画幅", "编写数码"
                };
                for (int i = 0; i < discuss.length; i++) {
                    datas.add(discuss[i]);
                }

                notiy();
                break;
            case R.id.bgradiobutton7Id:
                textcolor(6);

                String[] serves = {
                        "活动区", "网友服务", "蜂鸟茶馆"
                };
                for (int i = 0; i < serves.length; i++) {
                    datas.add(serves[i]);
                }

                notiy();
                break;


        }

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        for (int i = 0; i <15 ; i++) {
            if (i==position+1) {
                Intent intent = new Intent("com.qianfeng.retie");
                intent.putExtra("url", url+i);
                getActivity().startActivity(intent);
            }
        }

    }
}

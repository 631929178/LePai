package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.hyh.bean.HeaderNewBean1;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;


public class CollegeHeaderFragment3 extends Fragment {
    ImageView imageView;
    TextView textView;
    Handler handler;
    String URL_STRING="http://api.fengniao.com/app_ipad//focus_pic.php?appImei=000000000000000&osType=Android&osVersion=4.1.1&mid=19931";
    List<HeaderNewBean1> dataList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        handler=new Handler();

        return inflater.inflate(R.layout.fragment_college_header_fragment3,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView= (ImageView) view.findViewById(R.id.headerCollege3ImageId);
        textView= (TextView) view.findViewById(R.id.headerCollege3TextId);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String json= DownLoadUtils.getJsonString(URL_STRING);
                Log.d("hyh","学院头部视图json==========="+json);
                Gson gson=new Gson();
                Type type = new TypeToken<List<HeaderNewBean1>>(){}.getType();
               dataList=gson.fromJson(json,type);
                if (dataList.size()==0){
                    return;
                }
                final String urlimage=dataList.get(2).getPic_src();
                Log.d("hyh","学院头部视图urlimage==========="+urlimage);
                final String text=dataList.get(2).getTitle();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(text);
                        Picasso.with(getActivity()).load(urlimage).into(imageView);
                    }
                });

            }
        }).start();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1= dataList.get(2).getWeb_url();
                Intent intent=new Intent("com.qianfeng.web");

                intent.putExtra("web",url1);
                startActivity(intent);
            }
        });

    }
}

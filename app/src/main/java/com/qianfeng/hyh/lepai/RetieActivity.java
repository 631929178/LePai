package com.qianfeng.hyh.lepai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.qianfeng.hyh.adapter.ReTieAdpter;
import com.qianfeng.hyh.bean.RetieBean;
import com.qianfeng.hyh.utils.DownLoadUtils;

import java.util.ArrayList;
import java.util.List;

public class RetieActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    String url1=null;
    String title;
    Handler handler;
    List<RetieBean.ListBean> datas;
    ReTieAdpter adpter;
    String url2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retie);
        listView= (ListView) findViewById(R.id.retielistId);

          Intent intent=getIntent();
          final String url=intent.getStringExtra("url");
        Log.d("hyh","热帖url============="+url);
        datas=new ArrayList<>();
        handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("hyh","热帖new Threadurl============="+url);
                String json= DownLoadUtils.getJsonString(url);
                RetieBean retieBean= JSONObject.parseObject(json,RetieBean.class);
                Log.d("hyh","热帖retieBean============="+retieBean);
                datas=retieBean.getList();

                Log.d("hyh","热帖datas============="+datas.size());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      adpter=new ReTieAdpter(datas,getApplicationContext());
                        listView.setAdapter(adpter);
                    }
                });
            }
        }).start();
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        for (int i = 0; i <20 ; i++) {
            if (i==position+1){
                url2=datas.get(i).getDoc_url();
                Log.d("hyh","热帖url2============="+datas.size());
                Intent intent=new Intent("com.qianfeng.web");
                intent.putExtra("web",url2);
                startActivity(intent);
            }
        }


    }
}

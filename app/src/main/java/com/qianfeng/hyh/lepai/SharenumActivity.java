package com.qianfeng.hyh.lepai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharenumActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ListView listView;
    List<Map<String,Object>> datas;
    Map<String,Object> map;
    SimpleAdapter adpter;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharenum);
    listView= (ListView) findViewById(R.id.shareListview);
        backButton= (Button) findViewById(R.id.backsharebuttonId);
         initData();
        adpter=new SimpleAdapter(getApplicationContext(),
                datas, R.layout.item_sharelistview,
                new String[]{"image","name"},
                new int[]{R.id.shareimageId,R.id.shareTextviewId});
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(this);
        backButton.setOnClickListener(this);
    }
    int[] images={
      R.drawable.logo_douban,
            R.drawable.logo_dropbox,
            R.drawable.logo_email,
            R.drawable.logo_evernote,
            R.drawable.logo_facebook,
            R.drawable.logo_flickr,
            R.drawable.logo_foursquare,
            R.drawable.logo_googleplus,
            R.drawable.logo_instagram,
            R.drawable.logo_kaixin,
            R.drawable.logo_linkedin,
            R.drawable.logo_mingdao,
            R.drawable.logo_neteasemicroblog,
            R.drawable.logo_qq,
            R.drawable.logo_renren,
            R.drawable.logo_sinaweibo,
    };

    private void initData() {
     datas=new ArrayList<>();
        for (int i = 0; i <images.length ; i++) {
            map=new HashMap<>();
            map.put("image",images[i]);
            map.put("name","尚未授权");
            datas.add(map);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

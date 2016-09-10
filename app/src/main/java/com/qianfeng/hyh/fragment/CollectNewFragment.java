package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.qianfeng.hyh.adapter.CollectNewListviewAdpter;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;
import com.qianfeng.hyh.utils.MySqliteHelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CollectNewFragment extends Fragment {
    ListView listView;

    String url;
    String title;
    String url1;
    List<Map<String,String>> data;
     Map<String,String> map;
    CollectNewListviewAdpter adpter;
    MySqliteHelp openHelp;
    SQLiteDatabase database;
    int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collect_new, null);
        listView = (ListView) view.findViewById(R.id.CollectnewListview);
        openHelp=new MySqliteHelp(getActivity());
        database=openHelp.getWritableDatabase();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data=new ArrayList<>();

        Cursor cursor=database.rawQuery("select * from collect", null);
        //根据列名来逐项查询数据   cursor.getColumnIndex("_id")---获取表的列名
        while (cursor.moveToNext()) {
            map=new HashMap<>();
         id=cursor.getInt(cursor.getColumnIndex("_id"));
          title=cursor.getString(cursor.getColumnIndex("title"));
           url=cursor.getString(cursor.getColumnIndex("weburl"));
            url1=cursor.getString(cursor.getColumnIndex("imageurl"));
           map.put("title",title);
            map.put("url1",url1);
            data.add(map);
        }


        Log.d("hyh","收藏CollectsharedPreferencesURL=========="+url);
        Log.d("hyh","收藏CollectsharedPreferencestitle=========="+title);
        Log.d("hyh","收藏CollectsharedPreferencesurl1=========="+url1);

        adpter=new CollectNewListviewAdpter(data,getActivity());
        listView.setAdapter(adpter);
    }


}

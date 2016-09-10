package com.qianfeng.hyh.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.hyh.bean.QiCaiBean;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.utils.DownLoadUtils;
import com.qianfeng.hyh.utils.LruCacheUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-9-4.
 */
public class MyAdapter2 extends BaseAdapter {
    Context context;
    List<QiCaiBean.ListBean> list;
    Handler handler;


    public MyAdapter2(Context context, List<QiCaiBean.ListBean> list) {
        Log.d("hyh","器材的MyAdapter2构造方法=================");
        this.context = context;
        this.list = list;
        handler=new Handler();
    }

    @Override
    public int getCount() {
        Log.d("hyh","器材getCount()=============="+list.size());
        return list.size()/2;
    }

    @Override
    public Object getItem(int position) {
        Log.d("hyh","器材getItem==============");
        return list.get(position*2);
    }

    @Override
    public long getItemId(int position) {
        Log.d("hyh","器材getItemId==============");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("hyh","我进到器材的getView==================");
       ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_listview2,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView1= (ImageView) convertView.findViewById(R.id.qicaiimage1Id);
            viewHolder.imageView2= (ImageView) convertView.findViewById(R.id.qicaiimage2Id);
            viewHolder.textView1= (TextView) convertView.findViewById(R.id.qicaitext1Id);
            viewHolder.textView2= (TextView) convertView.findViewById(R.id.qicaitext2Id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(list.get(position*2).getTitle());
        viewHolder.textView2.setText(list.get(position*2+1).getTitle());
        final String url1=list.get(position*2).getPic_url();
        final String url2=list.get(position*2+1).getPic_url();
        Log.d("hyh","器材图片的URL1================="+url1);
        Log.d("hyh","器材图片的URL2================="+url2);
        Picasso.with(context).load(url1).resize(100,100).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.imageView1);
        Picasso.with(context).load(url2).resize(100,100).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.imageView2);
        final String web_url=list.get(position*2).getDoc_url();
        final String web_url1=list.get(position*2+1).getDoc_url();
        viewHolder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.qianfeng.web");
                intent.putExtra("web",web_url);
                context.startActivity(intent);
            }
        });
        viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.qianfeng.web");
                intent.putExtra("web",web_url1);
                context.startActivity(intent);
            }
        });



        return convertView;
    }

    class ViewHolder{
        ImageView imageView1,imageView2;
        TextView textView1,textView2;
    }
}

package com.qianfeng.hyh.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.hyh.bean.QiCaiBean;
import com.qianfeng.hyh.bean.VideoBean;
import com.qianfeng.hyh.lepai.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 16-9-5.
 */
public class MyVideoptpgListAdapter extends BaseAdapter {
    Context context;
    List<VideoBean.ListBean> list;


    public MyVideoptpgListAdapter(Context context, List<VideoBean.ListBean> list) {
        this.context = context;
        this.list = list;


    }

    @Override
    public int getCount() {
        return list.size()/2;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position*2);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("hyh","我进到影像的getView==================");
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_videolistview,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView1= (ImageView) convertView.findViewById(R.id.videomage1Id);
            viewHolder.imageView2= (ImageView) convertView.findViewById(R.id.videoimage2Id);
            viewHolder.textView1= (TextView) convertView.findViewById(R.id.videotext1Id);
            viewHolder.textView2= (TextView) convertView.findViewById(R.id.videotext2Id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(list.get(position*2).getTitle());
        viewHolder.textView2.setText(list.get(position*2+1).getTitle());
        String url1=list.get(position*2).getPic_url();
        String url2=list.get(position*2+1).getPic_url();

        Log.d("hyh","影像图片的URL122222================="+list.get(position));
        Log.d("hyh","影像图片的URL1================="+url1);
        Log.d("hyh","影像图片的URL2================="+url2);

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

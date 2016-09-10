package com.qianfeng.hyh.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qianfeng.hyh.bean.CollegeBean;
import com.qianfeng.hyh.bean.VideoBean;
import com.qianfeng.hyh.lepai.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class CollegeGridAdapter extends BaseAdapter {
    Context context;
    List<CollegeBean.ListBean> list;

    public CollegeGridAdapter(Context context, List<CollegeBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("hyh","我进到学院的getView==================");
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_collegegridview,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.collegeimage1Id);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.collegetext1Id);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getTitle());
        final String url1=list.get(position).getPic_url();
        Log.d("hyh","学院图片的URL1================="+url1);

        Picasso.with(context).load(url1).resize(150,150).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.imageView);

        final String web_url=list.get(position).getDoc_url();

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.qianfeng.web");
                intent.putExtra("web",web_url);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}

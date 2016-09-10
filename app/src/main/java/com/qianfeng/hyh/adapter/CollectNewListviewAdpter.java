package com.qianfeng.hyh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.hyh.lepai.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-9-9.
 */
public class CollectNewListviewAdpter extends BaseAdapter {
    List<Map<String,String>> list;
    Context context;

    public CollectNewListviewAdpter(List<Map<String, String>> list, Context context) {
        this.list = list;
        this.context = context;
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
        ViewHolder viewHolder=null;
        if (convertView==null){
          convertView= LayoutInflater.from(context).inflate(R.layout.item_collect_new_listview,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.collectNewImageId);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.collectNewTextId);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).get("title"));
        String imageurl=list.get(position).get("url1");
        Picasso.with(context).load(imageurl).resize(150,150).
                placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}

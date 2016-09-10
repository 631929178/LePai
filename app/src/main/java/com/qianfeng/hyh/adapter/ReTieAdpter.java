package com.qianfeng.hyh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qianfeng.hyh.bean.RetieBean;
import com.qianfeng.hyh.lepai.R;

import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class ReTieAdpter extends BaseAdapter {
    List<RetieBean.ListBean> list;
    Context context;

    public ReTieAdpter(List<RetieBean.ListBean> list, Context context) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_retielistview,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.retietextId);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        viewHolder.textView.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
       TextView textView;

    }
}

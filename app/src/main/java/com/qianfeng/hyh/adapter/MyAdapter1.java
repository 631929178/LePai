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

import com.qianfeng.hyh.bean.Bean1;
import com.qianfeng.hyh.lepai.R;
import com.qianfeng.hyh.lepai.WebActivity;
import com.qianfeng.hyh.utils.DownLoadUtils;
import com.qianfeng.hyh.utils.LruCacheUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-9-3.
 */
public class MyAdapter1 extends BaseAdapter {
    Context context;
    List<Bean1.OneBean> list1;
    List<Bean1.TwoBean> list2;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    Handler handler;
    LruCacheUtils lruCacheUtils;

    public MyAdapter1(Context context, List list1, List list2) {
        this.context = context;
        this.list1 = list1;
        this.list2 = list2;

        handler = new Handler();
        lruCacheUtils = LruCacheUtils.getLruCacheUtils();
        lruCacheUtils.open(context, "bitmap", 1024 * 1024 * 10);
    }

    @Override
    public int getCount() {
        return list1.size() + list2.size() / 2;
    }

    @Override
    public Object getItem(int position) {

        return position % 5 == 0 ? list2.get(position) : list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int s = position % 5;
        if (s == 0) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("hyh", "postion=========" + position);
        Log.d("hyh", "我进来了getView=======");
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.item1_listview, null);
                    viewHolder1 = new ViewHolder1();
                    viewHolder1.imageView1 = (ImageView) convertView.findViewById(R.id.image1Id);
                    viewHolder1.imageView2 = (ImageView) convertView.findViewById(R.id.image2Id);
                    viewHolder1.textView1 = (TextView) convertView.findViewById(R.id.text1Id);
                    viewHolder1.textView2 = (TextView) convertView.findViewById(R.id.text2Id);
                    convertView.setTag(viewHolder1);
                } else {
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                }
                viewHolder1.textView1.setText(list2.get(position * 2 / 5).getTitle());
                viewHolder1.textView2.setText(list2.get(position * 2 / 5 + 1).getTitle());
                final String url1 = list2.get(position * 2 / 5).getPic_url();
                final String url2 = list2.get(position * 2 / 5 + 1).getPic_url();
                final String web_url=list2.get(position*2/5).getDoc_url();
                final String web_url1=list2.get(position * 2 / 5 + 1).getDoc_url();
                final String title1=list2.get(position * 2 / 5).getTitle();
                final String title2=list2.get(position * 2 / 5 + 1).getTitle();
                downToImageView(url1, viewHolder1);
                downToImageView2(url2, viewHolder1);
                viewHolder1.imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, WebActivity.class);
                        intent.putExtra("web",web_url);
                        Log.d("refer","web_url======"+web_url);
                        intent.putExtra("title",title1);
                        intent.putExtra("url1",url1);
                        context.startActivity(intent);
                    }
                });
                viewHolder1.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.qianfeng.web");
                        intent.putExtra("web",web_url1);
                        intent.putExtra("title",title2);
                        intent.putExtra("url1",url2);
                        context.startActivity(intent);
                    }
                });
                break;
            case TYPE_2:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.item2_listview, null);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.typeImageView = (ImageView) convertView.findViewById(R.id.item2_imageId);
                    viewHolder2.typeTextView1 = (TextView) convertView.findViewById(R.id.item2_text1Id);
                    viewHolder2.typeTextView2 = (TextView) convertView.findViewById(R.id.item2_text2Id);
                    convertView.setTag(viewHolder2);
                } else {
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                }
                viewHolder2.typeTextView1.setText(list1.get(position - ((int) position / 5 + 1)).getTitle());
                viewHolder2.typeTextView2.setText(list1.get(position - ((int) position / 5 + 1)).getDate());
                final String url3 = list1.get(position - ((int) position / 5 + 1)).getPic_url();
                final String web_url3=list1.get(position - ((int) position / 5 + 1)).getDoc_url();
                downToImageView3(viewHolder2, url3);
                viewHolder2.typeImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.qianfeng.web");
                        intent.putExtra("web",web_url3);
                        context.startActivity(intent);
                    }
                });
                viewHolder2.typeTextView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.qianfeng.web");
                        intent.putExtra("web",web_url3);
                        context.startActivity(intent);
                    }
                });
                viewHolder2.typeTextView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent("com.qianfeng.web");
                        intent.putExtra("web",web_url3);
                        context.startActivity(intent);
                    }
                });
                break;
        }

        return convertView;
    }

    private void downToImageView3(ViewHolder2 viewHolder2, final String url3) {
        viewHolder2.typeImageView.setTag(url3);
        final ViewHolder2 finalViewHolder = viewHolder2;
        Bitmap bitmap = lruCacheUtils.getBitmapFromCache(url3);
        if (bitmap == null) {
            try {
                bitmap = lruCacheUtils.loadBitmapFromDiskCache(url3, 100, 100);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap == null) {

                final ViewHolder2 finalViewHolder1 = viewHolder2;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] imagebyte = DownLoadUtils.getImageByte(url3);

                        if (imagebyte == null) {
                            return;
                        }
                        final Bitmap bitmap = lruCacheUtils.decodeSampledBitmap(imagebyte, 100, 100);

                        Log.d("hyh", "bitmap=======" + bitmap);
                        if (bitmap != null) {
                            lruCacheUtils.addBitmapToCache(url3, bitmap);
                            try {
                                lruCacheUtils.loadBitmapFromHttp(url3, 100, 100);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (finalViewHolder1.typeImageView.getTag() != null && finalViewHolder1.typeImageView.getTag().equals(url3)) {
                                    finalViewHolder1.typeImageView.setImageBitmap(bitmap);
                                }
                            }
                        });
                    }
                }).start();

            } else {
                try {
                    bitmap = lruCacheUtils.loadBitmapFromDiskCache(url3, 100, 100);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                lruCacheUtils.addBitmapToCache(url3, bitmap);
                viewHolder2.typeImageView.setImageBitmap(bitmap);
            }
        } else {
            viewHolder2.typeImageView.setImageBitmap(bitmap);
        }
    }

    private void downToImageView(final String url1, ViewHolder1 viewHolder1) {
        viewHolder1.imageView1.setTag(url1);
        final ViewHolder1 finalViewHolder1 = viewHolder1;
        Bitmap bitmap = lruCacheUtils.getBitmapFromCache(url1);
        if (bitmap == null) {
            try {
                bitmap = lruCacheUtils.loadBitmapFromDiskCache(url1, 100, 100);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap == null) {

                final ViewHolder1 finalViewHolder2 = viewHolder1;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] imagebyte = DownLoadUtils.getImageByte(url1);
                        // final Bitmap bitmap = BitmapFactory.decodeByteArray(imagebyte, 0, imagebyte.length);
                        if (imagebyte == null) {
                            return;
                        }
                        final Bitmap bitmap = lruCacheUtils.decodeSampledBitmap(imagebyte, 100, 100);

                        Log.d("hyh", "bitmap=======" + bitmap);
                        if (bitmap != null) {
                            lruCacheUtils.addBitmapToCache(url1, bitmap);
                            try {
                                lruCacheUtils.loadBitmapFromHttp(url1, 100, 100);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (finalViewHolder2.imageView1.getTag() != null && finalViewHolder2.imageView1.getTag().equals(url1)) {
                                    finalViewHolder1.imageView1.setImageBitmap(bitmap);
                                }
                            }
                        });
                    }
                }).start();

            } else {
                try {
                    bitmap = lruCacheUtils.loadBitmapFromDiskCache(url1, 100, 100);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                lruCacheUtils.addBitmapToCache(url1, bitmap);
                viewHolder1.imageView1.setImageBitmap(bitmap);
            }
        } else {
            viewHolder1.imageView1.setImageBitmap(bitmap);
        }
    }

    private void downToImageView2(final String url2, ViewHolder1 viewHolder1) {
        viewHolder1.imageView2.setTag(url2);
        final ViewHolder1 finalViewHolder1 = viewHolder1;
        Bitmap bitmap = lruCacheUtils.getBitmapFromCache(url2);
        if (bitmap == null) {
            try {
                bitmap = lruCacheUtils.loadBitmapFromDiskCache(url2, 100, 100);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bitmap == null) {

                final ViewHolder1 finalViewHolder2 = viewHolder1;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] imagebyte = DownLoadUtils.getImageByte(url2);
                        // final Bitmap bitmap = BitmapFactory.decodeByteArray(imagebyte, 0, imagebyte.length);
                        if (imagebyte == null) {
                            return;
                        }
                        final Bitmap bitmap = lruCacheUtils.decodeSampledBitmap(imagebyte, 100, 100);

                        Log.d("hyh", "bitmap=======" + bitmap);
                        if (bitmap != null) {
                            lruCacheUtils.addBitmapToCache(url2, bitmap);
                            try {
                                lruCacheUtils.loadBitmapFromHttp(url2, 100, 100);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (finalViewHolder2.imageView2.getTag() != null && finalViewHolder2.imageView2.getTag().equals(url2)) {
                                    finalViewHolder1.imageView2.setImageBitmap(bitmap);
                                }
                            }
                        });
                    }
                }).start();

            } else {
                try {
                    bitmap = lruCacheUtils.loadBitmapFromDiskCache(url2, 100, 100);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                lruCacheUtils.addBitmapToCache(url2, bitmap);
                viewHolder1.imageView2.setImageBitmap(bitmap);
            }
        } else {
            viewHolder1.imageView2.setImageBitmap(bitmap);
        }
    }

    class ViewHolder1 {
        ImageView imageView1, imageView2;
        TextView textView1, textView2;
    }

    class ViewHolder2 {
        ImageView typeImageView;
        TextView typeTextView1, typeTextView2;
    }


}

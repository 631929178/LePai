package com.qianfeng.hyh.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianfeng.hyh.lepai.R;

import java.io.File;


public class Fragment4 extends Fragment implements RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment4,null);
        radioGroup= (RadioGroup) view.findViewById(R.id.lastradiogroupId);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.lastradiobutton1Id:
                Intent intent=new Intent("com.qianfeng.register");
                startActivity(intent);
            break;
            case R.id.lastradiobutton2Id:
                Intent intent1=new Intent("com.qianfeng.share");
                  startActivity(intent1);
                break;
            case R.id.lastradiobutton3Id:

                break;
            case R.id.lastradiobutton4Id:
                Intent intent3=new Intent("com.qianfeng.collect");
                startActivity(intent3);


                break;
            case R.id.lastradiobutton5Id:
                cleanInternalCache(getActivity());
                cleanExternalCache(getActivity());
                Toast.makeText(getActivity(),"清除成功",Toast.LENGTH_LONG).show();

                break;
            case R.id.lastradiobutton6Id:

                break;
            case R.id.lastradiobutton7Id:

                break;
            case R.id.lastradiobutton8Id:
               Intent intent2=new Intent("com.qianfeng.fengniao");
                startActivity(intent2);

                break;
        }

    }
    /** * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache) * * @param context */
    public static void cleanInternalCache(Context context) {
        deleteFilesByDirectory(context.getCacheDir());
    }
    /**
     * * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache) * * @param
     * context
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            deleteFilesByDirectory(context.getExternalCacheDir());
        }
    }
    /** * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 * * @param directory */
    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }
}

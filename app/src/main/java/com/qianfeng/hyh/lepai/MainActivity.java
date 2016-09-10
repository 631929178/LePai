package com.qianfeng.hyh.lepai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.hyh.adapter.MyPagerAdapter;
import com.qianfeng.hyh.fragment.Fragment1;
import com.qianfeng.hyh.fragment.Fragment2;
import com.qianfeng.hyh.fragment.Fragment3;
import com.qianfeng.hyh.fragment.Fragment4;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    ViewPager viewPager;
    List<Fragment> dataList;
    RadioGroup radioGroup;
    MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        adapter = new MyPagerAdapter(getSupportFragmentManager(), dataList);
        viewPager.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initData() {
        dataList = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        dataList.add(fragment1);
        dataList.add(fragment2);
        dataList.add(fragment3);
        dataList.add(fragment4);
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.mainRadioTabs);

        viewPager = (ViewPager) findViewById(R.id.mainviewpager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.mainRadio_news:

                viewPager.setCurrentItem(0);
                break;
            case R.id.mainRadio_pic:

                viewPager.setCurrentItem(1);

                break;
            case R.id.mainRadio_bbs:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mainRadio_set:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }
}

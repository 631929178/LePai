package com.qianfeng.hyh.lepai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.qianfeng.hyh.adapter.Collectnewadpter;
import com.qianfeng.hyh.fragment.CollectImageFragment;
import com.qianfeng.hyh.fragment.CollectNewFragment;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {
    Button collectButton;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> titles;
    List<Fragment> datas;
    Collectnewadpter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
        titles=new ArrayList<>();
        titles.add("资讯");
        titles.add("图赏");

        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置导航模式
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        datas=new ArrayList<>();
        CollectNewFragment cnf=new CollectNewFragment();
        CollectImageFragment cif=new CollectImageFragment();
        datas.add(cnf);
        datas.add(cif);
        adpter=new Collectnewadpter(getSupportFragmentManager(),datas,titles);
        viewPager.setAdapter(adpter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adpter);//将tanlayout与viewpager发生联系
        collectButton.setOnClickListener(this);
    }

    private void initView() {
        collectButton= (Button) findViewById(R.id.backCollectbuttonId);
        tabLayout= (TabLayout) findViewById(R.id.CollectTabId);
        viewPager= (ViewPager) findViewById(R.id.CollectviewpagerId);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

package com.qianfeng.hyh.lepai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class welcomeActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Intent intent=new Intent("android.intent.action.MYMAIN");
                      startActivity(intent);
                      finish();
                  }
              },500);

            }
        }).start();


    }

}

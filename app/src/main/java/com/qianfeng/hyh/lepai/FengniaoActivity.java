package com.qianfeng.hyh.lepai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FengniaoActivity extends AppCompatActivity implements View.OnClickListener {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fengniao);
     backButton= (Button) findViewById(R.id.backFengNiaobuttonId);
     backButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.finish();

    }
}

package com.qianfeng.hyh.lepai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CommentTextActivity extends AppCompatActivity implements View.OnClickListener {
    Button back,publish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_text);
        back= (Button) findViewById(R.id.backCommentId);
        publish= (Button) findViewById(R.id.publishButtonId);
        back.setOnClickListener(this);
       publish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backCommentId:

                this.finish();
                break;
            case R.id.publishButtonId:
                Intent intent=new Intent("com.qianfeng.register");
                startActivity(intent);

                break;
        }
    }
}

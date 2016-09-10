package com.qianfeng.hyh.lepai;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.qianfeng.hyh.utils.MySqliteHelp;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {
    WebView webView;
    Intent intent;
    Button shareButton,backButton,favButton,comment1Id,comment2Id;
    String url;
    String title;
    String url1;
    SQLiteDatabase database;//数据库的操作对象
    MySqliteHelp openHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView= (WebView) findViewById(R.id.webId);
        shareButton= (Button) findViewById(R.id.shareWebButoonId);
        backButton= (Button) findViewById(R.id.backWebId);
        favButton= (Button) findViewById(R.id.favWebButoonId);
        comment1Id= (Button) findViewById(R.id.comment1Id);
        comment2Id= (Button) findViewById(R.id.comment2Id);

        openHelp=new MySqliteHelp(getApplicationContext());

        database=openHelp.getWritableDatabase();

        intent= getIntent();
        url= intent.getStringExtra("web");
        title=intent.getStringExtra("title");
        url1=intent.getStringExtra("url1");
        Log.d("refer","url=============="+url);
        webView.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        shareButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        favButton.setOnClickListener(this);
        comment1Id.setOnClickListener(this);
        comment2Id.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shareWebButoonId:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
         //      intent.setPackage("com.sina.weibo");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, "你好 ");
                intent.putExtra(Intent.EXTRA_TITLE, "我是标题");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "请选择"));
                break;
            case R.id.backWebId:
                 this.finish();
                break;
            case R.id.favWebButoonId:
             if(url!=null&&title!=null&&url1!=null){
                 ContentValues values=new ContentValues();
                 values.put("title", title);
                 values.put("weburl", url);
                 values.put("imageurl",url1);

                 database.insert("collect", null, values);

                 Toast.makeText(getApplicationContext(),"收藏成功",Toast.LENGTH_LONG).show();
             }
                break;
            case R.id.comment1Id:
                Intent intent1=new Intent("com.qianfeng.commtentpublish");
                startActivity(intent1);

                break;
            case R.id.comment2Id:
                Intent intent2=new Intent("com.qiangfeng.Look");
                startActivity(intent2);


                break;

        }
    }

}

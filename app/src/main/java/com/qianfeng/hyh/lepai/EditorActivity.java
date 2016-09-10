package com.qianfeng.hyh.lepai;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameEdit,passwordEdit,emilEdit;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Button  backButton,commitButton;
    String name,password,emil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
       initView();
        preferences=getSharedPreferences("user_info",MODE_PRIVATE);
        editor=preferences.edit();
        backButton.setOnClickListener(this);
        commitButton.setOnClickListener(this);
    }

    private void initView() {
        nameEdit= (EditText) findViewById(R.id.registerNameEditId);
        passwordEdit= (EditText) findViewById(R.id.registerPasswordEditId);
        emilEdit= (EditText) findViewById(R.id.registerEmilEditId);
        backButton= (Button) findViewById(R.id.backRegisterId);
        commitButton= (Button) findViewById(R.id.commitSubmitId);

    }

    @Override
    public void onClick(View v) {
        name=nameEdit.getText().toString();
        password=passwordEdit.getText().toString();
        emil=emilEdit.getText().toString();
        switch (v.getId()){
            case R.id.backRegisterId:
                this.finish();
                break;
            case R.id.commitSubmitId:
                if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(password)&&!TextUtils.isEmpty(emil)) {
                    //使用edit的put方法存值
                    editor.putString("name", name);
                    editor.putString("password", password);
                    editor.putString("emil",emil);
                    //将操作提交
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "用户名密码不能为空", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}

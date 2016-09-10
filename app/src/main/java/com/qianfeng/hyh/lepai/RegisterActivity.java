package com.qianfeng.hyh.lepai;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameEdit, passwordEdit;
    Button registerbutton, loginbutton, backbutton;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        registerbutton.setOnClickListener(this);
        loginbutton.setOnClickListener(this);
        shared = getSharedPreferences("user_info", MODE_PRIVATE);
        editor = shared.edit();
    }

    private void initView() {
        nameEdit = (EditText) findViewById(R.id.nameEditTextId);
        passwordEdit = (EditText) findViewById(R.id.passwordEditTextId);
        registerbutton = (Button) findViewById(R.id.registerbuttonId);
        loginbutton = (Button) findViewById(R.id.loginbuttonId);
        backbutton = (Button) findViewById(R.id.backlogin1Id);
    }

    @Override
    public void onClick(View v) {
        name = nameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        switch (v.getId()) {
            case R.id.registerbuttonId:
                Intent intent = new Intent("com.qianfeng.editor");
                startActivity(intent);
                break;
            case R.id.loginbuttonId:
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    if (name.equals(shared.getString("name", "hyh")) &&
                            password.equals(shared.getString("password", "123"))) {
                        //要写diolog
                        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                        dialog.setTitle("登录中...");
                        dialog.create().show();
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(final DialogInterface dialog) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        dialog.dismiss();
                                    }
                                });
                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext(), "用户名密码错误", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "用户名密码不能为空", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.backlogin1Id:
                finish();
                break;
        }
    }
}

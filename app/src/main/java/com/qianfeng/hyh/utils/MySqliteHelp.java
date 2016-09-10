package com.qianfeng.hyh.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 16-9-9.
 */
public class MySqliteHelp extends SQLiteOpenHelper {
    private static final String SQNAME_STRING="collect.db";
    private static final int VERSION_NUM =1;

    public MySqliteHelp(Context context) {
        super(context,SQNAME_STRING, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table collect(_id integer primary key autoincrement,title varchar(100),weburl varchar(100),imageurl varchar(100))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}

package com.qianfeng.hyh.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownLoadUtils {

    public static String getJsonString(String url) {
        Log.d("hyh","url=================="+url);
        String jString = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            jString = response.body().string();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("hyh", "json=====================" + jString);
        return jString;
    }

    public static String getJsonStringUrl(String url) {
        Log.d("hyh", "getJsonStringUrl()=====================");
        String str = "";
        URL address1;
        InputStream in = null;
        HttpURLConnection connection1 = null;
        try {
            address1 = new URL(url);
            connection1 = (HttpURLConnection) address1.openConnection();
            connection1.setDoInput(true);
            connection1.connect();

            if (connection1.getResponseCode() == 100) {
                in = connection1.getInputStream();
                InputStreamReader inr = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(inr);
                String string = "";
                while ((string = reader.readLine()) != null) {
                    str = string;
                    Log.d("hyh", "URLjsonstr=====================" + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("hyh", "URLjsonstr=====================" + str);
        return str;
    }

    public static Bitmap getImageByteUrl(String url) {
        URL address;
        Bitmap bitmap = null;
        try {
            address = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) address.openConnection();
            connection.connect();
            if (connection.getResponseCode() == 200) {
                bitmap = BitmapFactory.decodeStream(connection.getInputStream());

            } else {
                Log.d("hyh", "connect fail");
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bitmap;
    }

    public static byte[] getImageByte(String url) {
        byte[] b = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            b = response.body().bytes();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("hyh", "byte====================" + b);
        return b;
    }
}

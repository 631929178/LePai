package com.qianfeng.hyh.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class HeaderVideoBean {


    /**
     * type : ad
     * url : http://image.fengniao.com/slide/533/5331428_1.html#p=1
     * title : 少女的曼妙身姿 来自莫斯科的性感与优雅
     * pic_src : http://shougong.fn.img-space.com/g1/M00/05/C0/Cg-4rFagoOqIeYtbAAD4OEjbkAcAAPEYQGlQv8AAPhQ312.jpg
     * date : 2016-01-22 06:11:12
     * author :
     * comment_page_num :
     * comments_num : 0
     * more_comment_url :
     * web_url : http://image.fengniao.com/slide/533/5331428_1.html#p=1
     * doc_id :
     */

    private String type;
    private String url;
    private String title;
    private String pic_src;
    private String date;
    private String author;
    private String comment_page_num;
    private int comments_num;
    private String more_comment_url;
    private String web_url;
    private String doc_id;

    public static HeaderVideoBean objectFromData(String str) {

        return new Gson().fromJson(str, HeaderVideoBean.class);
    }

    public static List<HeaderVideoBean> arrayHeaderVideoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HeaderVideoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment_page_num() {
        return comment_page_num;
    }

    public void setComment_page_num(String comment_page_num) {
        this.comment_page_num = comment_page_num;
    }

    public int getComments_num() {
        return comments_num;
    }

    public void setComments_num(int comments_num) {
        this.comments_num = comments_num;
    }

    public String getMore_comment_url() {
        return more_comment_url;
    }

    public void setMore_comment_url(String more_comment_url) {
        this.more_comment_url = more_comment_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }
}

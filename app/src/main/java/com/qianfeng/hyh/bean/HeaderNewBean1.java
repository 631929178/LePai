package com.qianfeng.hyh.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-5.
 */
public class HeaderNewBean1 {


    /**
     * type : doc
     * url : http://api.fengniao.com/app_ipad/news_iphone_doc_v1.php?docid=5331536
     * title : 从诺基亚到微软的昂贵“情怀”
     * pic_src : http://shougong.fn.img-space.com/g1/M00/05/D7/Cg-4rFaom2-IfugRAAC5qBp7-X8AAPNHwI7FacAALnA570.jpg
     * date : 2016-01-28 06:00:00
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5331536&isPad=1
     * web_url : http://qsy.fengniao.com/533/5331536.html
     * doc_id : 5331536
     * author : 张璋
     */

    private String title;
    private String pic_src;
    private String web_url;

    public static HeaderNewBean1 objectFromData(String str) {

        return new Gson().fromJson(str, HeaderNewBean1.class);
    }

    public static List<HeaderNewBean1> arrayHeaderNewBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<HeaderNewBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
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

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}

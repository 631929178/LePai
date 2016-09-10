package com.qianfeng.hyh.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class VideoBean {


    /**
     * totalpage : 689
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":689}
     * cid : 192
     * list : [{"title":"金长旭\u201c情系雪域高原\u201d摄影作品展在京开幕","pic_url":"http://img2.fengniao.com/article/12_280x210/971/liRbm47ZvpYL2.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338596&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338596&isPad=1","doc_id":"5338596","web_url":"http://image.fengniao.com/533/5338596.html"},{"title":"杨麾摄影展《我的嘉陵江》于中国摄影展览馆开幕","pic_url":"http://img2.fengniao.com/article/12_280x210/911/li4FUkYKuUOw.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338545&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338545&isPad=1","doc_id":"5338545","web_url":"http://image.fengniao.com/533/5338545.html"},{"title":"当代最著名的纪实摄影家\u2014\u2014马克·吕布过世","pic_url":"http://img2.fengniao.com/article/12_280x210/835/liDqYhdaPpyM.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338504&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338504&isPad=1","doc_id":"5338504","web_url":"http://image.fengniao.com/533/5338504.html"},{"title":"海外课程｜摄影与知识","pic_url":"http://img2.fengniao.com/article/12_280x210/759/liphv3j1OP6wM.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338413&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338413&isPad=1","doc_id":"5338413","web_url":"http://image.fengniao.com/533/5338413.html"},{"title":"先锋课程｜肖像与环境","pic_url":"http://img2.fengniao.com/article/12_280x210/758/liTCVczmCAZA.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338412&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338412&isPad=1","doc_id":"5338412","web_url":"http://image.fengniao.com/533/5338412.html"},{"title":"海外课程 | 画意 铂鈀印相","pic_url":"http://img2.fengniao.com/article/12_280x210/756/liZtgC5Apa2ZM.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338404&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338404&isPad=1","doc_id":"5338404","web_url":"http://image.fengniao.com/533/5338404.html"}]
     */

    private int cid;
    /**
     * title : 金长旭“情系雪域高原”摄影作品展在京开幕
     * pic_url : http://img2.fengniao.com/article/12_280x210/971/liRbm47ZvpYL2.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338596&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338596&isPad=1
     * doc_id : 5338596
     * web_url : http://image.fengniao.com/533/5338596.html
     */

    private List<ListBean> list;

    public static VideoBean objectFromData(String str) {

        return new Gson().fromJson(str, VideoBean.class);
    }

    public static List<VideoBean> arrayVideoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<VideoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class TotalpageBean {
        private int totalpage;

        public static TotalpageBean objectFromData(String str) {

            return new Gson().fromJson(str, TotalpageBean.class);
        }

        public static List<TotalpageBean> arrayTotalpageBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TotalpageBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }
    }

    public static class ListBean {
        private String title;
        private String pic_url;
        private String doc_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;
        private String doc_id;
        private String web_url;

        public static ListBean objectFromData(String str) {

            return new Gson().fromJson(str, ListBean.class);
        }

        public static List<ListBean> arrayListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}

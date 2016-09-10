package com.qianfeng.hyh.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class CollegeBean {

    /**
     * totalpage : 881
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":881}
     * cid : 190
     * list : [{"title":"海鲜游艇大别墅！豪华拍星免费送！","pic_url":"http://img2.fengniao.com/article/12_280x210/996/liobRLQxBU6Y.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338662&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338662&isPad=1","doc_id":"5338662","web_url":"http://academy.fengniao.com/533/5338662.html"},{"title":"跳过新手期 你应该知道的9个低光下拍摄的小技巧","pic_url":"http://img2.fengniao.com/article/12_280x210/927/liPnPYvxZUJU.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338593&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338593&isPad=1","doc_id":"5338593","web_url":"http://academy.fengniao.com/533/5338593.html"},{"title":"专业人士之絮叨：没事别想不开去做职业摄影师","pic_url":"http://img2.fengniao.com/article/12_280x210/893/liUkwKGpVlA.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338546&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338546&isPad=1","doc_id":"5338546","web_url":"http://academy.fengniao.com/533/5338546.html"},{"title":"没有美术功底怎么行 专业修图师都在偷偷看这些","pic_url":"http://img2.fengniao.com/article/12_280x210/845/li3FOy1WRqteI.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338508&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338508&isPad=1","doc_id":"5338508","web_url":"http://academy.fengniao.com/533/5338508.html"},{"title":"开学啦 怎么给孩子拍组给力的开学季照片","pic_url":"http://img2.fengniao.com/article/12_280x210/808/liVGq6ThbEzo.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338474&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338474&isPad=1","doc_id":"5338474","web_url":"http://academy.fengniao.com/533/5338474.html"},{"title":"摄影师实例作品 如何通过照片讲述故事（下）","pic_url":"http://img2.fengniao.com/article/12_280x210/802/litiXeAw4z0Dc.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338463&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338463&isPad=1","doc_id":"5338463","web_url":"http://academy.fengniao.com/533/5338463.html"}]
     */

    private int cid;
    /**
     * title : 海鲜游艇大别墅！豪华拍星免费送！
     * pic_url : http://img2.fengniao.com/article/12_280x210/996/liobRLQxBU6Y.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338662&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338662&isPad=1
     * doc_id : 5338662
     * web_url : http://academy.fengniao.com/533/5338662.html
     */

    private List<ListBean> list;

    public static CollegeBean objectFromData(String str) {

        return new Gson().fromJson(str, CollegeBean.class);
    }

    public static List<CollegeBean> arrayCollegeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<CollegeBean>>() {
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

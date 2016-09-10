package com.qianfeng.hyh.bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-4.
 */
public class QiCaiBean {


    /**
     * totalpage : 3543
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":3543}
     * cid : 296
     * list : [{"title":"更均衡的一个5 佳能EOS 5D Mark IV评测","pic_url":"http://img2.fengniao.com/article/12_280x210/908/liDbbJmXjrkY.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338515&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338515&isPad=1","doc_id":"5338515","web_url":"http://qicai.fengniao.com/533/5338515.html"},{"title":"蜂鸟网延伸摄影＋ 开启宠物狂欢趴 ","pic_url":"http://img2.fengniao.com/article/12_280x210/889/lix7eE8Y2vxI.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338542&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338542&isPad=1","doc_id":"5338542","web_url":"http://qicai.fengniao.com/533/5338542.html"},{"title":"强大视频功能 松下三款数码相机或将发布","pic_url":"http://img2.fengniao.com/article/12_280x210/852/liS8TSNZC2GFQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338525&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338525&isPad=1","doc_id":"5338525","web_url":"http://qicai.fengniao.com/533/5338525.html"},{"title":"增iOS版SnapBridge 尼康D3400/500固件升级","pic_url":"http://img2.fengniao.com/article/12_280x210/850/litGCtdEj8Ak.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338522&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338522&isPad=1","doc_id":"5338522","web_url":"http://qicai.fengniao.com/533/5338522.html"},{"title":"新无反将出炉 佳能EOS M5或将于15日面世","pic_url":"http://img2.fengniao.com/article/12_280x210/843/liO3ET0YHeZQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338517&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338517&isPad=1","doc_id":"5338517","web_url":"http://qicai.fengniao.com/533/5338517.html"},{"title":"强强联手 阿尔帕公司将与哈苏建立合作关系","pic_url":"http://img2.fengniao.com/article/12_280x210/863/liOe2oO22OB2.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338524&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338524&isPad=1","doc_id":"5338524","web_url":"http://qicai.fengniao.com/533/5338524.html"}]
     */

    private int cid;
    /**
     * title : 更均衡的一个5 佳能EOS 5D Mark IV评测
     * pic_url : http://img2.fengniao.com/article/12_280x210/908/liDbbJmXjrkY.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338515&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338515&isPad=1
     * doc_id : 5338515
     * web_url : http://qicai.fengniao.com/533/5338515.html
     */

    private List<ListBean> list;

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

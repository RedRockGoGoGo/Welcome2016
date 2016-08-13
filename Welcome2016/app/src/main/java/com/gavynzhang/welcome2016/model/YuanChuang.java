package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class YuanChuang {
    /**
     * status : 200
     * info : success
     * total : 9
     * data : [{"id":"94","name":"看见重邮","time":"03：45","introduction":"重庆邮电大学首部延时、航拍摄影","video_url":"http://v.youku.com/v_show/id_XNzExODM3Njk2.html?from=y1.2-1-95.3.12-2.1-1-1-11-0","photo":[{"id":"94","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_1772056394.png","photo_thumbnail_src":""}]},{"id":"95","name":"时间都去哪了","time":"04：08","introduction":"时间都去哪了重邮版（终版）","video_url":"http://v.youku.com/v_show/id_XMTI2NjE0MDcwNA==.html?from=s1.8-1-1.2","photo":[{"id":"95","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_77077589.png","photo_thumbnail_src":""}]},{"id":"96","name":"重庆邮电大学红岩网校2013宣传视频","time":"05：14","introduction":"重庆邮电大学红岩网校2013宣传视频","video_url":"http://v.youku.com/v_show/id_XNjA4NjQwMzY4.html?from=s1.8-1-1.2","photo":[{"id":"96","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_1650121257.png","photo_thumbnail_src":""}]},{"id":"97","name":"舌尖上的重邮","time":"12：28","introduction":"舌尖上的重邮第一季 屌丝大学 第一集","video_url":"http://v.youku.com/v_show/id_XNzA0MDc2ODA0.html?from=s1.8-1-1.1","photo":[{"id":"97","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_1328585235.png","photo_thumbnail_src":""}]},{"id":"98","name":"舌尖上的重邮","time":"12:28","introduction":"舌尖上的重邮第一季 舌尖上的南山之极乐宝鉴 第二集","video_url":"http://v.youku.com/v_show/id_XNDAzNzQ1MjA4.html?from=s1.8-1-1.1","photo":[{"id":"98","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_591846509.png","photo_thumbnail_src":""}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 94
     * name : 看见重邮
     * time : 03：45
     * introduction : 重庆邮电大学首部延时、航拍摄影
     * video_url : http://v.youku.com/v_show/id_XNzExODM3Njk2.html?from=y1.2-1-95.3.12-2.1-1-1-11-0
     * photo : [{"id":"94","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_1772056394.png","photo_thumbnail_src":""}]
     */

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String name;
        private String time;
        private String introduction;
        private String video_url;
        /**
         * id : 94
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470765051_1772056394.png
         * photo_thumbnail_src :
         */

        private List<PhotoBean> photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public List<PhotoBean> getPhoto() {
            return photo;
        }

        public void setPhoto(List<PhotoBean> photo) {
            this.photo = photo;
        }

        public static class PhotoBean {
            private String id;
            private String photo_src;
            private String photo_thumbnail_src;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPhoto_src() {
                return photo_src;
            }

            public void setPhoto_src(String photo_src) {
                this.photo_src = photo_src;
            }

            public String getPhoto_thumbnail_src() {
                return photo_thumbnail_src;
            }

            public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
                this.photo_thumbnail_src = photo_thumbnail_src;
            }
        }
    }
}

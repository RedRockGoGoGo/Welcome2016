package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class Teacher {
    /**
     * status : 200
     * info : success
     * total : 19
     * data : [{"id":"111","name":"王睿","college":"传媒艺术学院","photo":[{"id":"156","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846533_1579669020.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846533_1579669020.png"}]},{"id":"112","name":"王樱桃","college":"体育学院","photo":[{"id":"157","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846533_959256232.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846533_959256232.png"}]},{"id":"113","name":"付蔚","college":"自动化学院","photo":[{"id":"158","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846533_1028292138.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846533_1028292138.png"}]},{"id":"114","name":"朱伟","college":"理学院","photo":[{"id":"159","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_726090530.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_726090530.png"}]},{"id":"115","name":"张清华","college":"理学院","photo":[{"id":"160","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_2031029026.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_2031029026.png"}]},{"id":"116","name":"闵绪国","college":"马克思主义学院","photo":[{"id":"161","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_624787097.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_624787097.png"}]},{"id":"117","name":"陈褀褀","college":"传媒艺术学院","photo":[{"id":"162","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_759745361.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_759745361.png"}]},{"id":"118","name":"袁帅","college":"生物信息学院","photo":[{"id":"163","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_1409024292.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_1409024292.png"}]},{"id":"119","name":"高非","college":"外国语学院","photo":[{"id":"164","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_612037759.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_612037759.png"}]},{"id":"120","name":"漆晶","college":"通信与信息工程学院","photo":[{"id":"165","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_2011853428.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_2011853428.png"}]},{"id":"121","name":"罗元","college":"光电工程学院","photo":[{"id":"166","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846534_1189443398.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846534_1189443398.png"}]},{"id":"122","name":"郑继明","college":"理学院","photo":[{"id":"167","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_852659826.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_852659826.png"}]},{"id":"123","name":"胡庆","college":"通信与信息工程学院","photo":[{"id":"168","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_2127958043.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_2127958043.png"}]},{"id":"124","name":"高冬","college":"体育学院","photo":[{"id":"169","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_836160139.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_836160139.png"}]},{"id":"125","name":"彭语良","college":"法学院","photo":[{"id":"170","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_1258265554.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_1258265554.png"}]},{"id":"126","name":"蒋青","college":"通信与信息工程学院","photo":[{"id":"171","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_946057102.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_946057102.png"}]},{"id":"127","name":"熊安萍","college":"计算机科学与技术学院","photo":[{"id":"172","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_600447416.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_600447416.png"}]},{"id":"128","name":"张琬悦","college":"外国语学院","photo":[{"id":"173","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846535_1163595478.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846535_1163595478.png"}]},{"id":"129","name":"周兴茂","college":"马克思主义学院","photo":[{"id":"174","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846536_183864425.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846536_183864425.png"}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 111
     * name : 王睿
     * college : 传媒艺术学院
     * photo : [{"id":"156","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846533_1579669020.png","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846533_1579669020.png"}]
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
        private String college;
        /**
         * id : 156
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470846533_1579669020.png
         * photo_thumbnail_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470846533_1579669020.png
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

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
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

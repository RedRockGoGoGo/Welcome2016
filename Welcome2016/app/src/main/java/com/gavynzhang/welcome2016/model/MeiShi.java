package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class MeiShi {
    /**
     * status : 200
     * info : success
     * total : 60
     * data : [{"id":"24","name":"老寨火锅","address":"老校门对面堕落街","introduction":"好吃不上火，价格公道","photo":[{"id":"23","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_111940508.jpg","photo_thumbnail_src":""}]},{"id":"25","name":"吹2锅锅","address":"老校门对面堕落街","introduction":"量大分足，赏心悦目","photo":[{"id":"24","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_1268086337.jpg","photo_thumbnail_src":""}]},{"id":"26","name":"尝香思铁板烧","address":"老校门对面堕落街","introduction":"独具特色，回味悠长","photo":[{"id":"25","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_2049802964.jpg","photo_thumbnail_src":""}]},{"id":"27","name":"三顾冒菜","address":"老校门对面堕落街","introduction":"爽口回味，好吃不贵","photo":[{"id":"26","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_790150401.jpg","photo_thumbnail_src":""}]},{"id":"28","name":"重庆鸡公煲","address":"老校门对面堕落街","introduction":"好吃不辣，量足管饱","photo":[{"id":"27","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_731300161.jpg","photo_thumbnail_src":""}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 24
     * name : 老寨火锅
     * address : 老校门对面堕落街
     * introduction : 好吃不上火，价格公道
     * photo : [{"id":"23","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_111940508.jpg","photo_thumbnail_src":""}]
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
        private String address;
        private String introduction;
        /**
         * id : 23
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764295_111940508.jpg
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
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

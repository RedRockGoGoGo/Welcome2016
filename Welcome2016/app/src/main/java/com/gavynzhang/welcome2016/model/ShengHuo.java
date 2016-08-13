package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/11.
 */
public class ShengHuo {
    /**
     * status : 200
     * info : success
     * total : 19
     * data : [{"id":"5","name":"中国农业银行","address":"新校门出门右转","photo":[{"id":"4","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_1556282000.jpg","photo_thumbnail_src":""}]},{"id":"6","name":"多乐迪KTV","address":"新校门出门右转，中国农业银行楼下","photo":[{"id":"5","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_1557421461.jpg","photo_thumbnail_src":""}]},{"id":"7","name":"新世纪超市","address":"新校门出门右转，多乐迪KTV楼上","photo":[{"id":"6","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_1778947311.jpg","photo_thumbnail_src":""}]},{"id":"8","name":"永辉超市","address":"新校门出门过马路，右转直走","photo":[{"id":"7","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_2114167375.jpg","photo_thumbnail_src":""}]},{"id":"9","name":"百世快递","address":"老校门出门，过马路，左转直走，杀牛王火锅旁边","photo":[{"id":"8","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_870369637.jpg","photo_thumbnail_src":""}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 5
     * name : 中国农业银行
     * address : 新校门出门右转
     * photo : [{"id":"4","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_1556282000.jpg","photo_thumbnail_src":""}]
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
        /**
         * id : 4
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764192_1556282000.jpg
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

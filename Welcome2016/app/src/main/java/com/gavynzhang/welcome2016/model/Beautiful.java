package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class Beautiful {
    /**
     * status : 200
     * info : success
     * total : 10
     * data : [{"id":"133","name":"美在重邮","photo":[{"id":"204","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897559_1650848205.png","photo_thumbnail_src":""}]},{"id":"134","name":"美在重邮","photo":[{"id":"205","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_784723949.png","photo_thumbnail_src":""}]},{"id":"135","name":"美在重邮","photo":[{"id":"206","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_1736116716.png","photo_thumbnail_src":""}]},{"id":"136","name":"美在重邮","photo":[{"id":"207","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_955080211.png","photo_thumbnail_src":""}]},{"id":"137","name":"美在重邮","photo":[{"id":"208","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_1759917085.png","photo_thumbnail_src":""}]},{"id":"138","name":"美在重邮","photo":[{"id":"209","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_2017862403.png","photo_thumbnail_src":""}]},{"id":"139","name":"美在重邮","photo":[{"id":"210","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_1513349539.png","photo_thumbnail_src":""}]},{"id":"140","name":"美在重邮","photo":[{"id":"211","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_463113203.png","photo_thumbnail_src":""}]},{"id":"141","name":"美在重邮","photo":[{"id":"212","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_1290153522.png","photo_thumbnail_src":""}]},{"id":"142","name":"美在重邮","photo":[{"id":"213","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897560_1293872718.png","photo_thumbnail_src":""}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 133
     * name : 美在重邮
     * photo : [{"id":"204","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897559_1650848205.png","photo_thumbnail_src":""}]
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
        /**
         * id : 204
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470897559_1650848205.png
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

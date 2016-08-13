package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/11.
 */
public class QinShi {

    /**
     * status : 200
     * info : success
     * data : [{"id":"1","introduction":"宿舍情况 : 宿舍床铺的长宽大致为 80cm*200cm，每栋宿舍的床\r\n会有略微的差别。1、 5、 6 是学校现存最老的寝室。 住宿条件比较差。 今年 1 栋改\r\n为了研究生宿舍，5、 6 栋的 4 人间调整为 3 人间，而 6 人间调整\r\n为了 4 人间，住宿空间较以前有了比较大的改善。 整体情况是每\r\n层楼设有公用的卫生间、 洗澡间，这也就意味着每个寝室都没有\r\n独立卫生间，没有阳台。 处于校园中心，上课、 生活都极其便\r\n利。","photo":[{"id":"1","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470763956_291793194.jpg","photo_thumbnail_src":""}]},{"id":"2","introduction":"8-12 栋位于学校情人坡旁边，是学校标准的 4 人间，上床下桌，\r\n配有阳台，独立卫生间。 楼栋周边环境一流，食堂与超市一应俱\r\n全，为\r\n学习生活提供不少的便利","photo":[{"id":"2","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470763956_1104598126.jpg","photo_thumbnail_src":""}]},{"id":"3","introduction":"15-20 栋分布在太极运动场的南边与东边。 周边有学校的兴业院\r\n食堂及众多的超市、 商铺，校车从这里穿过。 寝室内部均设有独\r\n立卫生间，并在一些楼层设有洗衣机供大家使用，根据每栋宿舍\r\n不同，楼层不同分为 4 人间、 6 人间两种。 4 人间基本情况与 8-\r\n12 栋一样，而 6 人间则是上下铺与上床下桌的混搭。","photo":[{"id":"3","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470763956_1386435489.jpg","photo_thumbnail_src":""}]},{"id":"4","introduction":"22-24 屹立于悠悠重邮高处，周边风景秀丽，无论冬夏\r\n存，每至冬季，一旁还有腊梅香气飘来。 楼栋门前不\r\n车等路过，其周边有\u201c千喜鹤\u201d、 \u201c好食基\u201d、 \u201c红高粱\u201d等\r\n重邮阳光超市、 叮当超市、 华生园等购物场所，交通\r\n尽情满足同学们的平日生活需求。 此外，楼栋内部住\r\n22-24 屹立于悠悠重邮高处，周边风景秀丽，无论冬夏，绿色永\r\n存，每至冬季，一旁还有腊梅香气飘来。 楼栋门前不时还会有校\r\n车等路过，其周边有\u201c千喜鹤\u201d、 \u201c好食基\u201d、 \u201c红高粱\u201d等食堂，还有\r\n重邮阳光超市、 叮当超市、 华生园等购物场所，交通便利，可以\r\n尽情满足同学们的平日生活需求。 此外，楼栋内部住宿条件优\r\n越，环境较好，22 栋全部为 4 人间寝室，与 8-12 栋寝室情况基本一致）,23 及 24 全部为 6 人间寝室，且有独立的阳台、 卫浴。\r\n25-32 在学校的东南方向，周边分布有\u201c千喜鹤\u201d、 \u201c好食基\u201d食堂。\r\n宿舍基本为 6 人间基本情况与 22-24 相同且有独立的阳台、 卫\r\n浴，床铺是上下铺与上床下桌的混搭","photo":[]}]
     */

    private String status;
    private String info;
    /**
     * id : 1
     * introduction : 宿舍情况 : 宿舍床铺的长宽大致为 80cm*200cm，每栋宿舍的床
     会有略微的差别。1、 5、 6 是学校现存最老的寝室。 住宿条件比较差。 今年 1 栋改
     为了研究生宿舍，5、 6 栋的 4 人间调整为 3 人间，而 6 人间调整
     为了 4 人间，住宿空间较以前有了比较大的改善。 整体情况是每
     层楼设有公用的卫生间、 洗澡间，这也就意味着每个寝室都没有
     独立卫生间，没有阳台。 处于校园中心，上课、 生活都极其便
     利。
     * photo : [{"id":"1","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470763956_291793194.jpg","photo_thumbnail_src":""}]
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String introduction;
        /**
         * id : 1
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470763956_291793194.jpg
         * photo_thumbnail_src :
         */

        private List<PhotoBean> photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

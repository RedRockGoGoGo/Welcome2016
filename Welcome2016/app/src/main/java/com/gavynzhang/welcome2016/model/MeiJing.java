package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class MeiJing {
    /**
     * status : 200
     * info : success
     * total : 8
     * data : [{"id":"86","name":"大金鹰","tourroute":"1、\t在老校门乘坐346公交车在四中站下车\r\n2、\t步行至崇文路站（230米左右），搭乘384公交车在大金鹰下\r\n","introduction":"\u201c大金鹰\u201d雕塑，雄居在重庆南山671米高的鹞鹰岩上。上设有观景台，凭栏远眺，重庆数十里景物尽收眼底。据说，此系目前重庆最高的观景点。","photo":[{"id":"86","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_385704503.jpg","photo_thumbnail_src":""}]},{"id":"87","name":"黄葛古道","tourroute":"上新街爬南山上山的一条路（搭347/346在上新街下）","introduction":"黄葛古道,是重庆市知名度最高的一条古道,有着800年历史,曾是历代川黔商贾的必经之地,被称为重庆的\u201c丝绸之道\u201d。该古道始于唐朝,宋、元、明、清时期处于鼎盛时期,属巴渝十二景之一。","photo":[{"id":"87","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_259290787.jpg","photo_thumbnail_src":""}]},{"id":"88","name":"重庆抗战遗址博物馆","tourroute":"1、\t在老校门乘坐346公交车在四中站下车\r\n2、\t步行至崇文路站（230米左右），搭乘384公交车在黄山站下\r\n","introduction":"重庆抗战遗址博物馆是集抗战遗址与原生态自然景观于一体的综合旅游和爱国主义教育基地；是一个有着丰富人文资源、自然资源和旅游资源的综合性抗战遗址博物馆旅游景区。","photo":[{"id":"88","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_2097138783.jpg","photo_thumbnail_src":""}]},{"id":"89","name":"老君洞","tourroute":"位于黄桷古道边","introduction":"老君洞道观是重庆主城区最大最主要的宫观，也是重庆市的重要道观。数百年来，每逢初一、十五或清明、中元等传统节日，香客朝香，游人登高，香火一时胜极。道观内香烟氤氲缭绕，山路上行人络绎不绝。","photo":[{"id":"89","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_392930877.jpg","photo_thumbnail_src":""}]},{"id":"90","name":"南滨路","tourroute":"1、从南坪步行约390米,到达南坪东路站\r\n2、乘坐375路,经过4站, 到达海棠烟雨广场站（也可乘坐373路）\r\n3、步行约200米,到达南滨路\r\n","introduction":"南滨路处于重庆市的中心地位，它北临长江，背依南山，可观最美渝中夜景；历史悠久的巴渝文化、宗教文化、开埠文化、大禹文化、码头文化、抗战遗址文化如珍珠般遍布沿线，使南滨路获得了\u201c重庆外滩\u201d的美誉。","photo":[{"id":"90","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_363709982.jpg","photo_thumbnail_src":""}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 86
     * name : 大金鹰
     * tourroute : 1、	在老校门乘坐346公交车在四中站下车
     2、	步行至崇文路站（230米左右），搭乘384公交车在大金鹰下

     * introduction : “大金鹰”雕塑，雄居在重庆南山671米高的鹞鹰岩上。上设有观景台，凭栏远眺，重庆数十里景物尽收眼底。据说，此系目前重庆最高的观景点。
     * photo : [{"id":"86","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_385704503.jpg","photo_thumbnail_src":""}]
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
        private String tourroute;
        private String introduction;
        /**
         * id : 86
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470764939_385704503.jpg
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

        public String getTourroute() {
            return tourroute;
        }

        public void setTourroute(String tourroute) {
            this.tourroute = tourroute;
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

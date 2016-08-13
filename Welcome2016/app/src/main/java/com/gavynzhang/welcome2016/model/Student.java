package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by a on 2016/8/12.
 */
public class Student {
    /**
     * status : 200
     * info : success
     * total : 11
     * data : [{"id":"103","name":"热则耶·吐尔洪","description":"党员模范之星","introduction":"一、基本信息\r\n 热则耶·吐尔洪，女，维吾尔族，中共党员，经济管理学院2012级经济学专业学生，担任学生五支部副书记、班级学习委员、寝室长。\r\n二、先进事迹\r\n 作为一名少数民族党员：\r\n 政策理论的传播者。该生作为共产党员，主动向少数民族同学宣传党的知识，解读党的民族政策，引领他们积极向党组织靠拢，2015年度荣获校\u201c优秀共产党员\u201d称号。\r\n 学习生活的帮扶者。该生主动融入学校、学院和班级，克服语言障碍，努力学习，一次性通过CET-4、CCT-2，并于2015年获得\u201c国家励志奖学金\u201d。该生不仅加强自身学习，而且主动对学院20名学业困难的新疆少数民族同学进行帮扶，邀请汉族同学进行一对一辅导，上学期无人挂科、16人通过英语四级、1人通过英语六级。\r\n 社会工作的组织者。该生连续两年担任早检员，服务同学；作为学校与少数民族同学联系的纽带，组织少数民族同学与汉族师生进行联谊，引导他们更好地融入集体。\r\n 作为一名学生党员干部：\r\n 以干部要求踏实做好工作。该生担任支部副书记期间，带领党员积极参与党组织各项活动；协助支部书记完成37名同学的党员发展工作；在2014年本科学生党员全员读书教育实践活动中，\u201c新形势下加强高校党员管理创新模式的研究\u201d课题成功立项。\r\n 以党员身份认真服务同学。该生担任学习委员期间，设置班级学习小组，组织\u201c学霸带我飞\u201d特色活动，号召同学参加各类科创活动，所在班级有18人次获得国家级、校级奖学金。\r\n三、获奖情况\r\n省部级：\r\n1.2015.11  国家励志奖学金\r\n校级：\r\n1.2015.10  优秀班干部 \r\n2.2015.06  优秀共产党员 \r\n3.2014.10  自立自强先进个人\r\n4.2014.06  数学建模竞赛三等奖\r\n5.2013.07  军训优秀学员 \r\n四、座右铭\r\n单丝不成线，独木不成林！\r\n","photo":[{"id":"145","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470844810_117248650.jpg","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470844810_117248650.jpg"}]}]
     */

    private String status;
    private String info;
    private String total;
    /**
     * id : 103
     * name : 热则耶·吐尔洪
     * description : 党员模范之星
     * introduction : 一、基本信息
     热则耶·吐尔洪，女，维吾尔族，中共党员，经济管理学院2012级经济学专业学生，担任学生五支部副书记、班级学习委员、寝室长。
     二、先进事迹
     作为一名少数民族党员：
     政策理论的传播者。该生作为共产党员，主动向少数民族同学宣传党的知识，解读党的民族政策，引领他们积极向党组织靠拢，2015年度荣获校“优秀共产党员”称号。
     学习生活的帮扶者。该生主动融入学校、学院和班级，克服语言障碍，努力学习，一次性通过CET-4、CCT-2，并于2015年获得“国家励志奖学金”。该生不仅加强自身学习，而且主动对学院20名学业困难的新疆少数民族同学进行帮扶，邀请汉族同学进行一对一辅导，上学期无人挂科、16人通过英语四级、1人通过英语六级。
     社会工作的组织者。该生连续两年担任早检员，服务同学；作为学校与少数民族同学联系的纽带，组织少数民族同学与汉族师生进行联谊，引导他们更好地融入集体。
     作为一名学生党员干部：
     以干部要求踏实做好工作。该生担任支部副书记期间，带领党员积极参与党组织各项活动；协助支部书记完成37名同学的党员发展工作；在2014年本科学生党员全员读书教育实践活动中，“新形势下加强高校党员管理创新模式的研究”课题成功立项。
     以党员身份认真服务同学。该生担任学习委员期间，设置班级学习小组，组织“学霸带我飞”特色活动，号召同学参加各类科创活动，所在班级有18人次获得国家级、校级奖学金。
     三、获奖情况
     省部级：
     1.2015.11  国家励志奖学金
     校级：
     1.2015.10  优秀班干部
     2.2015.06  优秀共产党员
     3.2014.10  自立自强先进个人
     4.2014.06  数学建模竞赛三等奖
     5.2013.07  军训优秀学员
     四、座右铭
     单丝不成线，独木不成林！

     * photo : [{"id":"145","photo_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470844810_117248650.jpg","photo_thumbnail_src":"http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470844810_117248650.jpg"}]
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
        private String description;
        private String introduction;
        /**
         * id : 145
         * photo_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/1470844810_117248650.jpg
         * photo_thumbnail_src : http://hongyan.cqupt.edu.cn/cyxbsMobile/Public/photo/welcomefreshman/thumbnail/1470844810_117248650.jpg
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

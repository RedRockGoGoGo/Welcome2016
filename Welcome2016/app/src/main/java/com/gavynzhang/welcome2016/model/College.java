package com.gavynzhang.welcome2016.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class College {

    private String collegeName;
    private List<major> majors;
    private List<difficult> difficults;
    private List<graduateSituation> graduationSituations;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<difficult> getDifficults() {
        return difficults;
    }

    public void setDifficults(List<difficult> difficults) {
        this.difficults = difficults;
    }

    public List<graduateSituation> getGraduationSituations() {
        return graduationSituations;
    }

    public void setGraduationSituations(List<graduateSituation> graduationSituations) {
        this.graduationSituations = graduationSituations;
    }

    public List<major> getMajors() {
        return majors;
    }

    public void setMajors(List<major> majors) {
        this.majors = majors;
    }

    public static class major{

        private String name;
        private int manNum;
        private int womenNum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getManNum() {
            return manNum;
        }
        public void setManNum(int manNum) {
            this.manNum = manNum;
        }

        public int getWomenNum() {
            return womenNum;
        }
        public void setWomenNum(int womenNum) {
            this.womenNum = womenNum;
        }
    }

    public static class difficult{

        //课程名
        private String course;
        //比例
        private double ratio;

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }
    }

    public static class graduateSituation{

        private String situation;
        private double ratio;

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }

        public String getSituation() {
            return situation;
        }

        public void setSituation(String situation) {
            this.situation = situation;
        }
    }
}

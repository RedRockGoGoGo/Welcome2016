package com.gavynzhang.welcome2016.model;

/**
 * Created by GavynZhang on 2016/8/7.
 */
public class Pie {

    private double number;
    private int color;
    private int textColor;
    private int deepColor;
    private int departNum;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public int getDepartNum() {
        return departNum;
    }

    public void setDepartNum(int departNum) {
        this.departNum = departNum;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDeepColor() {
        return deepColor;
    }

    public void setDeepColor(int deepColor) {
        this.deepColor = deepColor;
    }
}

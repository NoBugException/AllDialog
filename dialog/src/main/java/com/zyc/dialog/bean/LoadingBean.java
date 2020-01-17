package com.zyc.dialog.bean;

public class LoadingBean {

    //加载对话框类型
    private byte type;

    //背景颜色
    private int bgColor;

    //文本
    private String text;

    //文本颜色
    private int textColor;

    //弧度
    private int radii;

    public LoadingBean() { }

    public LoadingBean(int bgColor, String text, int textColor, int radii) {
        this.bgColor = bgColor;
        this.text = text;
        this.textColor = textColor;
        this.radii = radii;
    }

    public LoadingBean(int bgColor, String text, int textColor, int radii, byte type) {
        this.bgColor = bgColor;
        this.text = text;
        this.textColor = textColor;
        this.radii = radii;
        this.type = type;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

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

    public int getRadii() {
        return radii;
    }

    public void setRadii(int radii) {
        this.radii = radii;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}

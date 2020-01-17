package com.zyc.dialog.bean;

public class NormalBean {

    //标题
    private String title;

    //正文
    private String message;

    //标题颜色
    private int titleColor;

    //正文颜色
    private int messageColor;

    //标题文字大小
    private float titleTextSize;

    //正文文字大小
    private float messageTextSize;

    //按钮文字大小
    private float buttonTextSize;

    public NormalBean() {
    }

    public NormalBean(String title, String message, int titleColor, int messageColor, float titleTextSize, float messageTextSize, float buttonTextSize) {
        this.title = title;
        this.message = message;
        this.titleColor = titleColor;
        this.messageColor = messageColor;
        this.titleTextSize = titleTextSize;
        this.messageTextSize = messageTextSize;
        this.buttonTextSize = buttonTextSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public void setTitleTextSize(float titleTextSize) {
        this.titleTextSize = titleTextSize;
    }

    public float getMessageTextSize() {
        return messageTextSize;
    }

    public void setMessageTextSize(float messageTextSize) {
        this.messageTextSize = messageTextSize;
    }

    public float getButtonTextSize() {
        return buttonTextSize;
    }

    public void setButtonTextSize(float buttonTextSize) {
        this.buttonTextSize = buttonTextSize;
    }
}

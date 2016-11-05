package com.blueeagle.migrainebuddyui.Adapter;

public class EmptyReportItem {
    private String title;
    private String des;
    private int imTitle;
    private int imDes;

    public EmptyReportItem(String title, String des, int imTitle, int imDes) {
        this.title = title;
        this.des = des;
        this.imTitle = imTitle;
        this.imDes = imDes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImTitle() {
        return imTitle;
    }

    public void setImTitle(int imTitle) {
        this.imTitle = imTitle;
    }

    public int getImDes() {
        return imDes;
    }

    public void setImDes(int imDes) {
        this.imDes = imDes;
    }
}

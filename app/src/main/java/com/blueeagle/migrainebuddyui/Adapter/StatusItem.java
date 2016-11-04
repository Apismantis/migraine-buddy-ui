package com.blueeagle.migrainebuddyui.Adapter;


public class StatusItem {
    private String title;
    private String content;
    private String time;
    private int icon;

    public StatusItem(String title, String content, String time, int icon) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

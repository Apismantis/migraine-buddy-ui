package com.blueeagle.migrainebuddyui.Adapter;

public class NotificationItem {
    private String title;
    private String content;
    private String date;
    private String time;
    private int icon;

    public NotificationItem(String title, String content, String date, String time, int icon) {
        this.title = title;
        this.content = content;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

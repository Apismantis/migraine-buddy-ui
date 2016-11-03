package com.blueeagle.migrainebuddyui.Adapter;

public class EmptyReportItem {
    private int title;
    private String description;
    private int body;

    public EmptyReportItem(int title, String description, int body) {
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }
}

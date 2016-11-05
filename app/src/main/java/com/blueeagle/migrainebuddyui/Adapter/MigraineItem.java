package com.blueeagle.migrainebuddyui.Adapter;

public class MigraineItem {
    private String date;
    private String intensity;
    private String duration;

    public MigraineItem(String date, String intensity, String duration) {
        this.date = date;
        this.intensity = intensity;
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

package com.app.oclock.models;

public class Alarm {
    private String time;
    private String title;
    private String description;

    public Alarm(){}
    public Alarm(String time, String title, String description){
        this.time = time;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

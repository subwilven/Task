package com.example.android.task.POJO;

/**
 * Created by eslam on 08-Mar-18.
 */

public class Task {
    private String title;
    private String tag;
    private String photoUrl;
    private String podNumber;

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPodNumber() {
        return podNumber;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setPodNumber(String podNumber) {
        this.podNumber = podNumber;
    }
}

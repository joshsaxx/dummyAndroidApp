package com.example.mydummyproj;

import androidx.annotation.NonNull;

class Events {
    private String title;
    private String info;
    private String subtitle;
    private int imageID;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Events( String info , int imageID){
        this.title= title;
        this.info= info;
        this.imageID = imageID;
    }

    String getTitle(){
        return title;
    }

    String getInfo(){
        return info;
    }

    public int getImageID(){
        return imageID;
    }

    @NonNull
    @Override
    public String toString() {
        return title+info;
    }
}

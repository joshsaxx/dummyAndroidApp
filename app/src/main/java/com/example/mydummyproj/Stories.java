package com.example.mydummyproj;

import androidx.annotation.NonNull;

class Stories {
    private String title;
    private String info;
    private int imageID;



    public Stories(String title, String info , int imageID){
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

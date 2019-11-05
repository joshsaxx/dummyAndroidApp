package com.example.mydummyproj;

class Events {
    private String title;
    private String info;
    private int imageID;



    Events(String title, String info , int imageID){
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
}

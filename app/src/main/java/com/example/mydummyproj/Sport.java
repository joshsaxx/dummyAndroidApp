package com.example.mydummyproj;

class Sport {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private int resourceId;

    Sport(String title, String info, int resourceId) {
        this.title = title;
        this.info = info;
        this.resourceId = resourceId;
    }

    String getTitle() {
        return title;
    }


    String getInfo() {
        return info;
    }

    public int getResourceId() {
        return resourceId;
    }

}

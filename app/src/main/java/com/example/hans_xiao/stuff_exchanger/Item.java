package com.example.hans_xiao.stuff_exchanger;

public class Item {
    private String name;
    private int imageId;
    public Item (String name, int imageId) {
        this.name=name;
        this.imageId=imageId;
    }
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
}

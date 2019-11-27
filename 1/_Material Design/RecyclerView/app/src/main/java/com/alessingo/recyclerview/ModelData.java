package com.alessingo.recyclerview;

public class ModelData {

    private String name;
    private int image;

    public ModelData() {}

    public ModelData(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}

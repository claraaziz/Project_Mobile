package com.example.projectmobile;

public class ClassesModel {
    String name;
    String description;
    int image;

    public ClassesModel(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}

package com.example.recyclerviewtest;

public class Data {
    private String description;

    public Data(Data data) {

    }

    public Data(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
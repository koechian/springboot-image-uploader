package com.projects.image.uploader;

public class Media{

    private String id;
    private String fileName;

    public Media(String id, String fileName) {

        this.id = id;
        this.fileName = fileName;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

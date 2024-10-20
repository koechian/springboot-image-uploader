package com.projects.image.uploader;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class Media{

    private String id;

    @NotEmpty
    private String fileName;

    public byte[] getMediaData() {
        return mediaData;
    }

    private byte[] mediaData;

    public void setMediaData(byte[] mediaData) {
        this.mediaData = mediaData;
    }


    public Media(String id, String fileName) {

        this.id = id;
        this.fileName = fileName;

    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}

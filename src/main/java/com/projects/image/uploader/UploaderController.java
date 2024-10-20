package com.projects.image.uploader;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Validated
@RestController
public class UploaderController {

    private HashMap<String, Media> db = new HashMap<>(){{
        put("1",new Media("1","photo.jpg"));
        put("2",new Media("2","photo1.jpg"));
    }};

    @GetMapping("/api/getAll")
    public Collection<Media> get(){
        return db.values();
    }

    @GetMapping("/api/getOne/{id}")
    public Media get(@PathVariable String id){
        Media media = db.get(id);

        if (media == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return media;
    }

    @DeleteMapping("/api/delete/{id}")
    public Collection<Media> delete(@PathVariable @Valid String id){
        Media media = db.remove(id);

        if (media == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return db.values();

    }


    @PostMapping("/api/upload")
    public Media upload(@RequestPart("media") MultipartFile file) throws IOException  {

        Media media = new Media(UUID.randomUUID().toString(),file.getOriginalFilename());


        media.setMediaData(file.getBytes());

        db.put(media.getId(), media);


        return media;

    }
}

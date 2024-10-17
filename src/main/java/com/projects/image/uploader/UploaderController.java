package com.projects.image.uploader;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class UploaderController {

    private HashMap<String, Media> db = new HashMap<>(){{
        put("1",new Media("1","myphoto.jpg"));
        put("2",new Media("2","myphoto2.jpg"));
    }};

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/api/upload")
    public Collection<Media> get(){
        return db.values();
    }

    @GetMapping("/api/upload/{id}")
    public Media get(@PathVariable String id){
        Media media = db.get(id);

        if (media == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return media;
    }

    @DeleteMapping("/api/delete/{id}")
    public Collection<Media> delete(@PathVariable String id){
        Media media = db.remove(id);

        if (media == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return db.values();

    }
}

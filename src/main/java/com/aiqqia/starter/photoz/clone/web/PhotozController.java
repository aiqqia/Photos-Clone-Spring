package com.aiqqia.starter.photoz.clone.web;

import com.aiqqia.starter.photoz.clone.model.Photo;
import com.aiqqia.starter.photoz.clone.service.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photozService.remove(id);
//        Photo photo = photozService.remove(id);
//        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

//    in console
//    (async function deletePhoto(id) {
//        await fetch('http://localhost:8080/photoz/' + id, {
//                method: "DELETE"
//    })})("5");

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}

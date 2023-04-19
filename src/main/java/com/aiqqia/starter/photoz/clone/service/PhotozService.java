package com.aiqqia.starter.photoz.clone.service;

import com.aiqqia.starter.photoz.clone.model.Photo;
import com.aiqqia.starter.photoz.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

//@Component
@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

//    private Map<String, Photo> db = new HashMap<>() {{
//        put("1", new Photo("1", "Hello.jpg"));
//    }};

    public Iterable<Photo> get() {
//        return db.values(); instead of iterable use Collection
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
//        return db.get(id);
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
//        return db.remove(id);
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
//        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
//        db.put(photo.getId(), photo);
        photozRepository.save(photo);
        return photo;
    }
}

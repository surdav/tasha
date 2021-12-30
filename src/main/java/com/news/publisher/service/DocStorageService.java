package com.news.publisher.service;

import com.news.publisher.model.Doc;
import com.news.publisher.repo.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DocStorageService {

    @Autowired
    private DocRepo docRepo;

    public Doc saveFile(MultipartFile file) {
        String docName = file.getOriginalFilename();

        try {
            Doc doc = new Doc(docName, file.getContentType(), file.getBytes());
            return docRepo.save(doc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Optional<Doc> getFile(Integer fileId){
        return docRepo.findById(fileId);
    }

    public List<Doc> getFiles() {
        return docRepo.findAll();
    }
}

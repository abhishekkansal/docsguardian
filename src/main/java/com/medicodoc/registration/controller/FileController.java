package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.ViewFileData;
import com.medicodoc.registration.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping(value="/upload/{username}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadUserFiles(@RequestPart MultipartFile documentUploaded, @RequestPart String username) {
        String response;
        try {
            response= fileService.uploadFile(documentUploaded, username);
        } catch (Exception ex) {
            ex.printStackTrace();
            response= "not authorized";
        }
        return response;
    }


    @PostMapping(value="/view/{username}")
    public List<String> viewAllUserFiles(@RequestBody ViewFileData viewFileData) {
        List<String> response;
        try {
            response= fileService.viewAllFiles(viewFileData);
        } catch (Exception ex) {
            ex.printStackTrace();
            response= null;
        }
        return response;
    }
}
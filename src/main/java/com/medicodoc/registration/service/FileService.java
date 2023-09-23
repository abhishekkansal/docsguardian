package com.medicodoc.registration.service;

import com.medicodoc.registration.dto.request.ViewFileData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public String uploadFile(MultipartFile file, String username);
    public List<String> viewAllFiles(ViewFileData username);
}

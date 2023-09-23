package com.medicodoc.registration.service.impl;

import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.medicodoc.registration.AWS.Config;
import com.medicodoc.registration.AWS.S3Service;
import com.medicodoc.registration.dto.request.ViewFileData;
import com.medicodoc.registration.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class FileServiceImpl implements FileService {

    @Value("${aws.s3.order.bucket}")
    private String fileUploadBucketname;
    @Autowired
    private S3Service s3Service;
    @Override
    public String uploadFile(MultipartFile file, String username) {
        String response;
        try {
            s3Service.upload(fileUploadBucketname, (username+"_"+file.getName()), file.getInputStream());
            response="success";
        } catch (Exception ex) {
            System.out.println("unable to upload file");
            response="failed";
        }
        return response;
    }

    @Override
    public List<String> viewAllFiles(ViewFileData username) {
        List<String> urlList = new ArrayList<>();
        try {
            // List objects in the S3 bucket
            ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request()
                    .withBucketName(fileUploadBucketname);

            Config config = new Config();
            ListObjectsV2Result objectListing = config.getS3Client().listObjectsV2(listObjectsRequest);
//            ListObjectsV2Response objectListing2 = config.getS3Client().listObjectsV2(listObjectsRequest);

            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                String objectUrl = config.getS3Client().getUrl(fileUploadBucketname, objectSummary.getKey()).toString();
                System.out.println("Object URL: " + objectUrl);
                urlList.add(objectUrl);
            }
    }catch (Exception ex){
            ex.printStackTrace();
        }
        return urlList;
}
}

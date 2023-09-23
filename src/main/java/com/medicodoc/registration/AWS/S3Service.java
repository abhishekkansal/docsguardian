package com.medicodoc.registration.AWS;

import com.amazonaws.AmazonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class S3Service {
    @Autowired
    private Config awsConfig;

    public void upload(String path, String fileName, InputStream file) throws Exception {
        try {
            awsConfig.getS3Client().putObject(path, fileName, file, null);
        } catch (AmazonServiceException e) {
            throw new Exception("AWS SDK failed to upload the file");
        }
    }




}

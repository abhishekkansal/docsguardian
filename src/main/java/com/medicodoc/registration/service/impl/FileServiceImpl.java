package com.medicodoc.registration.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.medicodoc.registration.AWS.Config;
import com.medicodoc.registration.AWS.S3Service;
import com.medicodoc.registration.dto.request.ViewFileData;
import com.medicodoc.registration.service.FileService;
import org.apache.poi.ss.formula.functions.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@Component
public class FileServiceImpl implements FileService {


    @Value("${aws.region}")
    private String s3Region;

    @Autowired
    private Config awsConfig;
    @Value("${aws.s3.order.bucket}")
    private String fileUploadBucketname;
    @Autowired
    private S3Service s3Service;

    @Override
    public String uploadFile(MultipartFile file, String username) {
        String response;
        try {

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);
            awsConfig.getS3Client().putObject(fileUploadBucketname, username+"/"+formattedDateTime+"_"+file.getOriginalFilename(), file.getInputStream(), null);
            response = "success";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("unable to upload file");
            response = "failed";
        }
        return response;
    }

    @Override
    public List<String> viewAllFiles(ViewFileData username) {
        List<String> urlList = new ArrayList<>();
//        try {
//        Replace "your_access_key_id" and "your_secret_access_key" with your actual credentials
//
            // Create an Amazon S3 client
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(Regions.US_EAST_1) // Replace with your desired region
//                    .withCredentials(new AWSStaticCredentialsProvider(
//                            new BasicAWSCredentials(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretKey"))))
//                    .build();

//            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
//                    .withRegion(Regions.AP_SOUTH_1)
//                    .withCredentials(new AWSStaticCredentialsProvider
//                            (new BasicAWSCredentials("ACCESS_KEY","SECRET_KEY")))
//                    .build();


//            try (S3Client s3 = Ss3Client.builder()
//                    .region(Region.of(s3Region)) // Replace with your desired region
//                    .credentialsProvider(credentialsProvider)
//                    .build()) {
//
//                ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
//                        .bucket(fileUploadBucketname)
//                        .build();
//
//                ListObjectsV2Response listObjectsResponse = s3.listObjectsV2((listObjectsRequest));
//
//                for (S3Object s3Object : listObjectsResponse.contents()) {
//                    String key = s3Object.key();
//                    long size = s3Object.size();
//                    String eTag = s3Object.eTag();
//                    // Add more details as needed
//
//                    System.out.println("Key: " + key);
//                    System.out.println("Size: " + size + " bytes");
//                    System.out.println("ETag: " + eTag);
//                    // Print or store other details
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }}
//            catch (Exception ex){
//                ex.printStackTrace();
//            }
        return urlList;
    }
    }


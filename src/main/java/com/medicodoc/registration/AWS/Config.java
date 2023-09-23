package com.medicodoc.registration.AWS;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${aws.region}")
    private String s3Region;

    private AWSCredentials awsCredentials;

    @Bean
    public AmazonS3 getS3Client() {
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(s3Region)
                .build();
    }
}
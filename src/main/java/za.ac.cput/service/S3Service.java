package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

import java.time.Duration;

/**
 * S3Service.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 13-Aug-24
 */
@Service
public class S3Service {

    private final S3Presigner presigner;

    // Inject the S3 bucket name from the application.properties
    @Value("${aws.s3.bucket}")
    private String bucketName;

    // Constructor with S3Presigner injected from S3Config
    @Autowired
    public S3Service(S3Presigner presigner) {
        this.presigner = presigner;
    }

    // Method to generate a presigned URL for uploading an object to S3
    public String generatePresignedUrl(String objectKey, String contentType) {
        // Create a request to put an object in the S3 bucket
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .contentType(contentType)
                .build();

        // Generate a presigned request for the PUT operation with a 10-minute expiration
        PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(r ->
                r.signatureDuration(Duration.ofMinutes(10))
                        .putObjectRequest(objectRequest)
        );

        // Return the presigned URL as a string
        return presignedRequest.url().toString();
    }
}

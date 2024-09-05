package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

/**
 * S3Config.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 05-Sep-24
 */

@Configuration
public class S3Config {

    // Injecting values from application.properties
    @Value("${aws.accessKeyId}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public S3Client s3Client() {
        // Use the injected values to configure S3Client
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey) // Using injected access and secret keys
                ))
                .build();
    }

    @Bean
    public S3Presigner s3Presigner() {
        // Use the injected values to configure S3Presigner
        return S3Presigner.builder()
                .region(Region.of(region)) // Using injected region value
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey) // Using injected access and secret keys
                ))
                .build();
    }
}
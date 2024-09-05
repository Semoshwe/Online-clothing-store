package za.ac.cput.factory;

import za.ac.cput.domain.Presigned;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * PresignedFactory.java
 *
 * @author Rethabile Ntsekhe
 * @date 14-Aug-24
 */
public class PresignedFactory {

    /**
     * Factory method to create a Presigned object.
     *
     * @param presignedUrl the URL to be set in the Presigned object
     * @return a Presigned object or null if the URL is null or empty
     */
    public static Presigned createPresigned(String presignedUrl) {
        if (Helper.isNullOrEmpty(presignedUrl)) {
            return null;
        }

        // Create a Presigned object using the builder pattern
        return Presigned.builder()
                .url(presignedUrl) // Set the URL
                .build();
    }
}

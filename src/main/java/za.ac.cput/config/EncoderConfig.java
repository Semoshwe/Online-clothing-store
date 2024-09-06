package za.ac.cput.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*** EncoderConfig.java** This class provides the configuration for password encoding.* It defines a bean for the BCryptPasswordEncoder to be used across the application.*/

@Configuration
public class EncoderConfig {

    /*** Bean definition for PasswordEncoder using BCrypt.** This method returns a BCryptPasswordEncoder instance to encode passwords* before storing them.** @return the PasswordEncoder instance used for encoding passwords.*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig.java
 *
 * This class provides the security configuration for the application.
 * It handles user authentication and authorization, and specifies which endpoints
 * are accessible to specific roles.
 *
 * Author: Rethabile Ntsekhe
 * Date: 24-Aug-24
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Configures the HttpSecurity for authorization and authentication settings.
     *
     * - Admin endpoints ("/api/admin/**") are restricted to users with the "ADMIN" role.
     * - User endpoints ("/api/user/**") are restricted to users with the "USER" role.
     * - Other endpoints are accessible to all users without authentication.
     *
     * It also configures a custom login page and enables logout functionality.
     *
     * @param http the HttpSecurity object used for configuring web-based security.
     * @return the SecurityFilterChain to be used by the security framework.
     * @throws Exception if an error occurs while configuring HttpSecurity.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        /* .requestMatchers("store/api/users/**").permitAll() // Allow access to product endpoints
                         .requestMatchers("/api/admin/**").hasRole("ADMIN")
                         .requestMatchers("/api/user/**").hasRole("USER")
                         .anyRequest().authenticated()*/
                        .anyRequest().permitAll() //Allow all requests without authentication
                )
                .formLogin(formLogin -> formLogin
                                .disable() // Disable form login
                        /*.loginPage("/login")
                        .permitAll()*/
                )
                .logout(logout -> logout
                                .disable()
                        /*.permitAll()*/
                )
                .csrf(csrf -> csrf
                        .disable()  // Disable CSRF for testing; enable and configure properly in production
                );
        return http.build();
    }

    /*** Configures the AuthenticationManagerBuilder for user authentication.* It sets the userDetailsService to the UserService and specifies the password* encoder.** @param auth the AuthenticationManagerBuilder object used for configuring authentication.* @throws Exception if an error occurs while configuring authentication.*/
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}

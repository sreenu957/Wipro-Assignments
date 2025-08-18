package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    private final PasswordEncoder encoder;
    public UserConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin").password(encoder.encode("admin123")).roles("ADMIN").build(),
            User.withUsername("teacher").password(encoder.encode("teacher123")).roles("TEACHER").build(),
            User.withUsername("student").password(encoder.encode("student123")).roles("STUDENT").build()
        );
    }
}

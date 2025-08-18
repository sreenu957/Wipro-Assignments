package com.learning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                
                .requestMatchers(HttpMethod.GET, "/api/courses/**")
                    .hasAnyRole("STUDENT","TEACHER","ADMIN")
               
                .requestMatchers(HttpMethod.POST, "/api/courses/**")
                    .hasAnyRole("TEACHER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/courses/**")
                    .hasAnyRole("TEACHER","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/courses/**")
                    .hasRole("ADMIN")
                .requestMatchers("/actuator/**", "/eureka/**")
                	.permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


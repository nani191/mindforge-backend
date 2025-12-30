package com.mindforge.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // 🔓 allow POST from frontend
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()  // Public
                .anyRequest().authenticated()             // All else require login
            )
            .httpBasic(Customizer.withDefaults());         // Temporary basic auth

        return http.build();
    }
}

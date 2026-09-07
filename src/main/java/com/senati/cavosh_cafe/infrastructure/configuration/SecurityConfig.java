package com.senati.cavosh_cafe.infrastructure.configuration;

import com.senati.cavosh_cafe.infrastructure.port.BCryptPasswordHasher;
import com.senati.cavosh_cafe.infrastructure.port.JwtTokenGenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.senati.cavosh_cafe.application.port.PasswordHasher;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;
import com.senati.cavosh_cafe.application.port.TokenGenerator;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BCryptPasswordHasher passwordHasher(PasswordEncoder encoder) {
        return new BCryptPasswordHasher(encoder);
    }

    @Bean
    public PasswordVerifier passwordVerifier(BCryptPasswordHasher passwordHasher) {
        return passwordHasher;
    }

    @Bean
    public PasswordHasher passwordHasherPort(BCryptPasswordHasher passwordHasher) {
        return passwordHasher;
    }

    @Bean
    public TokenGenerator jwtTokenGenerator(
            @Value("${security.jwt.secret-key}") String secretKey) {
        return new JwtTokenGenerator(secretKey);
    }
}

package com.senati.cavosh_cafe.infrastructure.configuration;

import com.senati.cavosh_cafe.infrastructure.port.BCryptPasswordHasher;
import com.senati.cavosh_cafe.infrastructure.port.JwtTokenGenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.senati.cavosh_cafe.application.port.PasswordHasher;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;
import com.senati.cavosh_cafe.application.port.TokenGenerator;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin.disable())
                .logout(logout -> logout.disable());

        return http.build();
    }

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

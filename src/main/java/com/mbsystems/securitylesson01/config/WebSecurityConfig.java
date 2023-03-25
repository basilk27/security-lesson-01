package com.mbsystems.securitylesson01.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.crypto.password.NoOpPasswordEncoder.*;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailService = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("bill")
                .password("12345")
                .authorities("read")
                .build();

        userDetailService.createUser(user1);

        return userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return getInstance();
    }
}

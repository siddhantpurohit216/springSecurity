package com.springSecuriy.springsecuritysec1.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defultsSecurityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll());
        http.formLogin(dfl->dfl.disable());
        http.httpBasic(dhb->dhb.disable());
        return http.build();
    }
}

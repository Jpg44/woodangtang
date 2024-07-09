package com.game.backend.config;


import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;
//@EnableWebSecurity
public class securityConfig{
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity http)throws Exception{
//        http
//                .authorizeRequests()
//                .requestMatchers("/public/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll());
//
//                return http.build();
//    }
}

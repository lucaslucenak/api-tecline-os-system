//package com.lucaslucena.APIosSystemTecLine.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig {
//
//    final UserDetailsServiceImplementation userDetailsServiceImplementation;
//
//    public WebSecurityConfig(UserDetailsServiceImplementation userDetailsServiceImplementation) {
//        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .cors()
//                .and()
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

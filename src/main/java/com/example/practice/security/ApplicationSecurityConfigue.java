package com.example.practice.security;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.practice.security.ApplicationUserPermission.*;
import static com.example.practice.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfigue extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordConfig passwordConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.GET, "/manage/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest().authenticated()
                .and().httpBasic();
    }

//     provide user detail
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        // create student role
        UserDetails userDetails = User.builder()
                .username("user")
                .password(passwordConfig.passwordEncoder().encode("password"))
                .roles(ADMIN.name())
                .build();

        // creeate admin role
        UserDetails userAttaporn = User.builder()
                .username("Attaporn")
                .password(passwordConfig.passwordEncoder().encode("password123"))
                .roles(STUDENT.name())
                .build();

        UserDetails userTom = User.builder()
                .username("tom")
                .password(passwordConfig.passwordEncoder().encode("password123"))
                .roles(ADMINTRAINEE.name())
                .build();

        return new InMemoryUserDetailsManager(
                userDetails,
                userAttaporn,
                userTom
        );
    }
}

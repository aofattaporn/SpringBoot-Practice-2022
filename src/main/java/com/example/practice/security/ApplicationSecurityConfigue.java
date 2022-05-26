package com.example.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
//                .antMatchers("api/**").hasRole(ApplicationUserRole.STUDENT.name())
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
                .roles(ApplicationUserRole.ADMIN.name())
                .build();

        // creeate admin role
        UserDetails userAttaporn = User.builder()
                .username("Attaporn")
                .password(passwordConfig.passwordEncoder().encode("password123"))
                .roles(ApplicationUserRole.STUDENT.name())
                .build();

        return new InMemoryUserDetailsManager(
                userDetails,
                userAttaporn
        );
    }
}

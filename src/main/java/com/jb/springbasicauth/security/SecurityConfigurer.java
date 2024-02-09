package com.jb.springbasicauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

    @Bean
    public InMemoryUserDetailsManager inMemoryUsers() {

        UserDetails ashokUser = User.withDefaultPasswordEncoder()
                .username("jb")
                .password("jb")
                .authorities("ADMIN")
                .build();


        UserDetails johnUser = User.withDefaultPasswordEncoder()
                .username("john")
                .password("john")
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(ashokUser, johnUser);

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/contact", "/swagger-ui.html").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }
}

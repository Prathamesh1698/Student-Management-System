package com.itvedant.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.itvedant.studentmanagement.services.AuthFacultyService;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/modules/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/modules/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/registeredFaculties**").permitAll()
                .requestMatchers(HttpMethod.GET, "/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/register").permitAll()
                .requestMatchers(HttpMethod.GET, "/students").permitAll()
                .requestMatchers(HttpMethod.GET, "/teachers").permitAll()
                .requestMatchers("/students/**").hasRole("HR")
                .requestMatchers("/teachers/**").hasAnyRole("Head", "HR")
                .requestMatchers("/students/**").hasAnyRole("Head", "HR")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .authenticationProvider(daoAuthenticationProvider());

        return http.build();
    }

    @Autowired
    private AuthFacultyService facultyService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.facultyService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users() {

        UserDetails user1 = User.builder()
                .username("Pattu")
                .password(passwordEncoder().encode("abc@123"))
                .roles("HR")
                .build();

        UserDetails user2 = User.builder()
                .username("Rashmi")
                .password(passwordEncoder().encode("RPK@123"))
                .roles("Tester")
                .build();

        UserDetails user3 = User.builder()
                .username("Prachi")
                .password(passwordEncoder().encode("PK@123"))
                .roles("Marketing", "Head")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}

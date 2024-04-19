package com.application.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf ->csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http ->{
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAnyAuthority("READ");
//                    http.anyRequest().denyAll();
//                })
//                .build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf ->csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> userDetailsList = new ArrayList<>();

        userDetailsList.add(User.withUsername("John")
                .password("1234")
                .roles("ADMIN")
                .authorities("READ", "CREATE")
                .build());

        userDetailsList.add(User.withUsername("Dave")
                .password("1234")
                .roles("USER")
                .authorities("READ")
                .build());

        userDetailsList.add(User.withUsername("James")
                .password("1234")
                .roles("USER")
                .authorities("READ")
                .build());



        return new InMemoryUserDetailsManager(userDetailsList);
    }


}

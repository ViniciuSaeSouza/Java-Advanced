package br.com.fiap.fin_money_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/categories/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults()).build();
    }
    @Bean
    UserDetailsService userDetailsService() {
        var users = List.of(
                User.withUsername("saes")
                        .password("$2a$12$WxAFfwG8tu02xaYAoMb5Lui9U7zENCuXuaZZOY7OPOMGuBSLxsAOW")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("maria")
                        .password("$2a$12$8bkCfYtKa0a5IQDm3mTMA.4RZASectZnpGg1ZgL3aL0gpgx.CM4b.")
                        .roles("USER")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

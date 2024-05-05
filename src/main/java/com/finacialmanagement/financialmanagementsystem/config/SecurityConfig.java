package com.finacialmanagement.financialmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig{

//    @Autowired
//    private UserService userDetailService;

//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(registry -> {
//                    registry.requestMatchers( "users/register","users/this").permitAll();
////                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
////                    registry.requestMatchers("/user/**").hasRole("USER");
//                    registry.anyRequest().authenticated();
//                })
//                .formLogin(httpSecurityFormLoginConfigurer -> {
//                    httpSecurityFormLoginConfigurer
//                            .loginPage("/users/login")
//                            .permitAll();
//                })
//                .build();
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return userDetailService;
//    }
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//    return security.csrf(csrf->csrf.disable())
//            .authorizeHttpRequests(auth->
//                    auth.anyRequest().authenticated().requestMatchers("/login").permitAll()
//            )
//            .formLogin(login->login.loginPage("/login")
//                    .loginProcessingUrl("/login")
//                    .defaultSuccessUrl("/welcome")
//                    .permitAll())
//            .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .permitAll())
//            .build();
//
//}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",configuration);
//        return source;
//    }
}

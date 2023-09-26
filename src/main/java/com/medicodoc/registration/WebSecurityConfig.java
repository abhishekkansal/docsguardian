package com.medicodoc.registration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = getCorsConfiguration();
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().cors().configurationSource(request -> corsConfiguration);
    }


    //    This Method has enabled CORS for all the domains
    private CorsConfiguration getCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of(CorsConfiguration.ALL));
        corsConfiguration.setAllowedOrigins(List.of(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(List.of(CorsConfiguration.ALL));
        corsConfiguration.setExposedHeaders(List.of(CorsConfiguration.ALL));
        return corsConfiguration;
    }
}
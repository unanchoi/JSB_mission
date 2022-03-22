package com.misson.mission3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
                .antMatchers("home/**")
                .anonymous()
//                .antMatchers("board/*/post/** ")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
        ;
    }

}
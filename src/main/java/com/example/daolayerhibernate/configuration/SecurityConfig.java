package com.example.daolayerhibernate.configuration;

import com.example.daolayerhibernate.enums.Authorities;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .authorities(Authorities.ADMIN.name())
                .and()
                .withUser("user")
                .password("{noop}user")
                .authorities(Authorities.USER.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/find-all").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/create-new-person").hasAnyAuthority(Authorities.ADMIN.name())
                .and()
                .authorizeRequests().antMatchers("/persons/delete-by-id").hasAnyAuthority(Authorities.ADMIN.name())
                .and()
                .authorizeRequests().antMatchers("/persons/**").hasAnyAuthority(Authorities.ADMIN.name(), Authorities.USER.name());
    }
}

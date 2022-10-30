package com.example.springboot3.SpringBoot3.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthEntryPoint authEntryPoint;

    @Autowired
    private UserDetailsService uDetailsServ;


    @Autowired
    private JWTMiddleware middleware;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(uDetailsServ).passwordEncoder(bcryptEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                // Los endpoints /login y /register no necesitan ser autenticados.			
                .authorizeRequests().antMatchers("/login", "/register").permitAll().
                // El resto de los endpoints necesita el token JWT para validar el request.
                anyRequest().authenticated().and().
                exceptionHandling().authenticationEntryPoint(authEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Agregamos el filtro para validar el token JWT en cada request.
        httpSecurity.addFilterBefore(middleware, UsernamePasswordAuthenticationFilter.class);
    }

}

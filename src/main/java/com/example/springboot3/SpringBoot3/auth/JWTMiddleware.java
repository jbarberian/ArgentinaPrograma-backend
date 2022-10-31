package com.example.springboot3.SpringBoot3.auth;

import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JWTMiddleware extends OncePerRequestFilter{
    
    @Autowired
    private UserDetailsService uDetailsServ;
    
    @Autowired
    private JWTtokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        
        final String requestTokenHeader = request.getHeader("Authorization");
        
        String username = null;
        String token = null;
        
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            token = requestTokenHeader.substring(7);
            
            try {
                username = tokenUtil.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                System.out.print("Unable to get JWT Token: {} "+e.getMessage());                
            } catch (ExpiredJwtException e) {
                System.out.print("JWT Token has expired: {}: " + e.getMessage()); 
            }
        }
            
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails uDetails = this.uDetailsServ.loadUserByUsername(username);
            if (tokenUtil.validateToken(token, uDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(uDetails, null, uDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        chain.doFilter(request, response);
    }		
}
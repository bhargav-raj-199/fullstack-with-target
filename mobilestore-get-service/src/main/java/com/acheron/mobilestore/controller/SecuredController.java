package com.acheron.mobilestore.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/secured")
public class SecuredController {

  @GetMapping("/secured")
   @PreAuthorize("hasAnyRole('ADMIN', 'ROLE_ADMIN')")
  public String securedResource(Authentication auth) {
      String userName = (String) ((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("name");
      // JSObject roles = (JSObject) ((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("realm_access");
      Collection<? extends GrantedAuthority> authorities
              = Arrays.asList(((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("realm_access").toString().split(",")).stream()
              .map(authority -> new SimpleGrantedAuthority(authority))
              .collect(Collectors.toList());
      return "This is a SECURED resource. Authentication: " + userName + "; Authorities: " + authorities;
  }

  @GetMapping("/role")
  @PreAuthorize("hasAnyRole('CUSTOMER')")
  public String securedResourceNa(Authentication auth) {
      String userName = (String) ((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("name");
      // JSObject roles = (JSObject) ((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("realm_access");
      Collection<? extends GrantedAuthority> authorities
              = Arrays.asList(((Jwt) ((JwtAuthenticationToken) auth).getPrincipal()).getClaims().get("realm_access").toString().split(",")).stream()
              .map(authority -> new SimpleGrantedAuthority(authority))
              .collect(Collectors.toList());
      return "This is a SECURED resource";
  }

}

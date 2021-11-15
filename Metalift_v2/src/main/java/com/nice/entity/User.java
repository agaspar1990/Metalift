package com.nice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User implements UserDetails, Serializable{



    @GeneratedValue
    @Id
    private UUID id;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    private boolean enabled = true;

    @Column(unique = true)
    private String username;
    private String password;
    private String fullName;
    private final Set<GrantedAuthority> authorities = new HashSet<>();



    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
}
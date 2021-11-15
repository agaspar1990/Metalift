package com.nice.dto;


import com.nice.entity.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;

    @NotBlank
    @Email
    private String username;
    @NotBlank
    private String fullName;
    @NotBlank
    private String password;
    @NotBlank
    private String rePassword;
    private Set<Role> authorities;


}

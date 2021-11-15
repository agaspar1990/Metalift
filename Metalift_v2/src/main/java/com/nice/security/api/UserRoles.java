package com.nice.security.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@AllArgsConstructor
@Data
public class UserRoles {
    private String ROLE_USER, ROLE_ADMIN;


}

package com.nice.security.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nice.entity.Role;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "api/admin/user")
@RolesAllowed(Role.ROLE_ADMIN)
public class UserAdminApi {

    // Details omitted for brevity

}

package com.nice.security.api;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.web.bind.annotation.*;
import com.nice.entity.Role;
import javax.annotation.security.RolesAllowed;

@RestController @RequestMapping(path = "/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseApi {

    // Details omitted for brevity

    @RolesAllowed(Role.ROLE_ADMIN)
    @PostMapping
    public void create() { }

    @RolesAllowed(Role.ROLE_ADMIN)
    @PutMapping("{id}")
    public void edit() { }

    @RolesAllowed(Role.ROLE_ADMIN)
    @DeleteMapping("{id}")
    public void delete() { }

    @RolesAllowed({Role.ROLE_USER, Role.ROLE_ADMIN})
    @GetMapping("{id}")
    public void get() { }

    @RolesAllowed({Role.ROLE_USER, Role.ROLE_ADMIN})
    @GetMapping
    public void getExercises() { }



}

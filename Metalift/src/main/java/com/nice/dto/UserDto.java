package com.nice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class UserDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("title")
    private String firstName;

    @JsonProperty("description")
    private String lastName;

    @JsonProperty("bodypart")
    private String email;

    @JsonProperty("bodypart")
    private String password;

    @JsonProperty("bodypart")
    private String phoneNumber;

    @JsonProperty("bodypart")
    private  String addressLine;

}



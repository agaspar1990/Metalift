package com.nice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ExerciseDto {

    private UUID id;
    @NotEmpty
    private String title;
    private String description;
    @ElementCollection
    @NotEmpty
    private List<@NotEmpty String> bodyParts;

}

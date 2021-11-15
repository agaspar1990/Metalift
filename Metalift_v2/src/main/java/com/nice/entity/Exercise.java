package com.nice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String title;
    private String description;
    @ElementCollection
    private List<String> bodyParts;
}

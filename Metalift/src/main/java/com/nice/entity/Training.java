package com.nice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;


@Entity
@Table(name = "trainings")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Training {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;


}
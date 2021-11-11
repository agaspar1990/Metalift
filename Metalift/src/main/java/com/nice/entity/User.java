package com.nice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "trainings")
@Data public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String addressLine;

}
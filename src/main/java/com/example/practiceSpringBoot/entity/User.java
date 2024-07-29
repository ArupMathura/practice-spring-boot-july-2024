package com.example.practiceSpringBoot.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}

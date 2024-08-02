package com.example.practiceSpringBoot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Integer id;

    @NotBlank(message = "User First name should not be blank or null")
    private String firstName;

    @NotBlank(message = "User Last name should not be blank or null")
    private String lastName;

    @NotBlank(message = "User Email should not be blank or null")
    @Email(message = "Email should be valid")
    private String email;

    /*public UserDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }*/
}

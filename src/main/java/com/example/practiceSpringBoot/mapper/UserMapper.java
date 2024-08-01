package com.example.practiceSpringBoot.mapper;

import com.example.practiceSpringBoot.dto.UserDTO;
import com.example.practiceSpringBoot.entity.User;

/*public class UserMapper {
    // get the data from entity and set it to dto
    public static UserDTO entityToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // get the data from dto and set it to entity
    public static User dtoToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }
}*/

public class UserMapper {
    public static UserDTO entityToDto(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public static User dtoToEntity(UserDTO dto) {
        return new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}


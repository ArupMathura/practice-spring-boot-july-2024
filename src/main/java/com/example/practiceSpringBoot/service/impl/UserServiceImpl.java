package com.example.practiceSpringBoot.service.impl;

import com.example.practiceSpringBoot.dto.UserDTO;
import com.example.practiceSpringBoot.entity.User;
import com.example.practiceSpringBoot.exception.ResourceNotFoundException;
import com.example.practiceSpringBoot.mapper.UserMapper;
import com.example.practiceSpringBoot.repository.UserRepository;
import com.example.practiceSpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        /*if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new RuntimeException("User with ID " + user.getId() + " already exists.");
        }*/

        // convert UserDto to User JPA entity
//        User user = UserMapper.dtoToEntity(dto);
        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);

        // convert User Jpa entity to UserDto
//        UserDTO savedUserDto = UserMapper.entityToDto(savedUser);
        UserDTO savedUserDto = modelMapper.map(savedUser, UserDTO.class);

        return savedUserDto;

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        /*List<UserDTO> userDTOS = userList.stream()
                .map(UserMapper::entityToDto)
                .collect(Collectors.toList());*/
        List<UserDTO> userDTOS = userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("User", "id", userId);
                });
//        UserDTO userDTO = UserMapper.entityToDto(user);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("User", "id", userId);
                });

        log.info("Existing User Data: {}", existingUser);
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        log.info("Updated User Data: {}", existingUser);
        User savedUpdatedUser = userRepository.save(existingUser);
//            return UserMapper.entityToDto(savedUpdatedUser);
        return modelMapper.map(savedUpdatedUser, UserDTO.class);

    }

    @Override
    public void deleteUser(int userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("User", "id", userId);
                });

        userRepository.deleteById(userId);

    }


}

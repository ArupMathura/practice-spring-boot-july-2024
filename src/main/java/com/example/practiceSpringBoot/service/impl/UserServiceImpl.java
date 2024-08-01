package com.example.practiceSpringBoot.service.impl;

import com.example.practiceSpringBoot.dto.UserDTO;
import com.example.practiceSpringBoot.entity.User;
import com.example.practiceSpringBoot.mapper.UserMapper;
import com.example.practiceSpringBoot.repository.UserRepository;
import com.example.practiceSpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO dto) {
        /*if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new RuntimeException("User with ID " + user.getId() + " already exists.");
        }*/

        User user = UserMapper.dtoToEntity(dto);

        User savedUser = userRepository.save(user);

        UserDTO savedUserDto = UserMapper.entityToDto(savedUser);

        return savedUserDto;

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOS = userList.stream()
                .map(UserMapper::entityToDto)
                .collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new RuntimeException("User with ID " + userId + " not found.");
                });
        UserDTO userDTO = UserMapper.entityToDto(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(int userId, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            log.info("Existing User Data: {}", updatedUser);
            updatedUser.setFirstName(userDTO.getFirstName());
            updatedUser.setLastName(userDTO.getLastName());
            updatedUser.setEmail(userDTO.getEmail());
            log.info("Updated User Data: {}", updatedUser);
            User savedUpdatedUser = userRepository.save(updatedUser);
            return UserMapper.entityToDto(savedUpdatedUser);
        }
        else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }

    @Override
    public void deleteUser(int userId) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            userRepository.deleteById(userId);
        }
        else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }


}

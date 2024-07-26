package com.example.profiles.service;

import com.example.profiles.models.User;
import com.example.profiles.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()){
            String password = userRepository.findById(user.getId()).get().getPassword();
            if (Objects.equals(user.getPassword(), password)){
                return userRepository.save(user);
            }
        }
        return null;
    }
}

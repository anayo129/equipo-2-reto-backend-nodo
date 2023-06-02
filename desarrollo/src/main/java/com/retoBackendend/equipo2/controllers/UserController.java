package com.retoBackendend.equipo2.controllers;

import com.retoBackendend.equipo2.models.User;
import com.retoBackendend.equipo2.models.exceptions.BusinessException;
import com.retoBackendend.equipo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/users")
public class UserController {
    //agregar endpoint creación de usuario
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/users")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/api/users/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping("/api/users/name/{name}")
    public List<User> getUsersByName(@PathVariable String username) throws BusinessException {
        List<User> users = userRepository.findByUsername(username);
        if (users.isEmpty()) {
            throw new BusinessException("No se encontraron usuarios con el nombre: " + username);
        }
        return users;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/api/{email}")
    public void deleteUser(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @PutMapping("/api/users/{email}")
    public void updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            // Actualizar otros campos según sea necesario
            userRepository.save(user);
        }
    }
}

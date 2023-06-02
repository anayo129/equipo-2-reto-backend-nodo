package com.retoBackendend.equipo2.services;

import com.retoBackendend.equipo2.models.User;
import com.retoBackendend.equipo2.models.exceptions.BusinessException;
import com.retoBackendend.equipo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean areValidCredentials(String username, String password) {
        User user = userRepository.findByEmailAndPassword(username, password);
        return user != null;
        //Retorna true si las credenciales son válidas, false en caso contrario
    }

    public User getAuthenticatedUser(String username, String password) throws BusinessException{
        User user = userRepository.findByEmailAndPassword(username, password);
        if (user == null) {
            throw new BusinessException("Invalid credentials");
        }
        return user;
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) throws BusinessException{
        User user = userRepository.findByEmailAndPassword(username, oldPassword);
        if (user == null) {
            throw new BusinessException("Invalid credentials");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return true;
    }

    public boolean isAuthenticated(String username, String password) {
        return areValidCredentials(username, password);
    }
}
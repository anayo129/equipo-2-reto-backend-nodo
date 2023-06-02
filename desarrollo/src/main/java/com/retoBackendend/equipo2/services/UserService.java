package com.retoBackendend.equipo2.services;

import com.retoBackendend.equipo2.models.User;
import com.retoBackendend.equipo2.models.exceptions.BusinessException;

import java.util.List;

public interface UserService {
    // Define los métodos relacionados con la gestión de usuarios
    // Por ejemplo, métodos para crear, actualizar, obtener y eliminar usuarios

    void validateEmail(User user) throws BusinessException;
    User createUser(User user) throws BusinessException;
    User updateUser(User user) throws BusinessException;
    User getUserByEmail(User user) throws BusinessException;
    List<User> getAllUsers();
    void deleteUser(User user) throws BusinessException;
}
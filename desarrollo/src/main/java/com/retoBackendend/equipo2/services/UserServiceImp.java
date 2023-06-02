package com.retoBackendend.equipo2.services;

import com.retoBackendend.equipo2.models.User;
import com.retoBackendend.equipo2.models.exceptions.BusinessException;
import com.retoBackendend.equipo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void validateEmail(User user) throws BusinessException {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new BusinessException("Email is already in use");
        }
    }

    @Override
    public User createUser(User user) throws BusinessException{
        // Utiliza userRepository.save(user) para guardar el usuario en la base de datos
        if(user.getUsername() == null || user.getUsername().isBlank()){
            throw new BusinessException("Username is not valid");
        }
        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new BusinessException("Email is not valid");
        }
        if(user.getPassword() == null || user.getPassword().isBlank()){
            throw new BusinessException("Password is not valid");
        }

        validateEmail(user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws BusinessException{
        // Verificar si el usuario existe en la base de datos
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            throw new BusinessException("User not found"); // Lanzar una excepción si el usuario no existe
        }

        // Actualizar los campos relevantes del usuario existente
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setActive(user.isActive());

        // Guardar los cambios en la base de datos
        return userRepository.save(existingUser);
    }

    @Override
    public User getUserByEmail(User user) throws BusinessException{
        // Si se encuentra, retorna el usuario; de lo contrario, retorna null
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new BusinessException("Email is not valid");
        }

        User userFound = userRepository.findByEmail(user.getEmail());
        if (userFound == null) {
            throw new BusinessException("Email not found");
        }

        return userFound;
    }

    @Override
    public List<User> getAllUsers() {
        // Utiliza userRepository.findAll() para obtener la lista de usuarios de la base de datos
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) throws BusinessException{
        // Aquí puedes implementar la lógica para eliminar un usuario por su ID
        // Utiliza userRepository.deleteById(userId) para eliminar el usuario de la base de datos
        User userFound = userRepository.findByEmail(user.getEmail());
        if (userFound == null) {
            throw new BusinessException("User not found");
        }
        userRepository.delete(user);
    }
}

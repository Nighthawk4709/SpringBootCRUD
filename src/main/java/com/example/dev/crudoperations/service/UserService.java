package com.example.dev.crudoperations.service;

import com.example.dev.crudoperations.models.User;
import com.example.dev.crudoperations.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to perform functionalities for Application
 */
@Service
public class UserService {
    /**
     * Autowired means injection of UserRepository inside UserService
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to get all users registered inside Collections
     * @return all users present in collection
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Method to find user with specified id
     * @param id: Id for User
     * @return user with specified id or null
     */
    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

    /**
     * Create User
     * @param user: User Object containing all details
     * @return User added on Collection.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Method to update username, contact and email
     * @param id: Id for User
     * @param userDetails: UserDetails will carry the details present currently
     * @return Updated user
     */
    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setContact(user.getContact());
        return userRepository.save(user);
    }

    /**
     * Delete a present User
     * @param id: Id for the user that is to be deleted
     */
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

package com.example.dev.crudoperations;

import com.example.dev.crudoperations.models.User;
import com.example.dev.crudoperations.models.UserRepository;
import com.example.dev.crudoperations.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CrudoperationsApplicationTests  {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("1", "John", "john@example.com", "1234567890");
        User user2 = new User("2", "Jane", "jane@example.com", "0987654321");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
    }

    @Test
    public void testGetUserById() {
        User user = new User("1", "John", "john@example.com", "1234567890");

        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById("1");
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
    }

    @Test
    public void testCreateUser() {
        User user = new User("1", "John", "john@example.com", "1234567890");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User("1", "John", "john@example.com", "1234567890");
        User updatedDetails = new User("1", "Johnny", "johnny@example.com", "0987654321");

        when(userRepository.findById("1")).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User result = userService.updateUser("1", updatedDetails);
        assertNotNull(result);
        assertEquals("Johnny", result.getName());
        assertEquals("johnny@example.com", result.getEmail());
        assertEquals("1234567890", result.getContact());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById("1");

        userService.deleteUser("1");

        verify(userRepository, times(1)).deleteById("1");
    }
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.HealthRecord;
import com.example.demo.pojos.User;
import com.example.demo.repositories.ActivityRepository;
import com.example.demo.repositories.HealthRecordRepository;
import com.example.demo.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HealthRecordRepository healthRecordRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, HealthRecordRepository healthRecordRepository,
                           ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        this.healthRecordRepository = healthRecordRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public User registerUser(User user) {
        // Additional logic for user registration (e.g., validation, password encryption)
        // Check if the email is already registered
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // Encrypt the password
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @Override
    public List<HealthRecord> getHealthRecordsByUserId(Long userId) {
        // Additional logic if required (e.g., checking user access rights)
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the user has access rights to health records
        if (!hasAccessRights(user)) {
            throw new RuntimeException("User does not have access rights to health records");
        }

        return healthRecordRepository.findByUserId(userId);
    }

    @Override
    public Activity addActivity(Activity activity) {
        // Additional logic for activity creation (e.g., setting user ID, generating timestamps)
        // Set the user ID for the activity
        User user = userRepository.findById(activity.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        activity.setUser(user);

        // Generate timestamps
        LocalDateTime now = LocalDateTime.now();
        activity.setCreatedAt(now);
         activity.setUpdatedAt(now);

        return activityRepository.save(activity);
    }

    // Additional methods for the additional logic

    private String encryptPassword(String password) {
        // Implement password encryption logic here
        // You can use libraries like BCryptPasswordEncoder or other encryption algorithms
        return password;
    }

    private boolean hasAccessRights(User user) {
        // Implement access rights logic here
        // Check user role, permissions, or any other criteria to determine if they have access rights
        return user.getRole().equals("ADMIN");
    }
}


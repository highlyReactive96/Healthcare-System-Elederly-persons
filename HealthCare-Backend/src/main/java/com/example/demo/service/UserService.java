package com.example.demo.service;

import java.util.List;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.HealthRecord;
import com.example.demo.pojos.User;

public interface UserService {
    User registerUser(User user);
    List<HealthRecord> getHealthRecordsByUserId(Long userId);
    Activity addActivity(Activity activity);
    // Add other methods as needed
}


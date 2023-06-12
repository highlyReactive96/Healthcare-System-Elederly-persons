package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.User;
import com.example.demo.pojos.HealthRecord;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}/health-records")
    public ResponseEntity<List<HealthRecord>> getUserHealthRecords(@PathVariable Long userId) {
        List<HealthRecord> healthRecords = userService.getHealthRecordsByUserId(userId);
        return ResponseEntity.ok(healthRecords);
    }

    @PostMapping("/activities")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity addedActivity = userService.addActivity(activity);
        return new ResponseEntity<>(addedActivity, HttpStatus.CREATED);
    }

    // Additional endpoints and functionality as needed
}


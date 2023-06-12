package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.ActivityType;
import com.example.demo.pojos.User;
import com.example.demo.service.ActivityService;

@RestController
@RequestMapping("/users/{userId}/activities")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@PathVariable User userId, @RequestBody Activity activity) {
        activity.setUser(userId);
        Activity createdActivity = activityService.createActivity(activity);
        // Check if the activity is an exercise and enable reminder by default
        if (activity.getActivityType() == ActivityType.EXERCISE) {
            activityService.enableReminder(createdActivity.getId());
        }
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getActivitiesByUserId(@PathVariable User userId) {
        List<Activity> activities = activityService.getActivitiesByUser(userId);
        return ResponseEntity.ok(activities);
    }
    
    @PutMapping("/{activityId}/enable-reminder")
    public ResponseEntity<Void> enableReminder(@PathVariable Long activityId) {
        activityService.enableReminder(activityId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{activityId}/disable-reminder")
    public ResponseEntity<Void> disableReminder(@PathVariable Long activityId) {
        activityService.disableReminder(activityId);
        return ResponseEntity.ok().build();
    }

    // Add other endpoints and functionality as needed
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.User;

public interface ActivityService {
    Activity createActivity(Activity activity);
    //Optional<Activity> getActivitiesByUserId(Long userId);
    void enableReminder(Long activityId);
    void disableReminder(Long activityId);
    //we can  Add other methods as needed
	List<Activity> getActivitiesByUser(User user);
}


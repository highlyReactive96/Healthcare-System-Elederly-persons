package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Activity;
import com.example.demo.pojos.User;
import com.example.demo.repositories.ActivityRepository;
import com.example.demo.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivitiesByUser(User user) {
        return activityRepository.findByUser(user);
    }

    @Override
    public void enableReminder(Long activityId) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();
            // Enable the reminder for the activity
            activity.setReminderEnabled(true);
            activityRepository.save(activity);
        } else {
            throw new IllegalArgumentException("Activity not found with ID: " + activityId);
        }
    }

    @Override
    public void disableReminder(Long activityId) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();
            // Disable the reminder for the activity
            activity.setReminderEnabled(false);
            activityRepository.save(activity);
        } else {
            throw new IllegalArgumentException("Activity not found with ID: " + activityId);
        }
    }

    // Add other methods as needed
}

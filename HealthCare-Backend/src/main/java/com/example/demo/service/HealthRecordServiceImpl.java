package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.HealthRecord;
import com.example.demo.pojos.User;
import com.example.demo.repositories.HealthRecordRepository;
import com.example.demo.repositories.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HealthRecordServiceImpl implements HealthRecordService {

    private final HealthRecordRepository healthRecordRepository;
    private final UserRepository userRepository;

    @Autowired
    public HealthRecordServiceImpl(HealthRecordRepository healthRecordRepository, UserRepository userRepository) {
        this.healthRecordRepository = healthRecordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public HealthRecord createHealthRecord(Long userId, HealthRecord healthRecord) {
        // Additional logic for creating a health record (e.g., setting user ID, generating timestamps)
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        healthRecord.setUser(user);
        healthRecord.setCreatedAt(LocalDateTime.now());
        
        healthRecord.setMedicationStartDate(healthRecord.getMedicationStartDate());
        healthRecord.setMedicationEndDate(healthRecord.getMedicationEndDate());

        return healthRecordRepository.save(healthRecord);
    }

//    @Override
//    public List<HealthRecord> getHealthRecordsByUserId(Long userId) {
//        
//    }


//    @Override
//    public HealthRecord createHealthRecord(Long userId, HealthRecord healthRecord) {
//        // Existing logic
//
//        // Set medication details
//        
//
//        return healthRecordRepository.save(healthRecord);
//    }

    @Override
    public List<HealthRecord> getHealthRecordsByUserId(Long userId) {
    	return healthRecordRepository.findByUserId(userId);
    }

    @Override
    public List<HealthRecord> getActiveMedicationsByUserId(Long userId) {
        LocalDate currentDate = LocalDate.now();
        return healthRecordRepository.findByUserIdAndMedicationEndDateAfter(userId, currentDate);
    }
}

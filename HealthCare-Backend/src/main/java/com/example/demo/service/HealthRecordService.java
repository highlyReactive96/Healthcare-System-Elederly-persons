package com.example.demo.service;

import java.util.List;

import com.example.demo.pojos.HealthRecord;

public interface HealthRecordService {
    HealthRecord createHealthRecord(Long userId, HealthRecord healthRecord);
    List<HealthRecord> getHealthRecordsByUserId(Long userId);
//    List<HealthRecord> getHealthRecordsByUserId(Long userId);
    List<HealthRecord> getActiveMedicationsByUserId(Long userId);
}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojos.HealthRecord;
import com.example.demo.service.HealthRecordService;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/health-records")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthRecordController {

    private final HealthRecordService healthRecordService;

    @Autowired
    public HealthRecordController(HealthRecordService healthRecordService) {
        this.healthRecordService = healthRecordService;
    }

    @PostMapping
    public ResponseEntity<HealthRecord> createHealthRecord(@PathVariable Long userId, @RequestBody HealthRecord healthRecord) {
        HealthRecord createdHealthRecord = healthRecordService.createHealthRecord(userId, healthRecord);
        return new ResponseEntity<>(createdHealthRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HealthRecord>> getHealthRecordsByUserId(@PathVariable Long userId) {
        List<HealthRecord> healthRecords = healthRecordService.getHealthRecordsByUserId(userId);
        return ResponseEntity.ok(healthRecords);
    }

    @GetMapping("/active-medications")
    public ResponseEntity<List<HealthRecord>> getActiveMedicationsByUserId(@PathVariable Long userId) {
        List<HealthRecord> activeMedications = healthRecordService.getActiveMedicationsByUserId(userId);
        return ResponseEntity.ok(activeMedications);
    }

    // Additional endpoints and functionality as needed we can write here 
}


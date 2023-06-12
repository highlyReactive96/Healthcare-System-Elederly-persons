package com.example.demo.controllers;


import com.example.demo.pojos.Medication;
import com.example.demo.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/medications")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicationController {
    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@PathVariable Long userId, @RequestBody Medication medication) {
        Medication createdMedication = medicationService.createMedication(medication);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Medication>> getMedicationsByUserId(@PathVariable Long userId) {
//        List<Medication> medications = medicationService.getMedicationsByUserId(userId);
//        return ResponseEntity.ok(medications);
//    }

    @PutMapping("/{medicationId}/enable-reminder")
    public ResponseEntity<Void> enableReminder(@PathVariable Long medicationId) {
        medicationService.enableReminder(medicationId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{medicationId}/disable-reminder")
    public ResponseEntity<Void> disableReminder(@PathVariable Long medicationId) {
        medicationService.disableReminder(medicationId);
        return ResponseEntity.ok().build();
    }

 
}


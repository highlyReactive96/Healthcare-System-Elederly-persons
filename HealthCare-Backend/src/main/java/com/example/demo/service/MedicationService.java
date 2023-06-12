package com.example.demo.service;



import com.example.demo.pojos.Medication;

import java.util.List;

public interface MedicationService {
    Medication createMedication(Medication medication);
//    List<Medication> getMedicationsByUserId(Long userId);
    void enableReminder(Long medicationId);
    void disableReminder(Long medicationId);
    
}

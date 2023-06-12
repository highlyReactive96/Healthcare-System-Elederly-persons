package com.example.demo.service;



import com.example.demo.pojos.Medication;
import com.example.demo.repositories.MedicationRepository;
import com.example.demo.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

//    @Override
//    public List<Medication> getMedicationsByUserId(Long userId) {
//        return medicationRepository.findByUserId(userId);
//    }

    @Override
    public void enableReminder(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId).orElse(null);
        if (medication != null) {
            medication.setReminderEnabled(true);
            medicationRepository.save(medication);
        }
    }

    @Override
    public void disableReminder(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId).orElse(null);
        if (medication != null) {
            medication.setReminderEnabled(false);
            medicationRepository.save(medication);
        }
    }

    // Implement any additional methods as needed
}


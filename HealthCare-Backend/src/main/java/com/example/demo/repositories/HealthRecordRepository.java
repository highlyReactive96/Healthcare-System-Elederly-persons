package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.HealthRecord;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    List<HealthRecord> findByUserId(Long userId);
    List<HealthRecord> findByUserIdAndMedicationEndDateAfter(Long userId, LocalDate currentDate);

}


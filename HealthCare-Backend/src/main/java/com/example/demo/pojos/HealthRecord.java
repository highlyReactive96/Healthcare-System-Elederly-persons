package com.example.demo.pojos;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "health_records")
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "health_condition") // Change column name to health_condition
    private String condition;

    private String medication;

    private String notes;

    private boolean isEmergency;

    @Column(name = "medication_name")
    private String medicationName;

    @Column(name = "medication_dosage")
    private String medicationDosage;

    @Column(name = "medication_start_date")
    private LocalDate medicationStartDate;

    @Column(name = "medication_end_date")
    private LocalDate medicationEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors, getters, setters, and other methods

    // Additional methods can be implemented here
}

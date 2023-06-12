package com.example.demo.repositories;



import com.example.demo.pojos.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Add any additional methods as needed
}

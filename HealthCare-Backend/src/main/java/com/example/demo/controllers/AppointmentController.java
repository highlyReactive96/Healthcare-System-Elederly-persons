package com.example.demo.controllers;

import com.example.demo.pojos.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/appointments")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long userId, @RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@PathVariable Long userId) {
//        List<Appointment> appointments = appointmentService.getAppointmentsByUserId(userId);
//        return ResponseEntity.ok(appointments);
//    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Optional<Appointment>> getAppointmentById(@PathVariable Long appointmentId) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(appointmentId);
        // Check if the appointment exists
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<Void> updateAppointment(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        // Set the appointment ID to ensure it's updated correctly
        appointment.setId(appointmentId);
        appointmentService.updateAppointment(appointment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok().build();
    }

    // Add other endpoints and functionality as needed
}

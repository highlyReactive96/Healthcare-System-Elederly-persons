package com.example.demo.service;


import com.example.demo.pojos.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
//    List<Appointment> getAppointmentsByUserId(Long userId);
    Optional<Appointment> getAppointmentById(Long appointmentId);
    void updateAppointment(Appointment appointment);
    void cancelAppointment(Long appointmentId);
    
}

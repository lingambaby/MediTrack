package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private Map<Integer, Appointment> appointments = new HashMap<>();

    public void createAppointment(int patientId, int doctorId, LocalDate date) {

        Patient patient = new Patient(patientId, "Temp", 25, "General");
        Doctor doctor = new Doctor(doctorId, "TempDoc", 40,
                Specialization.GENERAL_PHYSICIAN, 500);

        Appointment appointment = new Appointment(
                IdGenerator.getInstance().generateId(),
                patient,
                doctor,
                date
        );

        appointments.put(appointment.getId(), appointment);

        System.out.println("Appointment Created");
    }
}

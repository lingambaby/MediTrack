package com.airtribe.meditrack.entity;

import java.time.LocalDate;

public class Appointment {

    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private AppointmentStatus status;

    public Appointment(int id, Patient patient, Doctor doctor, LocalDate date) {
        this.id = id;
        this.patient = patient.clone(); // deep copy
        this.doctor = doctor;
        this.date = date;
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        status = AppointmentStatus.CANCELLED;
    }

    public int getId() {
        return id;
    }
}

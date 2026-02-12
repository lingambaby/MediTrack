package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;

import java.util.Collection;

public class DoctorService {

    private DataStore<Doctor> dataStore = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        dataStore.save(doctor.getId(), doctor);
    }

    public Doctor getDoctor(int id) {
        return dataStore.findById(id);
    }


    public Collection<Doctor> getAllDoctors() {
        return dataStore.findAll();
    }
}

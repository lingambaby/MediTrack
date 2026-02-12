package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;

import java.util.Collection;

public class PatientService {

    private DataStore<Patient> dataStore = new DataStore<>();

    public void addPatient(Patient patient) {
        dataStore.save(patient.getId(), patient);
    }

    public Collection<Patient> getAllPatients() {
        return dataStore.findAll();
    }
}

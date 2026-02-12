package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable {

    private String symptoms;

    public Patient(int id, String name, int age, String symptoms) {
        super(id, name, age);
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }

    @Override
    public Patient clone() {
        try {
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

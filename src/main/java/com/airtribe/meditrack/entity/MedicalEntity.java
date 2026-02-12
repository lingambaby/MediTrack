package com.airtribe.meditrack.entity;

import java.io.Serializable;

public abstract class MedicalEntity implements Serializable {

    protected int id;

    public MedicalEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract void displayDetails();
}
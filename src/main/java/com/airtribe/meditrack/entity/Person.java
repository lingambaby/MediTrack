package com.airtribe.meditrack.entity;

public class Person extends MedicalEntity {

    private String name;
    private int age;

    public Person(int id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    // ===== Getters =====

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // ===== Setters =====

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ===== Display Method =====

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() +
                ", Name: " + name +
                ", Age: " + age);
    }
}

package com.airtribe.meditrack;
import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final DoctorService doctorService = new DoctorService();
    private static final PatientService patientService = new PatientService();
    private static final AppointmentService appointmentService = new AppointmentService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==== MediTrack ====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Create Appointment");
            System.out.println("4. View Doctors");
            System.out.println("5. View Patients");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String dName = sc.nextLine();
                    System.out.print("Age: ");
                    int dAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();

                    Doctor doctor = new Doctor(
                            IdGenerator.getInstance().generateId(),
                            dName,
                            dAge,
                            Specialization.GENERAL_PHYSICIAN,
                            fee
                    );

                    doctorService.addDoctor(doctor);
                    break;

                case 2:
                    System.out.print("Name: ");
                    String pName = sc.nextLine();
                    System.out.print("Age: ");
                    int pAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Symptoms: ");
                    String symptoms = sc.nextLine();

                    Patient patient = new Patient(
                            IdGenerator.getInstance().generateId(),
                            pName,
                            pAge,
                            symptoms
                    );

                    patientService.addPatient(patient);
                    break;

                case 3:
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();

                    appointmentService.createAppointment(
                            pid,
                            did,
                            LocalDate.now()
                    );
                    break;

                case 4:
                    doctorService.getAllDoctors()
                            .forEach(MedicalEntity::displayDetails);
                    break;

                case 5:
                    patientService.getAllPatients()
                            .forEach(Patient::displayDetails);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}

package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository repository = new EnrollmentRepository();

    public Enrollment enrollStudent(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(IdGenerator.getNextEnrollmentId(), studentId, courseId);
        repository.add(enrollment);
        return enrollment;
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return repository.findByStudentId(studentId);
    }

    public Enrollment getEnrollmentById(int id) throws EntityNotFoundException {
        Enrollment e = repository.findById(id);
        if (e == null) throw new EntityNotFoundException("Enrollment not found with ID: " + id);
        return e;
    }

    public boolean updateStatus(int enrollmentId, EnrollmentStatus status) throws EntityNotFoundException {
        Enrollment e = getEnrollmentById(enrollmentId);
        e.setStatus(status);
        return true;
    }
}


package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    private final StudentRepository repository = new StudentRepository();

    public Student addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                email,
                batch
        );
        repository.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return repository.getAll();
    }

    public Student getStudentById(int id) throws EntityNotFoundException {
        Student student = repository.findById(id);
        if (student == null) throw new EntityNotFoundException("Student not found with ID: " + id);
        return student;
    }

    public boolean deactivateStudent(int id) throws EntityNotFoundException {
        Student student = getStudentById(id);
        if (student.isActive()) {
            student.deactivate();
            return true;
        }
        return false;
    }
}


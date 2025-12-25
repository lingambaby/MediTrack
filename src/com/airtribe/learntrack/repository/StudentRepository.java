package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void add(Student student) { students.add(student); }
    public List<Student> getAll() { return students; }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean removeById(int id) {
        Student s = findById(id);
        if (s != null) return students.remove(s);
        return false;
    }
}

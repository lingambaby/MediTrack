package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public boolean removeById(int id) {
        Course c = findById(id);
        if (c != null) return courses.remove(c);
        return false;
    }
}


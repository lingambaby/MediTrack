package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {
    private final CourseRepository repository = new CourseRepository();

    public Course addCourse(String name, String description, int durationWeeks) {
        Course course = new Course(IdGenerator.getNextCourseId(), name, description, durationWeeks);
        repository.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return repository.getAll();
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        Course course = repository.findById(id);
        if (course == null) throw new EntityNotFoundException("Course not found with ID: " + id);
        return course;
    }

    public boolean deactivateCourse(int id) throws EntityNotFoundException {
        Course course = getCourseById(id);
        if (course.getStatus() == CourseStatus.ACTIVE) {
            course.setStatus(CourseStatus.INACTIVE);
            return true;
        }
        return false;
    }

    public boolean activateCourse(int id) throws EntityNotFoundException {
        Course course = getCourseById(id);
        if (course.getStatus() == CourseStatus.INACTIVE) {
            course.setStatus(CourseStatus.ACTIVE);
            return true;
        }
        return false;
    }
}

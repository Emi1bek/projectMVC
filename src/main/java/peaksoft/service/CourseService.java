package peaksoft.service;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    void addCourse(Long courseId, Course course);
    Course  getCourseById(Long id);
    void updateCourse(Long id, Course course);
    void deleteCourse(Course course);
    List<Course> getCoursesByCompany(Long companyId);

}

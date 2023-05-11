package peaksoft.service;

import peaksoft.entities.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Long groupId, Student student);
    List<Student> getAllStudent();
    Student  getStudentById(Long id);
    void updateStudent(Long id, Student student);
    void deleteStudent(Student student);

}

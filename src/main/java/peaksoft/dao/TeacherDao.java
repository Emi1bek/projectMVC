package peaksoft.dao;

import peaksoft.entities.Group;
import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Long groupId, Teacher  teacher);
    List<Teacher> getAllTeacher();
    Teacher  getTeacherById(Long id);
    void updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Teacher teacher);
}

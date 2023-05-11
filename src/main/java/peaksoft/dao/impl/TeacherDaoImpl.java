package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional

public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void addTeacher(Long courseId, Teacher teacher) {

        Course course = manager.find(Course.class, courseId);
        teacher.setCourse(course);
        manager.persist(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = manager.createQuery("From Teacher ", Teacher.class).getResultList();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher = manager.find(Teacher.class, id);
        return teacher;
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Teacher teacher1 = getTeacherById(id);
        teacher1.setTeacherName(teacher.getTeacherName());
        teacher1.setTeacherSurName(teacher.getTeacherSurName());
        manager.merge(teacher1);

    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        manager.remove(manager.contains(teacher)? teacher: manager.merge(teacher));
    }
}

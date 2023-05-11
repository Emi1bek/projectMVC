package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void addStudent(Long groupId, Student student) {
        Group group = manager.find(Group.class, groupId);
        student.setGroup(group);
        manager.persist(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = manager.createQuery("From Student ", Student.class).getResultList();
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = manager.find(Student.class, id);
        return student;
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = getStudentById(id);
        student1.setStudentName(student.getStudentName());
        student1.setStudentSurName(student.getStudentSurName());
        student1.setStudentAge(student.getStudentAge());
        student1.setStudentPhoneNumber(student.getStudentPhoneNumber());
        manager.merge(student1);
    }

    @Override
    public void deleteStudent(Student student) {
        manager.remove(manager.contains(student)? student: manager.merge(student));
    }
}

package be.vives.ti.service;

import be.vives.ti.dao.StudentDao;
import be.vives.ti.model.Student;

import java.util.List;

public class StudentService {

    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> findAllStudentsFromClass(String className) {
        return studentDao.findAllStudentsFromClass(className);
    }

    public Student get(Integer toStudentId) {
        return studentDao.get(toStudentId);
    }
}

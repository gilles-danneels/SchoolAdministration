package be.vives.ti.service;

import be.vives.ti.dao.TeacherDao;
import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;

import java.util.List;

public class TeacherService {

    private TeacherDao teacherDao;
    private StudentService studentService;
    private DummyEmailService dummyEmailService;

    public TeacherService() {
        this.teacherDao = new TeacherDao();
        this.studentService = new StudentService();
        this.dummyEmailService = new DummyEmailService();
    }

    public void sendMessage(Integer fromTeacherId, String message, Integer toStudentId) {

        Student student = studentService.get(toStudentId);
        Teacher teacher = teacherDao.get(fromTeacherId);

        this.dummyEmailService.sendEmail(teacher, message, student);

    }

    public void sendMessageToAllStudentsOfClass(Integer fromTeacherId, String className, String message) {
        Teacher teacher = teacherDao.get(fromTeacherId);

        List<Student> allStudentsFromClass = studentService.findAllStudentsFromClass(className);

        allStudentsFromClass.stream().forEach(s -> {
            this.dummyEmailService.sendEmail(teacher, message, s);
        });
    }
}

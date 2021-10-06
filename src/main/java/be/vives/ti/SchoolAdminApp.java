package be.vives.ti;

import be.vives.ti.dao.StudentDao;
import be.vives.ti.dao.TeacherDao;
import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.dao.util.SchoolDatabaseStub;
import be.vives.ti.model.MailTemplate;
import be.vives.ti.service.DummyEmailService;
import be.vives.ti.service.StudentService;
import be.vives.ti.service.TeacherService;
import be.vives.ti.service.TemplateService;

import javax.sql.DataSource;

public class SchoolAdminApp
{
    public static void main( String[] args ) {
        MailTemplate vivesMailTemplate = new MailTemplate("VIVES - Design your future",
                "VIVES - all rights reserved",
                "vives.jpg");

        DataSource ds = new MyOwnDataSource();
        SchoolDatabaseStub db = new SchoolDatabaseStub();
        TeacherDao teacherDao = new TeacherDao(ds, db);
        StudentDao studentDao = new StudentDao(ds, db);
        TemplateService templateService = new TemplateService(vivesMailTemplate);
        DummyEmailService dummyEmailService = new DummyEmailService(templateService);
        StudentService studentService = new StudentService(studentDao);

        TeacherService teacherService = new TeacherService(teacherDao, studentService, dummyEmailService);
        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3SD", "Afwerken tegen volgende les");
    }
}

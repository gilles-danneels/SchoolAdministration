package be.vives.ti;

import be.vives.ti.config.ApplicationConfiguration;
import be.vives.ti.dao.StudentDao;
import be.vives.ti.dao.TeacherDao;
import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.dao.util.SchoolDatabaseStub;
import be.vives.ti.model.MailTemplate;
import be.vives.ti.service.DummyEmailService;
import be.vives.ti.service.StudentService;
import be.vives.ti.service.TeacherService;
import be.vives.ti.service.TemplateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class SchoolAdminApp
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

       // get Bean by type
        TeacherService teacherService = context.getBean(TeacherService.class);

        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3SD", "Afwerken tegen volgende les");
    }
}

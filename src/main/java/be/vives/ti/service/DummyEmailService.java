package be.vives.ti.service;

import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public class DummyEmailService {

    private TemplateService templateService;

    public DummyEmailService(TemplateService templateService) {
        this.templateService = templateService;
    }

    public void sendEmail(Teacher teacher, String message, Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(templateService.getHeader());
        sb.append("\n");
        sb.append("Send mail");
        sb.append("\n");
        sb.append("From: " +teacher.getFirstName() + " " + teacher.getLastName());
        sb.append("\n");
        sb.append("To: " + student.getFirstName() + " " + student.getLastName());
        sb.append("\n");
        sb.append("Message: " + message);
        sb.append("\n");
        sb.append(templateService.getFooter());
        sb.append("\n");
        String result = sb.toString();
        System.out.println(result);
    }
}

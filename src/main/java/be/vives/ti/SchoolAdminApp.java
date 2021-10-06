package be.vives.ti;

import be.vives.ti.service.TeacherService;

public class SchoolAdminApp
{
    public static void main( String[] args ) {
        TeacherService teacherService = new TeacherService();
        teacherService.sendMessage(1, "Waarom was je afwezig?", 10);
        teacherService.sendMessageToAllStudentsOfClass(1, "3SD", "Afwerken tegen volgende les");
    }
}

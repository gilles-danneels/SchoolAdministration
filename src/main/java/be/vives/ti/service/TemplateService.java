package be.vives.ti.service;

import be.vives.ti.model.MailTemplate;

import java.time.LocalDate;

public class TemplateService {

    private MailTemplate mailTemplate;

    public TemplateService(MailTemplate mailTemplate) {
        this.mailTemplate = mailTemplate;
    }

    private String getSeparator(){
        return "---------------------------------";
    }

    public String getHeader(){
        return getSeparator()+"\n" + mailTemplate.getHeader() + "\n"+getSeparator() + "\n" + mailTemplate.getLogo() + "\n";
    }

    public String getFooter(){
        return "\n"+getSeparator()+"\n©" + mailTemplate.getFooter() + " " + LocalDate.now().getYear() + "\n"+getSeparator();
    }


}

package be.vives.ti.model;

public class MailTemplate {

    private String header;
    private String footer;
    private String logo;

    public MailTemplate(String header, String footer, String logo) {
        this.header = header;
        this.footer = footer;
        this.logo = logo;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String getLogo() {
        return logo;
    }
}

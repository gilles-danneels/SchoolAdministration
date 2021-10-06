package be.vives.ti.model;

public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private String className;

    public Student(Integer id, String firstName, String lastName, String className) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }
}

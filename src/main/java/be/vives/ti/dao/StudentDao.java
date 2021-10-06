package be.vives.ti.dao;

import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.dao.util.SchoolDatabaseStub;
import be.vives.ti.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDao {

    private DataSource ds;
    private SchoolDatabaseStub db;

    public StudentDao() {
        this.ds = new MyOwnDataSource();
        this.db = new SchoolDatabaseStub();
    }

    public Student get(int studentId) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
            return db.getStudents().stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
            return null;
        }
    }


    public List<Student> findAllStudentsFromClass(String className) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
            return db.getStudents().stream().filter(student -> student.getClassName().equals(className)).collect(Collectors.toList());
        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

package be.vives.ti.dao;

import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.dao.util.SchoolDatabaseStub;
import be.vives.ti.model.Teacher;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TeacherDao {
    private DataSource ds;
    private SchoolDatabaseStub db;

    public TeacherDao() {
        this.ds = new MyOwnDataSource();
        this.db = new SchoolDatabaseStub();
    }

    public Teacher get(int teacherId) {
        // dummy code
        try {
            Connection connection = ds.getConnection();
            return db.getTeachers().stream().filter(teacher -> teacher.getId() == teacherId).findFirst().orElse(null);

        } catch (SQLException e) {
            // not a great way to manage exceptions
            e.printStackTrace();
            return null;
        }
    }
}

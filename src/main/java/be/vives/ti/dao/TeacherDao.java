package be.vives.ti.dao;

import be.vives.ti.dao.util.MyOwnDataSource;
import be.vives.ti.dao.util.SchoolDatabaseStub;
import be.vives.ti.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class TeacherDao {
    private DataSource ds;
    private SchoolDatabaseStub db;

    public TeacherDao(DataSource ds, SchoolDatabaseStub db) {
        this.ds = ds;
        this.db = db;
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

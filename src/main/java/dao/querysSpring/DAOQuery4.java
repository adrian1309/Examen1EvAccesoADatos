package dao.querysSpring;

import dao.DBConnPool;
import model.Student;
import model.StudentsGrades;
import model.Subject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOQuery4 {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;
    private DBConnPool db = null;
    private final JdbcTemplate jtm = new JdbcTemplate(DBConnPool.getInstance().getPool());


    public DAOQuery4() {
        db = new DBConnPool();
    }

    public List<StudentsGrades> getNamesStudentSubjectMaxAttempt() {

        List<StudentsGrades> list = jtm.query(Constants.SELECT_NAMES_SUBJECT_AND_STUDENT_MAX_ATTEMPT,
                new Students_Grades_Names_MaxAttempt());

        return list;
    }

    public static final class Students_Grades_Names_MaxAttempt implements RowMapper<StudentsGrades> {
        @Override
        public StudentsGrades mapRow(ResultSet rs, int rowNum) throws SQLException {
            return StudentsGrades.builder().
                    name_student(rs.getString("name_student")).
                    name_subject(rs.getString("name_subject")).
                    attempt(rs.getInt("attempt")).
                    build();
        }
    }
}

package dao.querysSpring;

import dao.DBConnPool;
import model.StudentsGrades;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAOQuery5 {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;
    private DBConnPool db=null;
    private final JdbcTemplate jtm = new JdbcTemplate(DBConnPool.getInstance().getPool());

    public List<StudentsGrades> getAllMaxAttemptTeacherGringo() {
        List<StudentsGrades> list = jtm.query(Constants.SELECT_QUERY5,
                BeanPropertyRowMapper.newInstance(StudentsGrades.class));

        return list;
    }

    public void updateGrades (int id) {
            jtm.update(Constants.UPDATE_GRADES,
                    id);
    }
}

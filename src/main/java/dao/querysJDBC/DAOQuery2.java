package dao.querysJDBC;

import dao.DBConnPool;
import model.StudentsGrades;
import utils.Constants;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOQuery2 {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;
    private DBConnPool db=null;

    public DAOQuery2(){
        db = new DBConnPool();
    }


    public int getMaxAttempt(int idStudent, int idSubject){
        int attempt = 0;
        StudentsGrades studentGrades = new StudentsGrades();
        try {
            con = db.getConnection();
            stmt = con.prepareStatement(Constants.SELECT_STUDENTS_GRADES_WHERE_SUBJECT_WITH_MAX_ATTEMPT);
            stmt.setInt(1, idStudent);
            stmt.setInt(2, idSubject);
            stmt.setInt(3, idStudent);
            stmt.setInt(4, idSubject);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                studentGrades.setId(resultSet.getInt("id"));
                studentGrades.setId_student(resultSet.getInt("id_student"));
                studentGrades.setId_subject(resultSet.getInt("id_subject"));
                studentGrades.setGrade(resultSet.getDouble("grade"));
                studentGrades.setAttempt(resultSet.getInt("attempt"));
                attempt = studentGrades.getAttempt();
            }

        } catch (Exception ex) {
            Logger.getLogger(DAOQuery2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.releaseResources(stmt, resultSet);
            DBConnPool.closeConnection(con);
        }
        return attempt;
    }



    public void addGrades(StudentsGrades studentGrades){
        try {
            con = db.getConnection();
            stmt = con.prepareStatement(Constants.INSERT_GRADES, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, studentGrades.getId_student());
            stmt.setInt(2, studentGrades.getId_subject());
            stmt.setDouble(3, studentGrades.getGrade());
            stmt.setInt(4, studentGrades.getAttempt());
            stmt.executeUpdate();
            resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()){
                studentGrades.setId(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.closeConnection(con);
        }
    }
}

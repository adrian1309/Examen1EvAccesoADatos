package dao.querysJDBC;

import dao.DBConnPool;
import model.Student;
import model.Subject;
import model.Teacher;
import utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOQuery1 {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;
    private DBConnPool db=null;

    public DAOQuery1(){
        db = new DBConnPool();
    }

    public List<String> getNamesSubjectAndTeacher(int idStudent){
        List<String> listString = new ArrayList<>();
        try {
            con = db.getConnection();
            stmt = con.prepareStatement(Constants.SELECT_NAMES_FROM_SUBJECTS_AND_TEACHERS);
            stmt.setInt(1, idStudent);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                String subjectName = resultSet.getString(1);
                String teacherName = resultSet.getString(2);
                String result = "Subject: "+subjectName+" Teacher: "+teacherName;
                listString.add(result);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOQuery1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.releaseResources(stmt, resultSet);
            db.closeConnection(con);
        }
        return listString;
    }
}

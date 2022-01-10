package dao.querysJDBC;

import config.ConfigProperties;

import dao.DBConnPool;
import javafx.scene.control.Alert;
import model.Student;
import model.StudentsGrades;
import model.StudentsXML;
import utils.Constants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOQuery3 {
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;
    private DBConnPool db=null;

    public DAOQuery3(){
        db = new DBConnPool();
    }

    public boolean deleteStudent (int id){
        boolean studentDelete;
        try {
            studentDelete = true;
            con = db.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(Constants.DELETE_STUDENTSGRADES);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt = con.prepareStatement(Constants.DELETE_STUDENT);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException throwables) {
            studentDelete = false;
            if(con!=null){
                try {
                    con.rollback();
                }catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        }catch (Exception e){
            studentDelete = false;
            e.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return studentDelete;
    }

    public Student getStudentById(int id){
        Student student = null;
        try{
            con = db.getConnection();
            stmt = con.prepareStatement(Constants.GET_STUDENT_BY_ID);
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setStudentsGrades((List<StudentsGrades>) resultSet.getArray("studentsGrades"));

            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            db.closeConnection(con);
        }
        return student;
    }

    public void studentMarshalling (Student student){
        try {
            StudentsXML studentXML = new StudentsXML();
            studentXML.addStudent(student);

            JAXBContext context = JAXBContext.newInstance(StudentsXML.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Path file = Paths.get((ConfigProperties.getInstance().getProperty("StudentXML")));
            marshaller.marshal(studentXML, Files.newOutputStream(file));
        }catch (JAXBException | IOException e) {
            Logger.getLogger(ConfigProperties.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

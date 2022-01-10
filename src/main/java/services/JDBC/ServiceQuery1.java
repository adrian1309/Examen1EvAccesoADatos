package services.JDBC;

import dao.querysJDBC.DAOQuery1;
import model.Student;
import model.Subject;
import model.Teacher;

import java.util.List;

public class ServiceQuery1 {

    public List<String> getNamesSubjectAndTeacher(int id){
        DAOQuery1 dao = new DAOQuery1();
        return dao.getNamesSubjectAndTeacher(id);
    }
}

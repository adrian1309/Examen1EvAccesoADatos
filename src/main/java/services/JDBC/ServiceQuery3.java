package services.JDBC;

import dao.querysJDBC.DAOQuery3;
import model.Student;

public class ServiceQuery3 {

    public boolean deleteStudent (int id){
        DAOQuery3 dao = new DAOQuery3();
        return dao.deleteStudent(id);
    }

    public Student getStudentById(int id){
        DAOQuery3 dao = new DAOQuery3();
        return dao.getStudentById(id);
    }
    public void studentMarshalling (Student student){
        DAOQuery3 dao = new DAOQuery3();
        dao.studentMarshalling(student);
    }
}

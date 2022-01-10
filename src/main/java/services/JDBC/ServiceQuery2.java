package services.JDBC;

import dao.querysJDBC.DAOQuery2;
import model.StudentsGrades;

public class ServiceQuery2 {

    public int getMaxAttempt(int idStudent, int idSubject){
        DAOQuery2 dao = new DAOQuery2();
        return dao.getMaxAttempt(idStudent, idSubject);
    }

    public void addGrade(StudentsGrades studentsGrades){
        DAOQuery2 dao = new DAOQuery2();
        dao.addGrades(studentsGrades);
    }
}

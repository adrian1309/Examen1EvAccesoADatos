package services.Spring;

import dao.querysSpring.DAOQuery4;
import model.StudentsGrades;

import java.util.List;

public class ServiceQuery4 {


    public List<StudentsGrades> getNamesStudentSubjectMaxAttempt(){
        DAOQuery4 dao = new DAOQuery4();
        return dao.getNamesStudentSubjectMaxAttempt();
    }
}

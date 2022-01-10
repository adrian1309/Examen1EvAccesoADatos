package services.Spring;

import dao.querysSpring.DAOQuery5;
import model.StudentsGrades;

import java.util.List;

public class ServiceQuery5 {

    public List<StudentsGrades> getAllMaxAttemptTeacherGringo(){
        DAOQuery5 dao = new DAOQuery5();
        return dao.getAllMaxAttemptTeacherGringo();
    }

    public void updateGrades (int id){
        DAOQuery5 dao = new DAOQuery5();
        dao.updateGrades(id);
    }
}

package main;

import javafx.scene.control.Alert;
import model.StudentsGrades;
import services.JDBC.ServiceQuery2;

import java.util.Scanner;

public class Main2ModeloExamen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce id of student: ");
        int idStudent = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce id of subject: ");
        int idSubject = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce the grade: ");
        double grade = Double.parseDouble(sc.nextLine());

        ServiceQuery2 serviceQuery2 = new ServiceQuery2();

        int attempt = serviceQuery2.getMaxAttempt(idStudent, idSubject);

        StudentsGrades studentGrade = new StudentsGrades();
        studentGrade.setId(-1);
        studentGrade.setId_student(idStudent);
        studentGrade.setId_subject(idSubject);
        studentGrade.setGrade(grade);
        if (attempt == 4){
            System.err.println("ERROR. You cant add grades because he used all his attempts");
        }else if (attempt == 3){
            studentGrade.setAttempt(attempt+1);
            serviceQuery2.addGrade(studentGrade);
            System.out.println("WARNING. Last attempt. Grade added");
        }else{
            studentGrade.setAttempt(attempt+1);
            serviceQuery2.addGrade(studentGrade);
            System.out.println("NICE! Grade added");
        }
    }

}

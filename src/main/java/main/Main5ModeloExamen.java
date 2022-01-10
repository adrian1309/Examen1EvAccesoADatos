package main;

import model.StudentsGrades;
import services.Spring.ServiceQuery5;

import java.util.List;
import java.util.Scanner;

public class Main5ModeloExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceQuery5 service = new ServiceQuery5();

        List<StudentsGrades> studentGradesList =  service.getAllMaxAttemptTeacherGringo();

        studentGradesList.forEach(System.out::println);

        for (StudentsGrades student : studentGradesList){
            service.updateGrades(student.getId());
            System.out.println("Grade update");
        }



    }
}

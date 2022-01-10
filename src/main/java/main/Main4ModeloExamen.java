package main;

import model.StudentsGrades;
import services.Spring.ServiceQuery4;

import java.util.List;
import java.util.Scanner;

public class Main4ModeloExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceQuery4 service = new ServiceQuery4();

        System.out.println("The students with the subject that have failed in their last attempt are: ");

        List<StudentsGrades> list = service.getNamesStudentSubjectMaxAttempt();

        list.forEach(System.out::println);

    }
}

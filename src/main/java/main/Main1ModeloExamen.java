package main;

import services.JDBC.ServiceQuery1;

import java.util.List;
import java.util.Scanner;

public class Main1ModeloExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce id of student: ");
        int idStudent = Integer.parseInt(sc.nextLine());

        ServiceQuery1 serviceQuery1 = new ServiceQuery1();
        List<String> result = serviceQuery1.getNamesSubjectAndTeacher(idStudent);
        result.forEach(System.out::println);

    }
}

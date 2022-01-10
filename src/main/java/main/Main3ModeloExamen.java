package main;

import javafx.scene.control.Alert;
import model.Student;
import services.JDBC.ServiceQuery3;

import java.util.Scanner;

public class Main3ModeloExamen {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServiceQuery3 service = new ServiceQuery3();

        System.out.println("Choose the Id of the student you want to delete: ");
        int idStudent = Integer.parseInt(sc.nextLine());

        if(service.deleteStudent(idStudent)){
            System.out.println("Student delete");
            try{
                Student student = service.getStudentById(idStudent);
                service.studentMarshalling(student);
                System.out.println("Marshall realizado con exito");
            }catch (Exception e){
                System.out.println("ERROR AL HACER EL MARSHALL");
                e.printStackTrace();
            }
        }else {
            System.err.println("Student not delete");
        }
    }
}

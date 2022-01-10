package fx.controllers;

import main.Main2;

public class FXMLQuery2Controller {

    /*2.(1 Pts.)Add grades of a subject to a student in a certain call:
    If the student already has 4 calls, or if the student has a grade greater
    that a 5 in the last call, the grade will not be added.

    Agregue calificaciones de una materia a un estudiante en una determinada convocatoria:
     Si el alumno ya tiene 4 convocatorias, o si el alumno tiene una nota mayor
     que un 5 en la última convocatoria, no se sumará la nota.
     "insert into students_grades where attempt = ?"
     */


    private Main2 main = new Main2();

    public void setPrincipal(Main2 main2) {
        main = main2;
    }
}

package fx.controllers;

import main.Main4;

public class FXMLQuery4Controller {

    /*4.(1.5 Pts.)Select the students that have failed in any subject,
    considering only the last calls, indicating the name of the student,
    the name of the subject failed and if they have reached the maximum
    number of calls.
    4.(1.5 Pts.) Seleccione los estudiantes que han suspendido en cualquier asignatura,
     considerando solo las últimas llamadas, indicando el nombre del alumno,
     el nombre de la asignatura falló y si han alcanzado el máximo
     número de llamadas.*/

    /*select * from students_grades where id_student = :id_student and id_subject = :id_subject and attempt in (select max(attempt) from students_grades)*/

    private Main4 main = new Main4();

    public void setPrincipal(Main4 main4) {
        main = main4;
    }
}

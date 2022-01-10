package utils;

public class Constants {
    //QUERY 1
    public static final String SELECT_NAMES_FROM_SUBJECTS_AND_TEACHERS = "SELECT DISTINCT sub.name, tch.name FROM subjects sub " +
                                                                        "INNER JOIN teachers tch ON sub.id_teacher = tch.id " +
                                                                        "INNER JOIN students_grades sg ON sub.id = sg.id_subject " +
                                                                        "WHERE sg.id_student = ?";

    //QUERY 2
    public static final String SELECT_STUDENTS_GRADES_WHERE_SUBJECT_WITH_MAX_ATTEMPT = "select * from students_grades where id_student = ? and id_subject = ? and attempt in (select max(attempt) from students_grades where id_student = ? and id_subject = ?)";
    public static final String INSERT_GRADES = "insert into students_grades (id_student, id_subject, grade, attempt) values (?,?,?,?)";

    //QUERY 3
    public static final String DELETE_STUDENTSGRADES = "DELETE  FROM students_grades WHERE id_student = ?";
    public static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    public static final String GET_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";

    // QUERY 4
    public static final String SELECT_NAMES_SUBJECT_AND_STUDENT_MAX_ATTEMPT = "select st.name as name_student, sb.name as name_subject, attempt from students_grades sg " +
            "inner join subjects sb on sg.id_subject = sb.id " +
            "inner join students st on sg.id_student = st.id " +
            "where grade < 3 " +
            "and attempt = (select max(attempt) from students_grades sg2 " +
            "where sg.id_subject = sg2.id_subject " +
            "and sg.id_student = sg2.id_student " +
            "group by id_student, id_subject)";

    //QUERY 5

    public static final String SELECT_QUERY5 = "select sg.id as id, grade from students_grades sg " +
            "inner join subjects s on sg.id_subject = s.id " +
            "inner join teachers t on s.id_teacher = t.id " +
            "where attempt = (select max(attempt) from students_grades sg2 " +
            "where sg.id_subject = sg2.id_subject " +
            "and sg.id_student = sg2.id_student " +
            "group by id_student, id_subject) " +
            "and t.name = 'gringo'";

    public static final String UPDATE_GRADES = "update students_grades set grade = grade + 0.5 where id = ?";
}

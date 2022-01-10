package model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentsGrades {

    private int id;
    private int id_student;
    private int id_subject;
    private double grade;
    private int attempt;

    private String name_student ;
    private String name_subject;

    @Override
    public String toString() {
        return "StudentsGrades{" +
                "id=" + id +
                ", id_student=" + id_student +
                ", id_subject=" + id_subject +
                ", grade=" + grade +
                ", name_student = "+ name_student +
                ", name_subject = "+ name_subject +
                ", attempt=" + attempt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsGrades that = (StudentsGrades) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

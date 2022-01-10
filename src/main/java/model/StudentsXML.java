package model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentsXML {

    private List<Student> student = null;

    public StudentsXML() {
        this.student = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        this.student.add(student);
    }
}

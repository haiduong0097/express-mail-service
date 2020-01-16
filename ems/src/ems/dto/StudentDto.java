package ems.dto;

import java.util.List;

import javax.inject.Named;

@Named
public class StudentDto {

    private Integer studentId;
    private String name;

    private List<StudentDto> studentList;

    /**
     * @return the studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the studentList
     */
    public List<StudentDto> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List<StudentDto> studentList) {
        this.studentList = studentList;
    }

}

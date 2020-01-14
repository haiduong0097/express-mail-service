package ems.managerBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ems.dto.StudentDto;
import ems.service.StudentService;
import ems.service.StudentServiceImpl;

@Named
@ManagedBean
@SessionScoped
public class StudentBean {

    @Inject
    private StudentDto studentDto;

    private StudentService studentService;

    public StudentBean() {
        studentService = new StudentServiceImpl();
    }

    @PostConstruct
    public void init() {
        if (studentDto == null) {
            studentDto = new StudentDto();
            studentDto.setName("duong");
        }
    }

    public String logicClick() {
        System.out.println(studentDto.getName());
        studentService.insertNewStudent(studentDto);
        return "index";
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

}

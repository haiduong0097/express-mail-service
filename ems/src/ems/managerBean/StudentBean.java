package ems.managerBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

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

    public String searchClick() {
        List<StudentDto> studentList = studentService.searchAllStudent();
        studentDto.setStudentList(studentList);
        return "index";
    }

    public void onRowEdit(RowEditEvent event) {
        StudentDto selectesRow = (StudentDto) event.getObject();
        int result = studentService.updateStudent(selectesRow);
        if (result == 1) {
            FacesMessage msg = new FacesMessage("Edited Success", selectesRow.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Edited Fail", selectesRow.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        StudentDto selectesRow = (StudentDto) event.getObject();
        FacesMessage msg = new FacesMessage("Edit Cancelled", selectesRow.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

}

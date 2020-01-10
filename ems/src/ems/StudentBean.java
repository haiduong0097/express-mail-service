package ems;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ManagedBean
@ReferencedBean
public class StudentBean {

	@Inject
	private StudentDto studentDto;

	@PostConstruct
	public void init() {
		studentDto = new StudentDto();
		studentDto.setName("duong");
	}

	public String logicClick() {
		studentDto.setName("thay doi ket qua");
		return "index";
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

}

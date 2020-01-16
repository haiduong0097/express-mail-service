package ems.service;

import java.util.List;

import ems.dto.StudentDto;

public interface StudentService {

    public void insertNewStudent(StudentDto studentDto);

    public List<StudentDto> searchAllStudent();

    public int updateStudent(StudentDto studentDto);

}

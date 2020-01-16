package ems.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ems.dao.StudentDao;
import ems.dao.StudentDaoImpl;
import ems.dto.StudentDto;
import ems.genEntity.Student;

public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public void insertNewStudent(StudentDto studentDto) {
        Student studentEntity = new Student();
        studentEntity.setName(studentDto.getName());
        studentDao.insert(studentEntity);
        System.out.println("Done!!!");
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<StudentDto> searchAllStudent() {
        List<StudentDto> studentDtoList = new ArrayList();
        List<Student> studentList = studentDao.selectAllStudent();
        if (studentList != null && studentList.size() > 0) {
            for (Student student : studentList) {
                StudentDto studentDto = new StudentDto();
                studentDto.setStudentId(student.getStudentId());
                studentDto.setName(student.getName());
                studentDtoList.add(studentDto);
            }
        }

        return studentDtoList;

    }

    @Override
    public int updateStudent(StudentDto studentDto) {
        Student studentEntity = new Student();
        studentEntity.setName(studentDto.getName());
        studentEntity.setStudentId(studentDto.getStudentId());
        int result = studentDao.update(studentEntity);
        return result;

    }

}

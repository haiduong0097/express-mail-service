package ems.service;

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

    }

}

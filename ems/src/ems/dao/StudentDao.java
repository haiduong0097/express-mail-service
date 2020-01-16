package ems.dao;

import java.util.List;

import ems.genEntity.Student;

public interface StudentDao {
    public void insert(Student studentEntity);

    public List<Student> selectAllStudent();

    public int update(Student studentEntity);
}

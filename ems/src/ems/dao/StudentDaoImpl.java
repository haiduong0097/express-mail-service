package ems.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ems.genEntity.Student;

public class StudentDaoImpl implements StudentDao {

    SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.openSession();

    @Override
    public void insert(Student studentEntity) {
        try {
            session.beginTransaction();
            session.save(studentEntity);
            session.getTransaction().commit();
            System.out.println("insert success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Student selectById(int id) {
        Student studentEntity = session.load(Student.class, id);
        System.out.println(studentEntity);
        return studentEntity;
    }

    public void updateName(int id, String name) {
        String sql = "UPDATE Customer u SET u.name = :newName WHERE u.id = :id";
        session.createQuery(sql).setString("newName", name).setInteger("id", id).executeUpdate();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Student> selectAllStudent() {
        try {
            session.beginTransaction();

            StringBuilder sql = new StringBuilder();
            sql.append("Select s from ").append(Student.class.getName()).append(" s ")
                    .append(" order by s.name, s.studentId ");

            Query query = session.createQuery(sql.toString());

            List<Student> studentList = query.list();
            if (studentList == null) {
                return new ArrayList();
            }

            System.out.println("search success!");
            return studentList;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return new ArrayList();
        }

    }

    @Override
    public int update(Student studentEntity) {
        try {
            session.beginTransaction();
            Student temptStudent = session.load(Student.class, studentEntity.getStudentId());
            if (temptStudent == null) {
                return 0;
            }
            temptStudent.setName(studentEntity.getName());
            session.update(temptStudent);
            session.getTransaction().commit();
            System.out.println("update success!");
            return 1;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }

    }

}

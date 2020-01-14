package ems.dao;

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

}

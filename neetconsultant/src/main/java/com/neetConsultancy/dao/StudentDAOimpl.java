package com.neetConsultancy.dao;

import com.neetConsultancy.model.Franchise;
import com.neetConsultancy.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOimpl implements StudentDAO{
    @Autowired
    SessionFactory sessionFactory;
    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    public Student getStudent(int studentId) {
        return (Student) sessionFactory.getCurrentSession().get(Student.class,studentId);

    }

    public Student updateStudent(Student student) {
          sessionFactory.getCurrentSession().update(student);
        return student;
    }

    public void deleteStudent(int studentId) {
        Student student=(Student) sessionFactory.getCurrentSession().load(Student.class,studentId);
        this.sessionFactory.getCurrentSession().delete(student);
    }

    public List<Student> filterStudents(String studentName, Franchise franchise) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Student.class)
                .add(Restrictions.and(Restrictions.eq("franchise",franchise),Restrictions.like("firstName","%"+studentName+"%").ignoreCase()));
        return criteria.list();
    }

    
    public List<Student> getAllStudents() {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }
}

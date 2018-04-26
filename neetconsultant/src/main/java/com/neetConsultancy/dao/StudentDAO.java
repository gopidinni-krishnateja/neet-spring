package com.neetConsultancy.dao;


import com.neetConsultancy.model.Franchise;
import com.neetConsultancy.model.Student;

import java.util.List;

public interface StudentDAO {
    public void addStudent(Student student);
    public Student getStudent(int studentId);
    public Student updateStudent(Student student);
    public void  deleteStudent(int studentId);
    public List<Student> filterStudents(String name, Franchise franchise);
    public List<Student> getAllStudents();
}

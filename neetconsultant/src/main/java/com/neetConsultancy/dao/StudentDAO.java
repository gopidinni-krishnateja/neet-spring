package com.neetConsultancy.dao;


import com.neetConsultancy.model.Student;

import java.util.List;

public interface StudentDAO {
    public void addStudent(Student student);
    public Student getStudent(int studentId);
    public Student updateStudent(Student student);
    public void  deleteStudent(int studentId);
    public List<Student> filterStudents(String name, int franchiseId);
    public List<Student> getAllStudents();
}

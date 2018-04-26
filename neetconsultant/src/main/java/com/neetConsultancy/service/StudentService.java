package com.neetConsultancy.service;

import com.neetConsultancy.model.Franchise;
import com.neetConsultancy.model.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
    public Student getStudent(int id);
    public Student updateStudent(Student student);
    public void  deleteStudent(int id);
    public List<Student> filterStudents(String name, Franchise franchise);
    public List<Student> getAllStudents();
}

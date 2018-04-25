package com.neetConsultancy.service;

import com.neetConsultancy.dao.StudentDAO;
import com.neetConsultancy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDAO studentDAO;
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public List<Student> filterStudents(String name, int franchiseId) {
        return studentDAO.filterStudents(name,franchiseId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}

package com.neetConsultancy.controller;

import com.neetConsultancy.model.Student;
import com.neetConsultancy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/index")
    public ModelAndView homePage()
    {
        // System.out.println("hospitals---> "+hospitals.get(0).getDoctors().get(0).getFirstName());
        return new ModelAndView("index");
    }

    //Save and Update the Student
    @RequestMapping(value="/student/add",method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        HttpHeaders headers = new HttpHeaders();
        if (student.getId()==0) {
            studentService.addStudent(student);
            return new ResponseEntity<Student>(headers, HttpStatus.CREATED);
        } else {
            studentService.updateStudent(student);
            return new ResponseEntity<Student>(headers, HttpStatus.CREATED);
        }
    }

    //Get one student Record
    @RequestMapping(value = "student/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id){
        Student student = studentService.getStudent(id);
        if (student == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    //Delete one student Record
    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Student with id " + id);

        Student student = studentService.getStudent(id);
        if (student == null) {
            System.out.println("Unable to delete. Student with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    // Get All Student Records
    @RequestMapping(value = "students",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

}

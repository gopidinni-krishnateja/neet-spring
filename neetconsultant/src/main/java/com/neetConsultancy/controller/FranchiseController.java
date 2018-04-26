package com.neetConsultancy.controller;

import com.neetConsultancy.model.Franchise;
import com.neetConsultancy.model.Student;
import com.neetConsultancy.service.FranchiseService;
import com.neetConsultancy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FranchiseController {
    @Autowired
    FranchiseService franchiseService;
    @Autowired
    StudentService studentService;

    // Add and Update Franchise Record
    @RequestMapping(value = "/franchise/add",method = RequestMethod.POST)
    public ResponseEntity<Franchise>  addFranchise(@RequestBody Franchise franchise){
        HttpHeaders headers = new HttpHeaders();
        if (franchise.getId()==0) {
            franchiseService.addFranchise(franchise);
            return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
        } else {
            franchiseService.updateFranchise(franchise);
            return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
        }
    }

    // Get Franchise Record
    @RequestMapping(value = "/franchise/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Franchise> getFranchise(@PathVariable("id") int id){
        Franchise franchise=franchiseService.getFranchise(id);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Franchise>(franchise, HttpStatus.OK);
    }

    // Enroll Student to Franchise
    @RequestMapping(value = "/franchise/{id}/{studentId}",method = RequestMethod.PUT)
    public ResponseEntity<Franchise> approveStudent(@PathVariable("id") int id,@PathVariable("studentId") int studentId){
        HttpHeaders headers = new HttpHeaders();
        Franchise franchise=franchiseService.getFranchise(id);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        Student student=studentService.getStudent(studentId);
        List<Student> assignedStudents = franchiseService.getFranchise(id).getStudents();
        assignedStudents.add(student);
        franchise.setStudents(assignedStudents);
        student.setFranchise(franchise);
        franchiseService.updateFranchise(franchise);
        return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
    }

    //Delete one franchise Record
    @RequestMapping(value = "franchise/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Franchise> deleteUser(@PathVariable("id") int id) {
        Franchise franchise = franchiseService.getFranchise(id);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        franchiseService.deleteFranchise(id);
        return new ResponseEntity<Franchise>(HttpStatus.OK);
    }

    //Get all Franchises
    @RequestMapping(value = "franchises",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Franchise>> getAllFranchises(){
        List<Franchise> franchises=franchiseService.getAllFranchises();
        return ResponseEntity.ok().body(franchises);
    }
}

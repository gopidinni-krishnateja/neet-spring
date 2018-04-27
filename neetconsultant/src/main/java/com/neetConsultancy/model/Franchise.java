package com.neetConsultancy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neetConsultancy.enums.Gender;
import com.neetConsultancy.enums.Role;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "franchise")
public class Franchise implements Serializable{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "franchise_sequence")
    @SequenceGenerator(name="franchise_sequence", sequenceName = "franchise_seq", allocationSize = 1)
    private int Id;

    @NotEmpty
    @Column(name="franchiseName")
    private String franchiseName;

    @NotEmpty
    @Column(name="registrationNumber")
    private String registrationNumber;

    @NotEmpty
    @Column(name="firstName")
    private String firstName;

    @NotEmpty
    @Column(name = "lastName")
    private String lastName;

    @NotEmpty
    @Column(name="middleName")
    private String middleName;

    @NotEmpty
    @Column(name="pan")
    private String pan;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;


    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @NotEmpty
    @Column(name="aadhaar")
    private String aadhaar;

    @Column(name="mobile")
    private int mobile;

    @Column(name="landline")
    private int landline;

    @NotEmpty
    @Column(name="email",unique = true)
    private String email;

    @NotEmpty
    @Column(name="password")
    private String password;

    @Column(name="status")
    private  boolean status;

    @NotEmpty
    @Column(name="state")
    private String state;

    @NotEmpty
    @Column(name="city")
    private String city;

    @NotEmpty
    @Column(name="zipCode")
    private String zipCode;

    @NotEmpty
    @Column(name="lane1")
    private String lane1;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getLandline() {
        return landline;
    }

    public void setLandline(int landline) {
        this.landline = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @NotEmpty
    @Column(name="lane2")
    private String lane2;

    @OneToMany(mappedBy = "franchise",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Student> students;



}

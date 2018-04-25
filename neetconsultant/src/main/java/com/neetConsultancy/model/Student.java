package com.neetConsultancy.model;

import com.neetConsultancy.enums.Gender;
import com.neetConsultancy.enums.Role;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name="student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    private int Id;

    @NotEmpty
    @Column(name="qualification")
    private String qualification;

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

    @NotEmpty
    @Column(name="lane2")
    private String lane2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="franchise_id")
    private Franchise franchise;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}

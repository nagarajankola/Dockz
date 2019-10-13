package com.inferno.dockz;

public class Candidate {


    private String name;
    private String email;
    private String age;
    private String location;
    private String qualification;
    private String gpa;
    private String specialization;


    public Candidate(){

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getQualification() {
        return qualification;
    }

    public String getGpa() {
        return gpa;
    }

    public int getGender() {
        return gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    private int gender;


    public Candidate(String name, String email, String age, String location, String qualification, String gpa, int gender, String specialization) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.location = location;
        this.qualification = qualification;
        this.gpa = gpa;
        this.gender = gender;
        this.specialization = specialization;
    }







}
package com.inferno.dockz;

public class Job {
    private String position;
    private String org;
    private String description;
    private String sal;
    private String loc;


    public Job(){

    }

    public String getSpecialization() {
        return specialization;
    }



    private String specialization;

    public String getPosition() {
        return position;
    }



    public String getOrg() {
        return org;
    }


    public String getDescription() {
        return description;
    }



    public String getSal() {
        return sal;
    }



    public String getLoc() {
        return loc;
    }



    public Job(String position, String org, String description, String sal, String loc,String specialization) {
        this.position = position;
        this.org = org;
        this.description = description;
        this.sal = sal;
        this.loc = loc;
        this.specialization = specialization;
    }
}

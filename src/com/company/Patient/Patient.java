package com.company.Patient;

public class Patient {

    private String first_name;
    private String last_name;
    private int age;
    private long id;
    private boolean MediHealthHealthinsured;


    public Patient(String first_name, String last_name, int age, long id , boolean MediHealthHealthinsured){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.id = id;
        this.MediHealthHealthinsured = MediHealthHealthinsured;

    }

    public void setFirstName(String first_name){
        this.first_name = first_name;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMediHealthHealthinsured(boolean MediHealthHealthinsurance){

        this.MediHealthHealthinsured = MediHealthHealthinsurance;
    }


    public String getFirstName(){
        return first_name;
    }

    public String getLastName(){
        return last_name;
    }

    public int getAge(){
        return age;
    }

    public long getId() {
        return id;
    }

    public boolean isMediHealthHealthinsured() {
        return MediHealthHealthinsured;
    }
}

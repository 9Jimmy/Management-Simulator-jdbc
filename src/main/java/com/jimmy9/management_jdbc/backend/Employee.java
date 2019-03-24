package com.jimmy9.management_jdbc.backend;

public class Employee {
    private int id;
    private String fname;
    private String sname;
    private String position;
    private int age;
    private float salary;

     Employee(){}

    public Employee(int id, String fname, String sname, String position, int age, float salary){
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String fname, String sname, String position, int age, float salary){
        this.fname = fname;
        this.sname = sname;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{id: " + id +
                ", fname: " + fname +
                ", sname: " + sname +
                ", position: " + position +
                ", age: " + age +
                ", salary: " + salary + "}\n";
    }

     void setFname(String fname) {
        this.fname = fname;
    }

     void setSname(String sname) {
        this.sname = sname;
    }

     void setPosition(String position) {
        this.position = position;
    }

     void setAge(int age) {
        this.age = age;
    }

     void setSalary(float salary) {
        this.salary = salary;
    }

     void setId(int id) {
        this.id = id;
    }
}
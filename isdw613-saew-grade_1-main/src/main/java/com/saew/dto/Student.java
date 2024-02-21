package com.saew.dto;

public class Student {

    private int id;
    private String name;
    private float GPA;
    private String email;

    public Student(int id, String name,String email,float GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.email = email;
    }

    // Métodos de acceso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



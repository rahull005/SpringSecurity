package com.Security.JWT.Model;

public class Student {
    private int id;
    private String name;
    private int rollNO;

    public Student(int id, String name, int rollNO) {
        this.id = id;
        this.name = name;
        this.rollNO = rollNO;
    }

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

    public int getRollNO() {
        return rollNO;
    }

    public void setRollNO(int rollNO) {
        this.rollNO = rollNO;
    }
}

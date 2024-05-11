package com.example.hotel;

public class EmployeeModel {

    private int emid;
    private String emname, emphone, emadd, empost, emsalary;

    public EmployeeModel(int emid, String emname, String emphone, String emadd, String empost, String emsalary) {
        this.emid = emid;
        this.emname = emname;
        this.emphone = emphone;
        this.emadd = emadd;
        this.empost = empost;
        this.emsalary = emsalary;
    }
    public EmployeeModel() {
    }

    public int getEmid() {
        return emid;
    }

    public void setEmid(int emid) {
        this.emid = emid;
    }

    public String getEmname() {
        return emname;
    }

    public void setEmname(String emname) {
        this.emname = emname;
    }

    public String getEmphone() {
        return emphone;
    }

    public void setEmphone(String emphone) {
        this.emphone = emphone;
    }

    public String getEmadd() {
        return emadd;
    }

    public void setEmadd(String emadd) {
        this.emadd = emadd;
    }

    public String getEmpost() {
        return empost;
    }

    public void setEmpost(String empost) {
        this.empost = empost;
    }

    public String getEmsalary() {
        return emsalary;
    }

    public void setEmsalary(String emsalary) {
        this.emsalary = emsalary;
    }
}

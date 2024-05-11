package com.example.hotel;

public class Model {

    private  int ide;
    private  String name, phone, add, city, postal, zender, mail, adhar;

    public Model(int id, String name, String phone,String add, String city,String postal,String zender,String mail,String adhar)
    {
        this.ide = id;
        this.name = name;
        this.phone = phone;
        this.add = add;
        this.city = city;
        this.postal = postal;
        this.zender = zender;
        this.mail = mail;
        this.adhar = adhar;
    }

    public Model()
    {

    }

    public int getId() {
        return ide;
    }

    public void setId(int id) {
        this.ide = id;
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getZender() {
        return zender;
    }

    public void setZender(String zender) {
        this.zender = zender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }
}

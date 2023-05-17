package com.example.quanlysinhvien;

public class student2 {
    private String id;
    private String name;
    private String phone;
    private String idclass;

    public student2() {
    }

    public student2(String id, String name, String phone, String idclass) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.idclass = idclass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
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

    public String getIdclass() {
        return idclass;
    }

    public void setIdclass(String idclass) {
        this.idclass = idclass;
    }
}

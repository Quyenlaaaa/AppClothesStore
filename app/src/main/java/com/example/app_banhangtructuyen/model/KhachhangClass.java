package com.example.app_banhangtructuyen.model;

public class KhachhangClass {
    String hoTen, phone_email, password, diaChi;

    public KhachhangClass() {
    }

    public KhachhangClass(String hoTen, String phone_email, String password, String diaChi) {
        this.hoTen = hoTen;
        this.phone_email = phone_email;
        this.password = password;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhone_email() {
        return phone_email;
    }

    public void setPhone_email(String phone_email) {
        this.phone_email = phone_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}


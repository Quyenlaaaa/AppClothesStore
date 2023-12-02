package com.example.app_banhangtructuyen.model;

public class Khachhang{
    private String hoTen;
    private String phone_email;
    private String password;
    private String diaChi;
    private  String gioitinh;
    private  String sodt;

    public Khachhang() {
    }

    public Khachhang(String hoTen, String phone_email, String password, String diaChi,String gioitinh,String sdt) {
        this.hoTen = hoTen;
        this.phone_email = phone_email;
        this.password = password;
        this.diaChi = diaChi;
        this.gioitinh=gioitinh;
        this.sodt=sdt;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
}

package com.example.app_banhangtructuyen.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int MaSP;
    private String TenSP;
    private int Dongia;
    private String Hinhanh;

    private  int MaDM;
    private String Mota;
    private int Soluong;

    public Product(){}
    public Product(int maSP, String tenSP, int dongia, String hinhanh, int maDM, String mota, int soluong) {
        MaSP = maSP;
        TenSP = tenSP;
        Dongia = dongia;
        Hinhanh = hinhanh;
        MaDM = maDM;
        Mota = mota;
        Soluong = soluong;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int dongia) {
        Dongia = dongia;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int maDM) {
        MaDM = maDM;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }
}

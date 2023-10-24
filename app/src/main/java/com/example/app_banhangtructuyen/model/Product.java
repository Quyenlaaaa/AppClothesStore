package com.example.app_banhangtructuyen.model;

public class Product {
    public int ID;
    public String Tensanpham;
    public Integer Dongia;
    public int Hinhanh;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public Integer getDongia() {
        return Dongia;
    }

    public void setDongia(Integer dongia) {
        Dongia = dongia;
    }

    public int getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getIDsanpham() {
        return IDsanpham;
    }

    public void setIDsanpham(int IDsanpham) {
        this.IDsanpham = IDsanpham;
    }

    public String Mota;
    public int IDsanpham;

    public Product(int ID, String tensanpham, Integer dongia, int hinhanh, String mota, int IDsanpham) {
        this.ID = ID;
        Tensanpham = tensanpham;
        Dongia = dongia;
        Hinhanh = hinhanh;
        Mota = mota;
        this.IDsanpham = IDsanpham;
    }
}

package com.example.xacnhan.Domain;

public class QuanAo {
    protected String ten;
    protected String gia;
    protected int flags;

    public QuanAo(String ten, String gia, int flags) {
        this.ten = ten;
        this.gia = gia;
        this.flags = flags;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}

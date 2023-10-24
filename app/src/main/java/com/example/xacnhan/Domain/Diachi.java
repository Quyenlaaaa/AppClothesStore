package com.example.xacnhan.Domain;

public class Diachi {
    private int img_icon1;
    private String name;
    private String address;
    private int img_icon2;

    public Diachi(int img_icon1, String name, String address, int img_icon2) {
        this.img_icon1 = img_icon1;
        this.name = name;
        this.address = address;
        this.img_icon2 = img_icon2;
    }

    public int getImg_icon1() {
        return img_icon1;
    }

    public void setImg_icon1(int img_icon1) {
        this.img_icon1 = img_icon1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImg_icon2() {
        return img_icon2;
    }

    public void setImg_icon2(int img_icon2) {
        this.img_icon2 = img_icon2;
    }
}

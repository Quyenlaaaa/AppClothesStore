package com.example.xacnhan.Domain;

import java.io.Serializable;

public class Xacnhan implements Serializable {
    private int icon;
    private String Titile;
    private String infouser;
    private String address;

    public Xacnhan(int icon, String titile, String infouser, String address) {
        this.icon = icon;
        Titile = titile;
        this.infouser = infouser;
        this.address = address;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitile() {
        return Titile;
    }

    public void setTitile(String titile) {
        Titile = titile;
    }

    public String getInfouser() {
        return infouser;
    }

    public void setInfouser(String infouser) {
        this.infouser = infouser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

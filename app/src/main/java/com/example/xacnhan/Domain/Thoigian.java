package com.example.xacnhan.Domain;

public class Thoigian {
    private int icon;
    private String Titile;
    private String time;

    public Thoigian(int icon, String titile, String time) {
        this.icon = icon;
        Titile = titile;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

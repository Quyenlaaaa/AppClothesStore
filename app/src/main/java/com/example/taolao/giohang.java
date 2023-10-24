package com.example.taolao;

import android.widget.Button;
import android.widget.CheckBox;

public class giohang {
    private CheckBox btncheckbox;
     private int hinhanh;
    private  String tensp;
    private int icon;
    private String gia;
    private Button tru;
    private String sl;
    private Button cong;

    public giohang(int hinhanh, String tensp, int icon, String gia, String sl) {
        this.hinhanh = hinhanh;
        this.tensp = tensp;
        this.icon = icon;
        this.gia = gia;
        this.sl = sl;
    }



    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }



    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
}

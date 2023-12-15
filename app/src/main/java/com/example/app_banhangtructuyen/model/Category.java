package com.example.app_banhangtructuyen.model;

public class Category {
    private int MaDM;
    private String TenDM;
    public Category() {}

    public Category(int maDm, String tenDM) {
        MaDM = maDm;
        TenDM = tenDM;
    }

    public int getMaDm() {
        return MaDM;
    }

    public void setMaDm(int maDM) {
        MaDM = maDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String tenDM) {
        TenDM = tenDM;
    }
}

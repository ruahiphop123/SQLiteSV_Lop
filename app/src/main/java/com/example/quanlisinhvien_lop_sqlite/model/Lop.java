package com.example.quanlisinhvien_lop_sqlite.model;

public class Lop {
    private String maLop;
    private String tenLop;
    private String gVCN;

    public Lop() {
    }

    public Lop(String maLop, String tenLop, String gVCN) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.gVCN = gVCN;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getgVCN() {
        return gVCN;
    }

    public void setgVCN(String gVCN) {
        this.gVCN = gVCN;
    }
}

package com.example.quanlisinhvien_lop_sqlite.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int sTT;
    private String maSV;
    private String tenSV;
    private String maLopNo;
    private double diemToan;
    private double diemTin;
    private double diemTA;
    private double diemTB;

    public SinhVien() {
    }

    public SinhVien(int sTT, String maSV, String tenSV, String maLopNo) {
        this.sTT = sTT;
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.maLopNo = maLopNo;
    }

    public SinhVien(int sTT, String maSV, String tenSV, String maLopNo, double diemToan, double diemTin, double diemTA) {
        this.sTT = sTT;
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.maLopNo = maLopNo;
        this.diemToan = diemToan;
        this.diemTin = diemTin;
        this.diemTA = diemTA;
    }

    public int getsTT() {
        return sTT;
    }

    public void setsTT(int sTT) {
        this.sTT = sTT;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getMaLopNo() {
        return maLopNo;
    }

    public void setMaLopNo(String  maLopNo) {
        this.maLopNo = maLopNo;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemTin() {
        return diemTin;
    }

    public void setDiemTin(double diemTin) {
        this.diemTin = diemTin;
    }

    public double getDiemTA() {
        return diemTA;
    }

    public void setDiemTA(double diemTA) {
        this.diemTA = diemTA;
    }

    public double getDiemTB() {
        return diemTB = (diemToan + diemTin + diemTA)/3;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }


    public SinhVien(int sTT, String maSV, String tenSV, String maLopNo, double diemToan, double diemTin, double diemTA, double diemTB) {
        this.sTT = sTT;
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.maLopNo = maLopNo;
        this.diemToan = diemToan;
        this.diemTin = diemTin;
        this.diemTA = diemTA;
        this.diemTB = diemTB;
    }
}

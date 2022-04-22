/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconnect;

/**
 *
 * @author minht
 */
public class Product {
    private int maSp;
    private String tenSp;
    private String xuatXu;
    private int soLuong;
    private int giaTien;

    public Product() {
    }

    public Product(int maSp, String tenSp, String xuatXu, int soLuong, int giaTien) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.xuatXu = xuatXu;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    
}

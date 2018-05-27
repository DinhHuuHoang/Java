/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author dinhh
 */
public class MatHang {
    private String MaHang;
    private String TenHang;
    private String MaChatLieu;
    private Float SoLuong;
    private Float DonGiaNhap;
    private Float DonGiaBan;
    private String Anh;
    private String GhiChu;
    public MatHang(String MaHang, String TenHang, String MaChatLieu, Float SoLuong, Float DonGiaNhap, Float DonGiaBan, String Anh, String GhiChu){
        this.Anh =  Anh;
        this.DonGiaBan = DonGiaBan;
        this.DonGiaNhap = DonGiaNhap;
        this.GhiChu = GhiChu;
        this.MaChatLieu = MaChatLieu;
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.TenHang = TenHang;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public Float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(Float DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public Float getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(Float DonGiaBan) {
        this.DonGiaBan = DonGiaBan;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
}

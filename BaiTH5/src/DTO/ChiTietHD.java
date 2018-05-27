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
public class ChiTietHD {
    private String MaHDBan;
    private String MaHang;
    private Float SoLuong;
    private Float DonGia;
    private Float GiamGia;
    private Float ThanhTien;
    public ChiTietHD(String MaHDBan, String MaHang, Float SoLuong, Float DonGia, Float GiamGia, Float ThanhTien){
        this.MaHDBan = MaHDBan;
        this.MaHang = MaHang;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public String getMaHDBan() {
        return MaHDBan;
    }

    public void setMaHDBan(String MaHDBan) {
        this.MaHDBan = MaHDBan;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public Float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public Float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(Float GiamGia) {
        this.GiamGia = GiamGia;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
}

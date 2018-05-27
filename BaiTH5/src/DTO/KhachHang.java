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
public class KhachHang {
    private String MaKhach;
    private String TenKhach;
    private String DiaChi;
    private String DienThoai;
    public KhachHang(String MaKhach, String TenKhach, String DiaChi, String DienThoai){
        this.MaKhach = MaKhach;
        this.TenKhach = TenKhach;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }

    public String getMaKhach() {
        return MaKhach;
    }

    public void setMaKhach(String MaKhach) {
        this.MaKhach = MaKhach;
    }

    public String getTenKhach() {
        return TenKhach;
    }

    public void setTenKhach(String TenKhach) {
        this.TenKhach = TenKhach;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }
    
}

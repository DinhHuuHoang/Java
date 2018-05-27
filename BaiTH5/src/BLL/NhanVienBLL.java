/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoadComboBox;
import DAL.NhanVienDAL;
import DTO.NhanVien;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinhh
 */
public class NhanVienBLL {
    NhanVienDAL nvDAL = new NhanVienDAL();
    public void LoadDsNV(JTable tb){
        Vector tbTieuDe = new Vector();
        Vector tbDong = new Vector();
        tbTieuDe.add("Mã Nhân Viên");
        tbTieuDe.add("Tên Nhân Viên");
        tbTieuDe.add("Giới Tính");
        tbTieuDe.add("Địa chỉ");
        tbTieuDe.add("Điện thoại");
        tbTieuDe.add("Ngày Sinh");
        for(DTO.NhanVien nv : nvDAL.LoadDsNV()){
            Vector v = new Vector();
            v.add(nv.getMaNhanVien());
            v.add(nv.getTenNhanVien());
            v.add(nv.getGioiTinh());
            v.add(nv.getDiaChi());
            v.add(nv.getDienThoai());
            v.add(nv.getNgaySinh());
            tbDong.add(v);
            tb.setModel(new DefaultTableModel(tbDong, tbTieuDe));
        }
    }
    public void LoadCbbNhanVien(JComboBox cbb){
        LoadComboBox lcb = new LoadComboBox();
        lcb.LoadComboBoxNhanVien(cbb);
    }
    public void Them(NhanVien nv){
        nvDAL.Them(nv);
    }
    
    public void Xoa(String ma){
        nvDAL.Xoa(ma);
    }
    
    public void Sua(NhanVien nv){
        nvDAL.Sua(nv);
    }
    
    public boolean getID(String manhap){
        return nvDAL.getID(manhap);
    }
    public Boolean ktraDienThoai(String dt){
        boolean kt = true;
        try {
            int a = Integer.parseInt(dt);
            kt = true;
        } catch (Exception e) {
            kt = false;
        }
        return kt;
    }
    public void TimNV(JTable tb, JComboBox cbb){
        Vector tbTieuDe = new Vector();
        Vector tbDong = new Vector();
        tbTieuDe.add("Mã nhân viên");
        tbTieuDe.add("Tên nhân viên");
        tbTieuDe.add("Giới Tính");
        tbTieuDe.add("Địa chỉ");
        tbTieuDe.add("Điện thoại");
        tbTieuDe.add("Ngày Sinh");
        for (NhanVien nv : nvDAL.TimNV(cbb)){
            Vector v = new Vector();
            v.add(nv.getMaNhanVien());
            v.add(nv.getTenNhanVien());
            v.add(nv.getGioiTinh());
            v.add(nv.getDiaChi());
            v.add(nv.getDienThoai());
            v.add(nv.getNgaySinh());
            tbDong.add(v);
            tb.setModel(new DefaultTableModel(tbDong, tbTieuDe));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangDAL;
import DAL.LoadComboBox;
import DTO.KhachHang;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinhh
 */
public class KhachHangBLL {
    KhachHangDAL khDal = new KhachHangDAL();
    public void LoadDsKH(JTable tb){
        Vector tbTieuDe = new Vector();
        Vector tbDong = new Vector();
        tbTieuDe.add("Mã khách hàng");
        tbTieuDe.add("Tên khách hàng");
        tbTieuDe.add("Địa chỉ");
        tbTieuDe.add("Điện thoại");
        for (KhachHang kh : khDal.LoadDsKH()){
            Vector v = new Vector();
            v.add(kh.getMaKhach());
            v.add(kh.getTenKhach());
            v.add(kh.getDiaChi());
            v.add(kh.getDienThoai());
            tbDong.add(v);
            tb.setModel(new DefaultTableModel(tbDong, tbTieuDe));
        }
    }
    public void Them(KhachHang kh){
        khDal.Them(kh);
    }
    
    public void Xoa(String ma){
        khDal.Xoa(ma);
    }
    
    public void Sua(KhachHang kh){
        khDal.Sua(kh);
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
    public Boolean getID(String manhap){
        return khDal.getID(manhap);
    }
    
    public void LoadComboBoxKhachHang(JComboBox cbb){
        LoadComboBox lcb = new LoadComboBox();
        lcb.LoadComboBoxKhachHang(cbb);
    }
    
    public void TimKh(JTable tb, JComboBox cbb){
        Vector tbTieuDe = new Vector();
        Vector tbDong = new Vector();
        tbTieuDe.add("Mã khách hàng");
        tbTieuDe.add("Tên khách hàng");
        tbTieuDe.add("Địa chỉ");
        tbTieuDe.add("Điện thoại");
        for (KhachHang kh : khDal.TimKH(cbb)){
            Vector v = new Vector();
            v.add(kh.getMaKhach());
            v.add(kh.getTenKhach());
            v.add(kh.getDiaChi());
            v.add(kh.getDienThoai());
            tbDong.add(v);
            tb.setModel(new DefaultTableModel(tbDong, tbTieuDe));
        }
    }
}

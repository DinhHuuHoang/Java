/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoadComboBox;
import DAL.MatHangDAL;
import DTO.MatHang;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinhh
 */
public class MatHangBLL {
    MatHangDAL mhDAL = new MatHangDAL();
    public void LoadDsMH(JTable tb){
        Vector tbTieuDe = new Vector();
        Vector tbDong = new Vector();
        tbTieuDe.add("Mã MH");
        tbTieuDe.add("Tên MH");
        tbTieuDe.add("Mã chất liệu");
        tbTieuDe.add("Số Lương");
        tbTieuDe.add("Đon giá nhập");
        tbTieuDe.add("Đơn giá bán");
        tbTieuDe.add("Ảnh");
        tbTieuDe.add("Ghi Chú");
        for (MatHang x : mhDAL.LoadDsMH()){
            Vector v = new Vector();
            v.add(x.getMaHang());
            v.add(x.getTenHang());
            v.add(x.getMaChatLieu());
            v.add(x.getSoLuong());
            v.add(x.getDonGiaNhap());
            v.add(x.getDonGiaBan());
            v.add(x.getAnh());
            v.add(x.getGhiChu());
            tbDong.add(v);
            tb.setModel(new DefaultTableModel(tbDong, tbTieuDe));
        }
       mhDAL.LoadDsMH();
    }
    public void LoadCbbMatHang(JComboBox cbb){
        LoadComboBox lcb = new LoadComboBox();
        lcb.LoadComboBoxMatHang(cbb);
    }
    public void Them(MatHang mh){
        mhDAL.Them(mh);
    }
    
    public void Xoa(String MaMH){
        mhDAL.Xoa(MaMH);
    }
    
    public void SuaMH(MatHang mh){
        mhDAL.Sua(mh);
    }
    
    public boolean getID(String manhap){
        return mhDAL.getID(manhap);
    }
}

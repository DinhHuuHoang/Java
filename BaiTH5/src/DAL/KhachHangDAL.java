/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHang;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author dinhh
 */
public class KhachHangDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<KhachHang> LoadDsKH(){
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "EXEC KhachHang_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaKhach = rs.getString("MaKhach");
                String TenKhach = rs.getString("TenKhach");
                String DiaChi = rs.getString("DiaChi");
                String DienThoai= rs.getString("DienThoai");
                KhachHang kh = new KhachHang(MaKhach, TenKhach, DiaChi, DienThoai);
                dskh.add(kh);
            }
            
        } catch (SQLException e) {
        }
        return dskh;
    }
    public void Them(KhachHang kh){
        try {
            String sql = "{call KhachHang_THEM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, kh.getMaKhach());
            cs.setString(2, kh.getTenKhach());
            cs.setString(3, kh.getDiaChi());
            cs.setString(4, kh.getDienThoai());
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call KhachHang_XOA(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHDDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(KhachHang kh){
        try {
            String sql = "{call KhachHang_Sua(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, kh.getMaKhach());
            cs.setString(2, kh.getTenKhach());
            cs.setString(3, kh.getDiaChi());
            cs.setString(4, kh.getDienThoai());
        } catch (Exception e) {
        }
    }
    public boolean getID(String makhach){
        Boolean ktra = true;
        try {
            String sql = "SELECT MaKhach FROM KhachHang";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while (rs.next()){
                if (makhach.equals(rs.getString("MaKhach")))
                    ktra = true;
                else
                    ktra = false;
                break;
                    
            }
        } catch (Exception e) {
        }
        return ktra;
    }
    public ArrayList<KhachHang> TimKH(JComboBox cbb){
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "EXEC KhachHang_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("MaKhach").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaKhach = rs.getString("MaKhach");
                    String TenKhach = rs.getString("TenKhach");
                    String DiaChi = rs.getString("DiaChi");
                    String DienThoai= rs.getString("DienThoai");
                    KhachHang kh = new KhachHang(MaKhach, TenKhach, DiaChi, DienThoai);
                    dskh.add(kh);
                }
            }
            
        } catch (Exception e) {
        }
        return dskh;
    }
}

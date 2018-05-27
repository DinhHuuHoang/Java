/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.MatHang;
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
public class MatHangDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<MatHang> LoadDsMH(){
        ArrayList<MatHang> dsmh = new ArrayList<MatHang>();
        try {
            String sql = "EXEC MatHang_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaHang = rs.getString("MaHang");
                String TenHang = rs.getString("TenHang");
                String MaChatLieu = rs.getString("MaChatLieu");
                Float SoLuong = rs.getFloat("SoLuong");
                Float DonGiaNhap = rs.getFloat("DonGiaNhap");
                Float DonGiaBan = rs.getFloat("DonGiaBan");
                String Anh = rs.getString("Anh");
                String GhiChu = rs.getString("GhiChu");
                MatHang mh = new MatHang(MaHang, TenHang, MaChatLieu, SoLuong, DonGiaNhap, DonGiaBan, Anh, GhiChu);
                dsmh.add(mh);
            }
            
        } catch (SQLException e) {
        }
        return dsmh;
    }
    public void Them(MatHang mh){
        try {
            String sql = "{call MatHang_THEM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, mh.getMaHang());
            cs.setString(2, mh.getTenHang());
            cs.setString(3, mh.getMaChatLieu());
            cs.setFloat(4, mh.getDonGiaNhap());
            cs.setFloat(5, mh.getDonGiaBan());
            cs.setFloat(6, mh.getSoLuong());
            cs.setString(7, mh.getAnh());
            cs.setString(8, mh.getGhiChu());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call MatHang_XOA(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHDDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(MatHang mh){
        try {
            String sql = "{call MatHang_Sua(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, mh.getMaHang());
            cs.setString(2, mh.getTenHang());
            cs.setString(3, mh.getMaChatLieu());
            cs.setFloat(4, mh.getDonGiaNhap());
            cs.setFloat(5, mh.getDonGiaBan());
            cs.setFloat(6, mh.getSoLuong());
            cs.setString(7, mh.getAnh());
            cs.setString(8, mh.getGhiChu());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public boolean getID(String MaHang){
        Boolean ktra = true;
        try {
            String sql = "SELECT MaHang FROM MatHang";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while (rs.next()){
                if (MaHang.equals(rs.getString("MaHang")))
                    ktra = true;
                else
                    ktra = false;
                break;
                    
            }
        } catch (Exception e) {
        }
        return ktra;
    }
    public ArrayList<MatHang> TimMH(JComboBox cbb){
        ArrayList<MatHang> dsmh = new ArrayList<MatHang>();
        try {
            String sql = "EXEC MatHang_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("MaHang").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaHang = rs.getString("MaHang");
                    String TenHang = rs.getString("TenHang");
                    String MaChatLieu = rs.getString("MaChatLieu");
                    Float SoLuong = rs.getFloat("SoLuong");
                    Float DonGiaNhap = rs.getFloat("DonGiaNhap");
                    Float DonGiaBan = rs.getFloat("DonGiaBan");
                    String Anh = rs.getString("Anh");
                    String GhiChu = rs.getString("GhiChu");
                    MatHang mh = new MatHang(MaHang, TenHang, MaChatLieu, SoLuong, DonGiaNhap, DonGiaBan, Anh, GhiChu);
                    dsmh.add(mh);
                }
            }
            
        } catch (Exception e) {
        }
        return dsmh;
    }
}

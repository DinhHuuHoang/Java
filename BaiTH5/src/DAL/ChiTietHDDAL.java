/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChiTietHD;
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
public class ChiTietHDDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<ChiTietHD> LoadDsCTHD(){
        ArrayList<ChiTietHD> dsct = new ArrayList<ChiTietHD>();
        try {
            String sql = "EXEC ChiTietHD_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaHDBan = rs.getString("MaHDBan");
                String MaHang = rs.getString("MaHang");
                Float SoLuong = rs.getFloat("SoLuong");
                Float DonGia = rs.getFloat("DonGia");
                Float GiamGia = rs.getFloat("GiamGia");
                Float ThanhTien = rs.getFloat("ThanhTien");
                ChiTietHD ct = new ChiTietHD(MaHDBan, MaHang, SoLuong, DonGia, GiamGia, ThanhTien);
                dsct.add(ct);
            }
            
        } catch (SQLException e) {
        }
        return dsct;
    }
    public void Them(ChiTietHD ct){
        try {
            String sql = "{call ChiTietHDBan_THEM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, ct.getMaHDBan());
            cs.setString(2, ct.getMaHang());
            cs.setFloat(3, ct.getDonGia());
            cs.setFloat(4, ct.getGiamGia());
            cs.setFloat(5, ct.getSoLuong());
            cs.setFloat(6, ct.getThanhTien());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call ChiTietHDBan_XOA(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHDDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(ChiTietHD ct){
        try {
            String sql = "{call ChiTietHDBan_SUA(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, ct.getMaHDBan());
            cs.setString(2, ct.getMaHang());
            cs.setFloat(3, ct.getDonGia());
            cs.setFloat(4, ct.getGiamGia());
            cs.setFloat(5, ct.getSoLuong());
            cs.setFloat(6, ct.getThanhTien());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public boolean getID(String MaHDBan){
        Boolean ktra = true;
        try {
            String sql = "SELECT MaHDBan FROM ChiTietHDBan";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while (rs.next()){
                if (MaHDBan.equals(rs.getString("MaHDBan")))
                    ktra = true;
                else
                    ktra = false;
                break;
                    
            }
        } catch (Exception e) {
        }
        return ktra;
    }
    public ArrayList<ChiTietHD> TimCT(JComboBox cbb){
        ArrayList<ChiTietHD> dsct = new ArrayList<ChiTietHD>();
        try {
            String sql = "EXEC ChiTietHDBan_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("MaHDBan").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaHDBan = rs.getString("MaHDBan");
                    String MaHang = rs.getString("MaHang");
                    Float SoLuong = rs.getFloat("SoLuong");
                    Float DonGia = rs.getFloat("DonGia");
                    Float GiamGia = rs.getFloat("GiamGia");
                    Float ThanhTien = rs.getFloat("ThanhTien");
                    ChiTietHD ct = new ChiTietHD(MaHDBan, MaHang, SoLuong, DonGia, GiamGia, ThanhTien);
                    dsct.add(ct);
                }
            }
            
        } catch (Exception e) {
        }
        return dsct;
    }
}


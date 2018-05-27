/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HoaDon;
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
public class HoaDonDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<HoaDon> LoadDsHD(){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "EXEC HoaDon_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaHDBan= rs.getString("MaHDBan");
                String MaNhanVien = rs.getString("MaNhanVien");
                String NgayBan = rs.getString("NgayBan");
                String MaKhach = rs.getString("MaKhach");
                Float TongTien = rs.getFloat("TongTien");
                HoaDon hd = new HoaDon(MaHDBan, MaNhanVien, NgayBan, MaKhach, TongTien);
                dshd.add(hd);
            }
            
        } catch (Exception e) {
        }
        return dshd;
    }
    public void Them(HoaDon hd){
        try {
            String sql = "{call HoaDon_THEM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, hd.getMaHDBan());
            cs.setString(2, hd.getMaNhanVien());
            cs.setString(3, hd.getNgayBan());
            cs.setString(4, hd.getMaKhach());
            cs.setFloat(6, hd.getTongTien());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call HoaDon_XOA(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(HoaDon hd){
        try {
            String sql = "{call HoaDon_Sua(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, hd.getMaHDBan());
            cs.setString(2, hd.getMaNhanVien());
            cs.setString(3, hd.getNgayBan());
            cs.setString(4, hd.getMaKhach());
            cs.setFloat(6, hd.getTongTien());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public boolean getID(String MaHDBan){
        Boolean ktra = true;
        try {
            String sql = "SELECT MaHDBan HoaDonBan";
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
    public ArrayList<HoaDon> TimHD(JComboBox cbb){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "EXEC HoaDonBan_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("MaHDBan").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaHDBan= rs.getString("MaHDBan");
                String MaNhanVien = rs.getString("MaNhanVien");
                String NgayBan = rs.getString("NgayBan");
                String MaKhach = rs.getString("MaKhach");
                Float TongTien = rs.getFloat("TongTien");
                HoaDon hd = new HoaDon(MaHDBan, MaNhanVien, NgayBan, MaKhach, TongTien);
                dshd.add(hd);
                }
            }
            
        } catch (Exception e) {
        }
        return dshd;
    }
}

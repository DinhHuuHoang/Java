/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.*;
import BLL.NhanVienBLL;
import DTO.NhanVien;
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
public class NhanVienDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<NhanVien> LoadDsNV(){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM NHANVIEN";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String DienThoai = rs.getString("DienThoai");
                String NgaySinh = rs.getString("NgaySinh");
                NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, GioiTinh, DiaChi, DienThoai, NgaySinh);
                dsnv.add(nv);
            }
            
        } catch (Exception e) {
        }
        return dsnv;
    }
    public void Them(NhanVien nv){
        try {
            String sql = "{call NhanVien_Them(?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, nv.getMaNhanVien());
            cs.setString(2, nv.getTenNhanVien());
            cs.setString(3, nv.getGioiTinh());
            cs.setString(4, nv.getDiaChi());
            cs.setString(5, nv.getDienThoai());
            cs.setString(6, nv.getNgaySinh());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call NhanVien_Xoa(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(NhanVien nv){
        try {
            String sql = "{call NhanVien_Sua(?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, nv.getMaNhanVien());
            cs.setString(2, nv.getTenNhanVien());
            cs.setString(3, nv.getGioiTinh());
            cs.setString(4, nv.getDiaChi());
            cs.setString(5, nv.getDienThoai());
            cs.setString(6, nv.getNgaySinh());
            cs.execute();
        } catch (SQLException e) {
        }
    }
    public boolean getID(String Manhanvien){
        Boolean ktra = true;
        try {
            String sql = "SELECT Manhanvien FROM NhanVien";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while (rs.next()){
                if (Manhanvien.equals(rs.getString("Manhanvien")))
                    ktra = true;
                else
                    ktra = false;
                break;
                    
            }
        } catch (Exception e) {
        }
        return ktra;
    }
    public ArrayList<NhanVien> TimNV(JComboBox cbb){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "EXEC NhanVien_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("Manhanvien").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String DienThoai = rs.getString("DienThoai");
                String NgaySinh = rs.getString("NgaySinh");
                NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, GioiTinh, DiaChi, DienThoai, NgaySinh);
                dsnv.add(nv);
                }
            }
            
        } catch (Exception e) {
        }
        return dsnv;
    }

    public void Them(NhanVienBLL nv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Sua(NhanVienBLL nv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

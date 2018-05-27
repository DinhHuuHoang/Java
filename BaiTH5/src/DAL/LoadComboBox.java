/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author dinhh
 */
public class LoadComboBox {
    public void LoadComboBox(JComboBox cbb, String sql, String b){
        try {
            DBConnect s = new DBConnect();
            Connection conn = s.getConnection();
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                cbb.addItem(rs.getString(b));
            }
        } catch (Exception e) {
        }
    }
    public void LoadComboBoxKhachHang(JComboBox cbb){
        cbb.removeAllItems();
        String sql = "SELECT * FROM KhachHang";
        String b = "MaKhachHang";
        LoadComboBox(cbb, sql, b);
    }
    public void LoadComboBoxMatHang(JComboBox cbb){
        cbb.removeAllItems();
        String sql = "SELECT * FROM MatHang";
        String b = "MaHang";
        LoadComboBox(cbb, sql, b);
    }
    public void LoadComboBoxNhanVien(JComboBox cbb){
        cbb.removeAllItems();
        String sql = "SELECT * FROM NhanVien";
        String b = "MaNhanVien";
        LoadComboBox(cbb, sql, b);
    }
}

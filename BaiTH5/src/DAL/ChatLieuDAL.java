/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChatLieu;
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
public class ChatLieuDAL {
    DBConnect s = new DBConnect();
    Connection conn = s.getConnection();
    public ArrayList<ChatLieu> LoadDsCL(){
        ArrayList<ChatLieu> dscl = new ArrayList<ChatLieu>();
        try {
            String sql = "EXEC ChatLieu_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                String MaChatLieu = rs.getString("MaChatLieu");
                String TenChatLieu = rs.getString("TenChatLieu");
                ChatLieu chat = new ChatLieu(MaChatLieu, TenChatLieu);
                dscl.add(chat);
            }
            
        } catch (Exception e) {
        }
        return dscl;
    }
    public void Them(ChatLieu chat){
        try {
            String sql = "{call ChatLieu_THEM(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, chat.getMaChatLieu());
            cs.setString(2, chat.getTenChatLieu());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public void Xoa(String ma){
        try {
            String sql = "{call ChatLieu_XOA(?)}";
            CallableStatement cs  = conn.prepareCall(sql);
            cs.setString(1, ma);
            cs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Sua(ChatLieu chat){
        try {
            String sql = "{call ChatLieu_SUA(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, chat.getMaChatLieu());
            cs.setString(2, chat.getTenChatLieu());
            cs.execute();
        } catch (Exception e) {
        }
    }
    public boolean getID(String MaChatLieu){
        Boolean ktra = true;
        try {
            String sql = "SELECT MaChatLieu FROM ChatLieu";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while (rs.next()){
                if (MaChatLieu.equals(rs.getString("MaChatLieu")))
                    ktra = true;
                else
                    ktra = false;
                break;
                    
            }
        } catch (Exception e) {
        }
        return ktra;
    }
    public ArrayList<ChatLieu> TimCL(JComboBox cbb){
        ArrayList<ChatLieu> dscl = new ArrayList<ChatLieu>();
        try {
            String sql = "EXEC ChatLieu_LOAD";
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("TenChatLieu").toUpperCase().equals(cbb.getSelectedItem().toString().toUpperCase())){
                    String MaChatLieu = rs.getString("MaChatLieu");
                    String TenChatLieu = rs.getString("TenChatLieu");
                    ChatLieu chat = new ChatLieu(MaChatLieu, TenChatLieu);
                    dscl.add(chat);
                }
            }
            
        } catch (Exception e) {
        }
        return dscl;
    }
}

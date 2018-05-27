/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author dinhh
 */
public class ChatLieu {
    private String MaChatLieu;
    private String TenChatLieu;
    public ChatLieu(String MaChatLieu, String TenChatLieu){
        this.MaChatLieu = MaChatLieu;
        this.TenChatLieu = TenChatLieu;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinhh
 */
public class DBConnect {
//    Connection conn;
//    
//    public Connection getConnection(){
//        String conStrSQL = "jdbc:sqlserver://localhost:1433;databasename=QLBH;user=sa;password=123";
//        try {
//            Connection con = DriverManager.getConnection(conStrSQL);
//            if(con!=null)
//                System.out.print("Da ket noi");
//        } catch (SQLException ex) {
//            System.out.print("khong ket noi duoc");
//        }
//        return conn;
//    }
    
    Connection conn;
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://DINH-HUU-HOANG\\\\MSSQLSEVER:1433;databaseName=Ban_Hang;user=sa;password = dinhhuu97");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public void Close(){
        if(conn != null){
            try {
                if(!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn = null;
    }
}
//public class DBConnect{
//    
//    public static Connection MoKetNoi(){
//    try{
//        String constrMSSQL = "jdbc:sqlserver://DINH-HUU-HOANG\\MSSQLSEVER:1433;databaseName=Ban_Hang;user=sa;password = dinhhuu97";
//        Connection conn = DriverManager.getConnection(constrMSSQL);
//        if (conn != null) {
//            System.out.println("Connected");
//            return  conn;
////            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
////            System.out.println("Driver name: " + dm.getDriverName());
////            System.out.println("Driver version: " + dm.getDriverVersion());
////            System.out.println("Product name: " + dm.getDatabaseProductName());
////            System.out.println("Product version: " + dm.getDatabaseProductVersion()); 
//    }
//   }
//    catch (SQLException ex) {
//        System.err.println("Cannot connect database, " + ex);
//   }
//    return null;
//    }
//    public Connection getConnection() {
//       
//       throw new UnsupportedOperationException("Not supported yet.");
// 
//}
//}
//class DBConnect {
//
//    Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}

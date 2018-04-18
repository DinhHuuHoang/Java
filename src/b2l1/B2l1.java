/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b2l1;

import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class B2l1 {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        // TODO code application logic here
        HCN tinh=new HCN();
         tinh.nhapDL();
         tinh.chuvi();
         tinh.dientich();
         System.out.println("Chu vi: " + tinh.chuvi());
         System.out.println("Dien tich: " + tinh.dientich());
         System.out.println("Canh nho nhat: " + tinh.canhmin());
    }
    
}
class HCN{
    int cd, cr, cv, dt, cm;
   public void nhapDL()
   {
       Scanner nhap=new Scanner(System.in);
        System.out.println("Nhap chieu dai:");
        cd=nhap.nextInt();
        System.out.println("Nhap chieu rong:");
        cr=nhap.nextInt();
     
   }
   public int dientich()
   {
       dt = cd * cr;
       return dt;
   }
   public int chuvi()
   {
      cv= 2* (cd + cr);
      return cv;
   }
   public int canhmin()
   {
      cm = Math.min(cd, cr);
      return cm;
   }
}

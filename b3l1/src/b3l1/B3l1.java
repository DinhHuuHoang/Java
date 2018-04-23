/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3l1;

import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class B3l1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KLP tinh = new KLP();
         tinh.nhap();
         tinh.thetich();
         System.out.println("The tich: " + tinh.thetich());
    }
    
}
class KLP{
    int a, t2;
    public void nhap(){
        Scanner nhap=new Scanner(System.in);
        System.out.println("Nhap canh khoi lap phuong: ");
        a=nhap.nextInt();
    }
    public int thetich(){
        t2 = (int) Math.pow(a, 3);
        return t2;
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4l1;

import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class B4l1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PTB2 tinh = new PTB2();
        tinh.nhap();
        tinh.tinhcan();
        System.out.println("Can: " + tinh.tinhcan());
    }
    
}
class PTB2{
    int a, b,c, delta, can;
    public void nhap(){
        Scanner nhap=new Scanner(System.in);
        System.out.println("Nhap a:");
        a=nhap.nextInt();
        System.out.println("Nhap b:");
        b=nhap.nextInt();
        System.out.println("Nhap c:");
        c=nhap.nextInt();
    }
    public int  tinhcan(){
        delta = (int) Math.pow(b, 2) - 4*a*c;
        can = (int) Math.sqrt(delta);
        return can;
    }
}

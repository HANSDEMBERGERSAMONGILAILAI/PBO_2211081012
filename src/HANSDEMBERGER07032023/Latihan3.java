/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HANSDEMBERGER07032023;

/**
 *
 * @author LABSIKOMP03
 */
public class Latihan3 {
    public static void main(String[] args){
        int a = 10;
        int b = 23;
        int c = 5;
        
        int max = (a>b)?((a>c)?a:c):((b>c)?b:c);
        
        //cetak variabel
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
        System.out.println("c = "+ c);
        System.out.println("max = "+ max);
    }
}

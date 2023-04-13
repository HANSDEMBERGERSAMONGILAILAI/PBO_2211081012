/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER130423;

/**
 *
 * @author HP
 */
public class Lingkaran {
   private double x;
   
public Lingkaran(double x){
    this.x = x;
}
public double luas(){
    double luas = 3.14*x*x;
    return luas;
}
public static void main(String[] args){
    Lingkaran line1 = new Lingkaran(5);
    Lingkaran line2 = new Lingkaran(4);
    Relation bdg = new MyDouble();
    
    System.out.println(" line1 > line2: " + bdg.isGreater(line1.luas(), line2.luas()));
    System.out.println(" line1 < line2: " + bdg.isLess(line1.luas(), line2.luas()));
    System.out.println(" line1 = line2: " + bdg.isEqual(line1.luas(), line2.luas()));
    }
}
   
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER130423;

/**
 *
 * @author HP
 */
public class InterfaceExample {
    public static void main(String[] args){
        Relation MyInteger = new MyInteger();
        Relation MyDouble = new MyDouble();
        
        System.out.println(" 10 dan 11" + MyInteger.isEqual(10, 11));
        System.out.println(" 10.4 dan 10.6" + MyDouble.isEqual(10.4, 10.6));
    }
}

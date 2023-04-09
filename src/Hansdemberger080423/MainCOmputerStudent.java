/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger080423;

/**
 *
 * @author HP
 */
public class MainCOmputerStudent {
    public static void main(String[] args) {
        ComputerStudent cs = new ComputerStudent();
        cs.setMathGrade(80);
        cs.setEnglishGrade(85);
        cs.setScienceGrade(90);
        cs.setCompGrade(95);
        System.out.println("Name: " + cs.getName());
        System.out.println("Address: " + cs.getAddress());
        System.out.println("Average: " + cs.getAverage());
    }
}



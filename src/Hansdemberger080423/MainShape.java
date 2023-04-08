/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger080423;

/**
 *
 * @author HP
 */
public class MainShape {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle radius: " + circle.getRadius());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle name: " + circle.getName());

        Square square = new Square(7);
        System.out.println("Square side: " + square.getSide());
        System.out.println("Square area: " + square.getArea());
        System.out.println("Square name: " + square.getName());
    }
}

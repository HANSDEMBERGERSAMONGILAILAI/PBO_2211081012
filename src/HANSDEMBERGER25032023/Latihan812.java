/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER25032023;

/**
 *
 * @author HP
 */
public class Latihan812 {
    public static void main(String[] args) {
        // memeriksa jumlah argumen yang diberikan
        if (args.length != 2) {
            System.out.println("Error: Harap masukkan 2 bilangan");
            return;
        }

        // mengambil input dari argumen
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        // menjalankan operasi aritmatika
        int sum = num1 + num2;
        int difference = num1 - num2;
        int product = num1 * num2;
        int quotient = num1 / num2;

        // menampilkan hasil
        System.out.println("sum = " + sum);
        System.out.println("difference = " + difference);
        System.out.println("product = " + product);
        System.out.println("quotient = " + quotient);
    }
}

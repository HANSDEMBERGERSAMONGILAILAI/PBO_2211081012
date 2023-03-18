/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER18032023;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author HP
 */
public class Latihan721 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Masukkan nomor ke-" + (i+1) + ": ");
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        System.out.println("Nomor terbesar yang diinputkan adalah: " + maxNumber);
    }
}


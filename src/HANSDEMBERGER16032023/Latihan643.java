/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER16032023;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Latihan643 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Masukkan angka: ");
    int angka = scanner.nextInt();

    System.out.print("Masukkan pangkat: ");
    int pangkat = scanner.nextInt();

    int hasil = 1;
    for (int i = 0; i < pangkat; i++) {
      hasil *= angka;
    }

    System.out.println("Hasil: " + hasil);
  }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HANSDEMBERGER16032023;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author LABP1KOMP
 */
public class Latihan61 {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        System.out.print("Masukkan nilai ujian pertama");
        double nilai1 = Double.parseDouble(reader.readLine());
        System.out.print("Masukkan nilai ujian kedua");
        double nilai2 = Double.parseDouble(reader.readLine());
        System.out.print("Masukkan nilai ujian ketiga");
        double nilai3 = Double.parseDouble(reader.readLine());
        
        double rataRata = (nilai1 + nilai2 + nilai3) / 3;
        System.out.println("Rata-rata nilai ujian adalah: " + rataRata);
        
        if (rataRata >= 60) {
            System.out.println(":)");
        } else {
            System.out.println(":(");
            
        }
        
    }
}
  


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER16032023;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Latihan611 {
  public static void main(String[] args) {
    String nilai1Str = JOptionPane.showInputDialog("Masukkan nilai ujian 1:");
    double nilai1 = Double.parseDouble(nilai1Str);

    String nilai2Str = JOptionPane.showInputDialog("Masukkan nilai ujian 2:");
    double nilai2 = Double.parseDouble(nilai2Str);

    String nilai3Str = JOptionPane.showInputDialog("Masukkan nilai ujian 3:");
    double nilai3 = Double.parseDouble(nilai3Str);

    double rataRata = (nilai1 + nilai2 + nilai3) / 3.0;

    String output = String.format("Rata-rata dari tiga ujian adalah %.2f", rataRata);

    if (rataRata >= 60) {
      output += " :)";
    } else {
      output += " :(";
    }

    JOptionPane.showMessageDialog(null, output);
  }
}



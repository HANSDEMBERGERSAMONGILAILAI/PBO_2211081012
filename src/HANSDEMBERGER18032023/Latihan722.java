/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER18032023;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Latihan722 {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            String input = JOptionPane.showInputDialog("Masukkan nomor ke-" + (i+1) + ":");
            numbers[i] = Integer.parseInt(input);
        }

        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        JOptionPane.showMessageDialog(null, "Nomor terbesar yang diinputkan adalah: " + maxNumber);
    }
}
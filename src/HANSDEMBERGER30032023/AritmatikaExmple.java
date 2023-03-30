/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER30032023;

/**
 *
 * @author HP
 */
public class AritmatikaExmple {
    public static void main(String[] args) {
        Aritmatika ex =new Aritmatika();
      
        int hasilTambah = ex.tambah(5, 3);
      boolean ganjil = ex.cekganjil(7);
      System.out.println("Hasil tambah: " + hasilTambah);
      System.out.println("Apakah 7 ganjil? " + ganjil);
      
      int[] ma= ex.ambilBilanganPertama(5);
      for(int i = 0; i<ma.length;i++){
          System.out.print(ma[i]+ " ");
      }
      System.out.println();
      
      int[] mb= ex.ambilBilanganPrima(5);
      for(int i = 0; i<mb.length;i++){
          System.out.print(mb[i]+ " ");
      }
      System.out.println();
    }
}

    



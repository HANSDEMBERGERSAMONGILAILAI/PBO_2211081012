/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HANSDEMBERGER30032023;

/**
 *
 * @author HP
 */
public class Aritmatika {
   public static int tambah(int a, int b) {
      return a + b;
   }
   public static boolean cekganjil(int a) {
      if(a % 2 != 0) {
         return true;
      } else {
         return false;
      }
   }
    
    public static int[] ambilBilanganPertama(int n) {
        int[] bilanganPertama = new int[n];
        for (int i = 0; i < n; i++) {
            bilanganPertama[i] = 2 * i + 1;
        }
        return bilanganPertama;
    }
    
    public static boolean prima(int n){
        int f = 0;
        for(int i =1;i<=n;i++){
            if(n%i ==0){
                f++;
            }
        }
        return (f==2);
    }
    
    public static int[] ambilBilanganPrima(int n) {
        int[] primaPertama = new int[n];
        int i = 0, j =0;
        while ( i < n) {
            if(prima(j)){
                primaPertama[i]=j;
                i++;
            }
            j++;
        }
        return primaPertama;
    }
}


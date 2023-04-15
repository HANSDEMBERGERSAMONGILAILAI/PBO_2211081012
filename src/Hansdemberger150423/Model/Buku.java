/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Model;

/**
 *
 * @author HP
 */
public class Buku {
    private String kodebuku;
    private String judulbuku;
    private String pengarang;
    private String penerbit;
    private int tahunterbit;
    
    public Buku(){}
    
    public Buku(String kd, String jdl, String peng, String pen, int th){
        this.kodebuku = kd;
        this.judulbuku = jdl;
        this.pengarang = peng;
        this.penerbit = pen;
        this.tahunterbit = th;
    }
    public void setKode(String alamat){
        this.kodebuku = alamat;
    }
    public String getKode(){
       return kodebuku;
    
    }
}
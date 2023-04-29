/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Model;

/**
 *
 * @author User
 */
public class Buku {
    private String kode;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahun;
    
    public Buku(){
    }
    
    public Buku(String kode, String judul, String pengarang, String penerbit, int tahun) {
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
        
    }
    
    public String getKode(){
        return kode;
    }
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getPengarang(){
        return pengarang;
    }
    
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }

    public String getPenerbit(){
        return penerbit;
    }
    
    public void setPenerbit(String penerbit){
        this.penerbit = penerbit;
    }
    
    public int getTahun(){
        return tahun;
    }
    
    public void setTahun(int tahun){
        this.tahun = tahun;
    }
}


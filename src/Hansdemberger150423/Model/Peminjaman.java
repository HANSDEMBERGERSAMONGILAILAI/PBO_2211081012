/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Model;

/**
 *
 * @author HP
 */
public class Peminjaman {
    private String nobp;
    private String kodebuku;
    private String tglpinjam;
    private String tglkembali;
    public Peminjaman() {}
    public Peminjaman(String nobp, String kodebuku, String tglpinjam, String tglkembali) {
        this.nobp = nobp;
        this.kodebuku = kodebuku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }
    
    // getters and setters
    public String getNobp() {
        return nobp;
    }

    public void setNoBp(String nobp) {
        this.nobp = nobp;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setkodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String gettglpinjam() {
        return tglpinjam;
    }

    public void settglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String gettglkembali() {
        return tglkembali;
    }

    public void settglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
}



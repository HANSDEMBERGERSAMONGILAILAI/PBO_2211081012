/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hansdemberger02042023;

/**
 *
 * @author HP
 */
public class DataAlamat {
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    // Constructor
    public DataAlamat(String nama, String alamat, String telepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
    }
    
    // Accessor method
    public String getNama() {
        return nama;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public String getTelepon() {
        return telepon;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Mutator method
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}


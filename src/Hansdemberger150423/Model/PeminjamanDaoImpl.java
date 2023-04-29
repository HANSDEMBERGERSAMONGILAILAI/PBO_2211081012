/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class PeminjamanDaoImpl implements PeminjamanDao{
     List<Peminjaman> data = new ArrayList<>();
     
     public PeminjamanDaoImpl(){
        AnggotaDao daoAnggota = new AnggotaDaoImpl();
        BukuDao daoBuku = new BukuDaoImpl();
        data.add(new Peminjaman(daoAnggota.getAnggota(0), daoBuku.getBuku(0), "12/12/2020","13/12/2023"));
        data.add(new Peminjaman(daoAnggota.getAnggota(0),daoBuku.getBuku(0), "15/09/2020","15/10/2020"));
        data.add(new Peminjaman(daoAnggota.getAnggota(0),daoBuku.getBuku(0), "15/09/2021","16/11/2021"));
    }
    
    public void save(Peminjaman Peminjaman){
        data.add(Peminjaman );
    }
    public void update(int index,Peminjaman peminjaman){
        data.set(index, peminjaman);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Peminjaman getPeminjaman(int index){
        return data.get(index);
    }
    public List<Peminjaman> getAll(){
        return data;
        
    }
}


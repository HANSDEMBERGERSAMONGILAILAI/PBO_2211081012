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
public class AnggotaDaoImpl implements AnggotaDao{
    List<Anggota> data = new ArrayList<>();
    
    public AnggotaDaoImpl(){
        data.add(new Anggota("1111", "Ali", "Padang"));
        data.add(new Anggota("1112", "Deni", "Padang panjang"));
        data.add(new Anggota("1113", "Ani", "Padang"));
    }
    
    public void save(Anggota anggota){
        data.add(anggota);
    }
    public void update(int index,Anggota anggota){
        data.set(index, anggota);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Anggota getAnggota(int index){
        return data.get(index);
    }
    public List<Anggota> getAll(){
        return data;
        
    }
}

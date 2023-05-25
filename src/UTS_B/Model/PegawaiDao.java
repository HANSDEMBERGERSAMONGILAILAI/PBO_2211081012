/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UTS_B.Model;
import java.util.List;
/**
 *
 * @author HP
 */
public interface PegawaiDao {
    void save(Pegawai pegawai);
    void update(int index, Pegawai pegawai);
    void delete(int index);
    Pegawai getPegawai(int index);
    List<Pegawai> getAll();
    

}

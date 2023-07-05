/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.dao;
import hans.model.Peminjaman;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author HP
 */
public interface PeminjamanDao {
    void insert (Peminjaman p) throws Exception;
    void update (Peminjaman p)throws Exception;
    void delete (Peminjaman p) throws Exception;
    Peminjaman getPeminjaman(String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    List <Peminjaman> getAll() throws Exception;;
    
}

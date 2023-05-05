/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Controler;
import Hansdemberger150423.View.FormPeminjaman;
import Hansdemberger150423.Model.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private PeminjamanDao peminjamanDao;
    private Peminjaman peminjaman;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    
    public PeminjamanController (FormPeminjaman formPeminjaman){
        this.formPeminjaman = formPeminjaman;
        peminjamanDao = new PeminjamanDaoImpl();
        anggotaDao = new AnggotaDaoImpl();
        bukuDao = new BukuDaoImpl();
    }
    
    public void bersihForm(){
        formPeminjaman.getTxtTglpinjam().setText("");
        formPeminjaman.getTxtTglkembali().setText("");
    }
    
    public void isiCombo(){
        List<Anggota> listAnggota = anggotaDao.getAll();
        List<Buku> listBuku = bukuDao.getAll();
        formPeminjaman.getCboAnggota().removeAllItems();
        formPeminjaman.getCboBuku().removeAllItems();
        
        //isi anggota
        for (Anggota anggota : listAnggota){
           formPeminjaman.getCboAnggota().addItem(anggota.getNobp());
        }
        
        for (Buku buku : listBuku){
           formPeminjaman.getCboBuku().addItem(buku.getKode());
            
        }
        
    }
    
    public void savePeminjaman(){
        peminjaman = new Peminjaman();
        peminjaman.setAnggota(
 anggotaDao.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex()));
        bukuDao.getBuku(formPeminjaman.getCboBuku().getSelectedIndex());
        peminjaman.settglpinjam(formPeminjaman.getTxtTglpinjam().getText());
        peminjaman.settglkembali(formPeminjaman.getTxtTglkembali().getText());
        peminjamanDao.save(peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman,
                "Entri Ok");
    }
    
    public void getPeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman = peminjamanDao.getPeminjaman(index);
        if(peminjaman != null){
            formPeminjaman.getCboAnggota().setSelectedItem(peminjaman.getAnggota().getNobp());
            formPeminjaman.getCboBuku().setSelectedItem(peminjaman.getbuku().getKode());
            formPeminjaman.getTxtTglpinjam().setText(peminjaman.gettglpinjam());
            formPeminjaman.getTxtTglkembali().setText(peminjaman.gettglkembali());
        }
    }
    
    public void updatePeminjaman(){
    int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman.setAnggota(
 anggotaDao.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex()));
        bukuDao.getBuku(formPeminjaman.getCboBuku().getSelectedIndex());
        peminjaman.settglpinjam(formPeminjaman.getTxtTglpinjam().getText());
        peminjaman.settglkembali(formPeminjaman.getTxtTglkembali().getText());
        peminjamanDao.update(index, peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman,
            "Update Ok");
    }


public void deletePeminjaman(){
    int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
    peminjamanDao.delete(index);
    javax.swing.JOptionPane.showMessageDialog(formPeminjaman,
            "Delete ok");
}

    
    public void tampildata(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman>List = peminjamanDao.getAll();
        for(Peminjaman peminjaman : List){
            Object[] data = {
                peminjaman.getAnggota().getNobp(),
                peminjaman.getAnggota().getNama(),
                peminjaman.getbuku().getKode(),
                peminjaman.gettglpinjam(),
                peminjaman.gettglkembali(),
            };
            tabelModel.addRow(data);
            }
            
        }
}
        
    


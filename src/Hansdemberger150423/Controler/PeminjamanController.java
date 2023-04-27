/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Controler;
import Hansdemberger150423.View.FormPeminjaman;
import Hansdemberger150423.Model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private PeminjamanDao peminjamanDao;
    private Peminjaman peminjaman;
    
    public PeminjamanController (FormPeminjaman formPeminjaman){
        this.formPeminjaman = formPeminjaman;
        peminjamanDao = new PeminjamanDaoImpl();   
    }
    
    public void bersihForm(){
        formPeminjaman.getTxtNoBp().setText("");
        formPeminjaman.getTxtkodebuku().setText("");
        formPeminjaman.getTxttglpinjam().setText("");
        formPeminjaman.getTxttglkembali().setText("");
    }
    
    public void savePeminjaman(){
        peminjaman = new Peminjaman();
        peminjaman.setNoBp(formPeminjaman.getTxtNoBp().getText());
        peminjaman.setkodebuku(formPeminjaman.getTxtkodebuku().getText());
        peminjaman.settglpinjam(formPeminjaman.getTxttglpinjam().getText());
        peminjaman.settglkembali(formPeminjaman.getTxttglkembali().getText());
        peminjamanDao.save(peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman,
                "Entri Ok");
    }
    
    public void getPeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman = peminjamanDao.getPeminjaman(index);
        if(peminjaman != null){
            formPeminjaman.getTxtNoBp().setText(peminjaman.getNobp());
            formPeminjaman.getTxtkodebuku().setText(peminjaman.getKodebuku());
            formPeminjaman.getTxttglpinjam().setText(peminjaman.gettglpinjam());
            formPeminjaman.getTxttglkembali().setText(peminjaman.gettglkembali());
        }
    }
    
    public void updatePeminjaman(){
    int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
    peminjaman = peminjamanDao.getPeminjaman(index);
    if(peminjaman != null){
        peminjaman.setNoBp(formPeminjaman.getTxtNoBp().getText());
        peminjaman.setkodebuku(formPeminjaman.getTxtkodebuku().getText());
        peminjaman.settglpinjam(formPeminjaman.getTxttglpinjam().getText());
        peminjaman.settglkembali(formPeminjaman.getTxttglkembali().getText());
        peminjamanDao.update(index, peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman,
            "Update Ok");
    }
}

public void deletePeminjaman(){
    int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
    peminjaman = peminjamanDao.getPeminjaman(index);
    if(peminjaman != null){
        peminjamanDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Delete");
    }
}

    
    public void tampildata(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman>List = peminjamanDao.getAll();
        for(Peminjaman peminjaman : List){
            Object[] data = {
                peminjaman.getNobp(),
                peminjaman.getKodebuku(),
                peminjaman.gettglpinjam(),
                peminjaman.gettglkembali(),
            };
            tabelModel.addRow(data);
            }
            
        }
        
    }


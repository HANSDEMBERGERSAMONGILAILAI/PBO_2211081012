/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Controler;
import Hansdemberger150423.View.FormAnggota;
import Hansdemberger150423.Model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class AnggotaControler {
    private FormAnggota formAnggota;
    private AnggotaDao anggotaDao;
    private Anggota anggota;
    
    public AnggotaControler (FormAnggota formAnggota){
        this.formAnggota = formAnggota;
        anggotaDao = new AnggotaDaoImpl();   
    }
    
    public void bersihForm(){
        formAnggota.getTxtNobp().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    public void saveAnggota(){
        anggota = new Anggota();
        anggota.setNobp(formAnggota.getTxtNobp().getText());
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggotaDao.save(anggota);
        javax.swing.JOptionPane.showMessageDialog(formAnggota,
                "Entri Ok");
    }
    
    public void getAnggota(){
        int index = formAnggota.getTblAnggota().getSelectedRow();
        anggota = anggotaDao.getAnggota(index);
        if(anggota != null){
            formAnggota.getTxtNobp().setText(anggota.getNobp());
            formAnggota.getTxtNama().setText(anggota.getNama());
            formAnggota.getTxtAlamat().setText(anggota.getAlamat());
        }
    }
    
    public void updateAnggota(){
        int index = formAnggota.getTblAnggota().getSelectedRow();
        anggota.setNobp(formAnggota.getTxtNobp().getText());
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggotaDao.update(index, anggota);
        javax.swing.JOptionPane.showMessageDialog(formAnggota,
                "Update Ok");
        
    }
    
    public void deleteAnggota(){
        int index = formAnggota.getTblAnggota().getSelectedRow();
        anggotaDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formAnggota, "Delete");
    }
    
    public void tampildata(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formAnggota.getTblAnggota().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Anggota>List = anggotaDao.getAll();
        for(Anggota anggota : List){
            Object[] data = {
                anggota.getNobp(),
                anggota.getNama(),
                anggota.getAlamat(),
            };
            tabelModel.addRow(data);
            }
            
        }
        
    }



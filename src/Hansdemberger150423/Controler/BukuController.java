/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger150423.Controler;

/**
 *
 * @author User
 */
import Hansdemberger150423.view.FormBuku;
import Hansdemberger150423.Model.*;
import javax.swing.table.DefaultTableModel;

public class BukuController {
    private FormBuku formBuku;
    private BukuDao bukuDao;
    private Buku buku;
    
    public BukuController(FormBuku formBuku){
    this.formBuku = formBuku;
    bukuDao = new BukuDaoImpl();
    }

    public void bersihForm(){
        formBuku.getTxtKode().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxtTahun().setText("");
    }

    public void saveBuku(){
        buku = new Buku();
        buku.setKode(formBuku.getTxtKode().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahun(Integer.parseInt(formBuku.getTxtTahun().getText()));
        bukuDao.save(buku);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Entri Ok");
    }

    public void getBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        buku = bukuDao.getBuku(index);
        if(buku != null){
            formBuku.getTxtKode().setText(buku.getKode());
            formBuku.getTxtJudul().setText(buku.getJudul());
            formBuku.getTxtPengarang().setText(buku.getPengarang());
            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            formBuku.getTxtTahun().setText(Integer.toString(buku.getTahun()));
        }
    }   

    public void updateBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        buku.setKode(formBuku.getTxtKode().getText());
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setTahun(Integer.parseInt(formBuku.getTxtTahun().getText()));
        bukuDao.update(index, buku);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Update Ok");
    }

    public void deleteBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        bukuDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Delete Ok");
    }

    public void tampilData(){
        DefaultTableModel tabelModel = (DefaultTableModel) formBuku.getTblBuku().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Buku> list = bukuDao.getAll();
        for(Buku buku : list){
            Object[] data = {
                buku.getKode(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getTahun()
            };
            tabelModel.addRow(data); 
        }
    }
}

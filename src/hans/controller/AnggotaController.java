/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.controller;
import hans.model.*;
import hans.dao.*;
import hans.db.DbHelper;
import hans.view.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AnggotaController {
    FormAnggota view;
    Anggota anggota;
    AnggotaDao dao;
    Connection con;
    
    public AnggotaController(FormAnggota view) {
        try {
            this.view = view;
            con = DbHelper.getConnection();
            dao = new AnggotaDaoImpl(con);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void clearForm(){
        view.getTxtKodeAnggota().setText("");
        view.getTxtNamaAnggota().setText("");
        view.getTxtAlamat().setText("");
        view.getCboJenisKelamin().removeAllItems();
        view.getCboJenisKelamin().addItem("L");
        view.getCboJenisKelamin().addItem("P");

    }
public void tampil(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel)
                    view .getTabelAnggota().getModel();
            tableModel.setRowCount(0);
            List<Anggota> list = dao.getAll();
            for (Anggota a : list) {
                Object[] row ={
                    a.getKodeanggota(),
                    a.getNamaanggota(),
                    a.getAlamat(),
                    a.getJeniskelamin()
                };
                tableModel.addRow(row);
            }       
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);       
        }
}
public void Insert(){
    try {
    anggota = new Anggota();
    anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
    anggota.setNamaanggota(view.getTxtNamaAnggota().getText());
    anggota.setAlamat(view.getTxtAlamat().getText());
    anggota.setJeniskelamin(view.getCboJenisKelamin()
              .getSelectedItem().toString());
    dao.insert(anggota);
    JOptionPane.showMessageDialog(view,"Entri Data Ok");
}catch (Exception ex){
    JOptionPane.showMessageDialog(view, ex.getMessage());
    Logger.getLogger(AnggotaController.class .getName()).log(Level.SEVERE,null,ex);
}
}
public void delete(){
    try{
        dao.delete(anggota);
        JOptionPane.showMessageDialog(view,"Delete data Ok");
    }catch(Exception ex){
        Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE,null,ex);
    }
}
public void tabelKlik(){
    try {
    String kodeAnggota = view.getTabelAnggota().getValueAt(view.getTabelAnggota().getSelectedRow(),0).toString();
    anggota = dao.getAnggota(kodeAnggota);
    view.getTxtKodeAnggota().setText(anggota.getKodeanggota());
    view.getTxtNamaAnggota().setText(anggota.getNamaanggota());
    view.getTxtAlamat().setText(anggota.getAlamat());
    view.getCboJenisKelamin().setSelectedItem(anggota.getJeniskelamin());
} catch (Exception ex) {
    Logger.getLogger(AnggotaController.class .getName()).log(Level.SEVERE,null,ex);
}
}

public void update(){
    try {
    anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
    anggota.setNamaanggota(view.getTxtNamaAnggota().getText());
    anggota.setAlamat(view.getTxtAlamat().getText());
    anggota.setJeniskelamin(view.getCboJenisKelamin()
              .getSelectedItem().toString());
    dao.update(anggota);
    JOptionPane.showMessageDialog(view,"update Data Ok");
}catch (Exception ex){
    JOptionPane.showMessageDialog(view, ex.getMessage());
    Logger.getLogger(AnggotaController.class .getName()).log(Level.SEVERE,null,ex);
}
}

}

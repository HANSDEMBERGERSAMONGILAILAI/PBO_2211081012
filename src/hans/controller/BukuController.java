/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.controller;
import hans.model.*;
import hans.dao.*;
import hans.db.DbHelperr;
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
public class BukuController {
    FormBuku view;
    Buku buku;
    BukuDao dao;
    Connection con;
    
    public BukuController(FormBuku view) {
        try {
            this.view = view;
            con = DbHelperr.getConnection();
            dao = new BukuDaoImpl(con);
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearForm(){
        view.getTxtkodebuku().setText("");
        view.getTxtjudulbuku().setText("");
        view.getTxtpengarang().setText("");
        view.getTxtPenerbit().setText("");
        
    }

    
public void tampil(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel)
                    view .getTabelBuku().getModel();
            tableModel.setRowCount(0);
            List<Buku> list = dao.getAll();
            for (Buku a : list) {
                Object[] row ={
                    a.getkodebuku(),
                    a.getjudulbuku(),
                    a.getpengarang(),
                    a.getpenerbit()
                };
                tableModel.addRow(row);
            }       
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);       
        }
}
public void Insert(){
    try {
    buku = new Buku();
    buku.setkodebuku(view.getTxtkodebuku().getText());
    buku.setjudulbuku(view.getTxtjudulbuku().getText());
    buku.setpengarang(view.getTxtpengarang().getText());
    buku.setpenerbit(view.getTxtPenerbit().getText());
    dao.insert(buku);
    JOptionPane.showMessageDialog(view,"Entri Data Ok");
}catch (Exception ex){
    JOptionPane.showMessageDialog(view, ex.getMessage());
    Logger.getLogger(BukuController.class .getName()).log(Level.SEVERE,null,ex);
}
}
public void delete(){
    try{
        
        dao.delete(buku);
        JOptionPane.showMessageDialog(view,"Delete data Ok");
    }catch(Exception ex){
        Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
    }
}
public void tabelKlik(){
    try {
    String kodebuku = view.getTabelBuku().getValueAt(view.getTabelBuku().getSelectedRow(),0).toString();
    buku = dao.getBuku(kodebuku);
    view.getTxtkodebuku().setText(buku.getkodebuku());
    view.getTxtjudulbuku().setText(buku.getjudulbuku());
    view.getTxtpengarang().setText(buku.getpengarang());
    view.getTxtPenerbit().setText(buku.getpenerbit());
} catch (Exception ex) {
    Logger.getLogger(BukuController.class .getName()).log(Level.SEVERE,null,ex);
}
}
public void update(){
    try {
    buku.setkodebuku(view.getTxtkodebuku().getText());
    buku.setjudulbuku(view.getTxtjudulbuku().getText());
    buku.setpengarang(view.getTxtpengarang().getText());
    buku.setpenerbit(view.getTxtPenerbit().getText());
    dao.update(buku);
    JOptionPane.showMessageDialog(view,"update Data Ok");
}catch (Exception ex){
    JOptionPane.showMessageDialog(view, ex.getMessage());
    Logger.getLogger(BukuController.class .getName()).log(Level.SEVERE,null,ex);
}
}

}


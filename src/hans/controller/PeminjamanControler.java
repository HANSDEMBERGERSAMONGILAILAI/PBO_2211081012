/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.controller;

import hans.dao.AnggotaDao;
import hans.dao.AnggotaDaoImpl;
import hans.dao.BukuDao;
import hans.dao.BukuDaoImpl;
import hans.dao.PeminjamanDao;
import hans.dao.PeminjamanDaoImpl;
import hans.db.DbHelper;
import hans.model.Anggota;
import hans.model.Buku;
import hans.model.Peminjaman;
import hans.view.FormPeminjaman;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PeminjamanControler {
    FormPeminjaman form;
    Peminjaman p;
    PeminjamanDao pdao;
    AnggotaDao adao;
    BukuDao bdao;
    
    public PeminjamanControler(FormPeminjaman form){
        
        try {
            this.form = form;
            pdao = new PeminjamanDaoImpl(DbHelper.getConnection());
            adao = new AnggotaDaoImpl(DbHelper.getConnection());
            bdao =new BukuDaoImpl(DbHelper.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void bersihform() {
        form.getTxttglkembali().setText(" ");
        form.getTxttglpinjam().setText(" ");
    }
    
    public void isicomboanggota() {
        try {
            form.getCbokodeanggota().removeAllItems();
            List<Anggota> list= adao.getAll();
            for(Anggota a: list){
                form.getCbokodeanggota().addItem(a.getKodeanggota()+"-"+a.getNamaanggota());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isicombobuku() {
        try {
            form.getCbokodebuku().removeAllItems();
            List<Buku> list= bdao.getAll();
            for(Buku b: list){
                form.getCbokodebuku().addItem(b.getkodebuku()+"-"+b.getjudulbuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            p =new Peminjaman();
            Anggota a = adao.getAnggota(form.getCbokodeanggota().getSelectedItem().toString().split("-")[0]);
            p.setA(a);
            Buku b = bdao.getBuku(form.getCbokodebuku().getSelectedItem().toString().split("-" )[0]);
            p.setB(b);
            p.setTglpinjam(form.getTxttglpinjam().getText());
            p.setTglkembali(form.getTxttglkembali().getText());
            pdao.insert(p);
            JOptionPane.showMessageDialog(form, "Entri data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Entri data OK");
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Update(){
        try {
            
            Anggota a = adao.getAnggota(form.getCbokodeanggota().getSelectedItem().toString().split("-")[0]);
            p.setA(a);
            Buku b = bdao.getBuku(form.getCbokodebuku().getSelectedItem().toString().split("-" )[0]);
            p.setB(b);
            p.setTglpinjam(form.getTxttglpinjam().getText());
            p.setTglkembali(form.getTxttglkembali().getText());
            pdao.update(p);
            JOptionPane.showMessageDialog(form, "Updaet data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Update data OK");
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public void delet(){
        try {
            pdao.delete(p);
            JOptionPane.showMessageDialog(form, "Delete OK");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getpeminjaman(){
        try {
            String kodeanggota =form.getTabelPeminjaman()
                    .getValueAt(form.getTabelPeminjaman().getSelectedRow(),0).toString();
            String kodebuku =form.getTabelPeminjaman()
                    .getValueAt(form.getTabelPeminjaman().getSelectedRow(),2).toString();
            String tglpinjam =form.getTabelPeminjaman()
                    .getValueAt(form.getTabelPeminjaman().getSelectedRow(),4).toString();
            
            p = pdao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            Anggota a= adao.getAnggota(p.getA().getKodeanggota());
            form.getCbokodeanggota().setSelectedItem(a.getKodeanggota()+"-"+a.getNamaanggota());
            Buku b= bdao.getBuku(p.getB().getkodebuku());
            form.getCbokodebuku().setSelectedItem(b.getkodebuku()+"-"+b.getjudulbuku());
            form.getTxttglpinjam().setText(p.getTglpinjam());
            form.getTxttglkembali().setText(p.getTglkembali());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tableModel =(DefaultTableModel) form.getTabelPeminjaman().getModel();
            tableModel.setRowCount(0);
            List<Peminjaman> list = pdao.getAll();
            for(Peminjaman p: list){
                Anggota a= adao.getAnggota(p.getA().getKodeanggota());
                Buku b = bdao.getBuku(p.getB().getkodebuku());
                Object[] row = {
                    a.getKodeanggota(),
                    a.getNamaanggota(),
                    b.getkodebuku(),
                    b.getjudulbuku(),
                    p.getTglpinjam(),
                    p.getTglkembali()
                    
                
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

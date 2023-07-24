/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.controller;
import hans.dao.*;
import hans.model.*;
import hans.view.*;
import hans.db.DbHelper;
import hans.model.Anggota;
import hans.model.Buku;
import hans.model.Pengembalian;
import hans.view.FormPengembalian;
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
public class PengembalianController {
    FormPengembalian form;
    Pengembalian p;
    Pengembaliandao pdao;
    PeminjamanDao peminjamanDao;
   
   
    public PengembalianController(FormPengembalian form){
        
        try {
            this.form = form;
            pdao = new PengembaliandaoImpl(DbHelper.getConnection());
           
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void bersihform() {
        form.getTxttglkembali().setText(" ");
        form.getTxttglpinjam().setText(" ");
        form.getTxttglkembali().setText(" ");
    }
    
    public void isicomboanggota() {
        try {
            form.getCbokodeanggota().removeAllItems();
            List<Peminjaman> list= peminjamanDao.getAll();
            for(Peminjaman peminjaman: list){
                form.getCbokodeanggota().addItem(peminjaman.getA()
                        .getKodeanggota()+"-"+peminjaman.getA().getNamaanggota());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isicombobuku() {
        try {
            form.getCbokodebuku().removeAllItems();
            List<Peminjaman> list= peminjamanDao.getAll();
            for(Peminjaman peminjaman: list){
                form.getCbokodebuku().addItem(peminjaman.getB()
                        .getkodebuku()+"-"+peminjaman.getB().getjudulbuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            p =new Pengembalian();
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(form.getCbokodeanggota().
                    getSelectedItem().toString().split(" ")[0],
                    form.getCbokodebuku().getSelectedItem().toString().split(" ")[0],
                    form.getTxttglpinjam().getText());
            p.setP(peminjaman);
            p.setTgldikembalikan(form.getTxttglkembali().getText());
            pdao.insert(p);
            JOptionPane.showMessageDialog(form, "Entri data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Entri data OK");
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Update(){
        try {
            
           Peminjaman peminjaman = peminjamanDao.getPeminjaman(form.getCbokodeanggota().
                    getSelectedItem().toString().split(" ")[0],
                    form.getCbokodebuku().getSelectedItem().toString().split(" ")[0],
                    form.getTxttglpinjam().getText());
            p.setP(peminjaman);
            p.setTgldikembalikan(form.getTxttglkembali().getText());
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
    
    public void getpengembalian(){
        try {
            String kodeanggota =form.getTabelPengembalian()
                    .getValueAt(form.getTabelPengembalian().getSelectedRow(),0).toString();
            String kodebuku =form.getTabelPengembalian()
                    .getValueAt(form.getTabelPengembalian().getSelectedRow(),2).toString();
            String tglpinjam =form.getTabelPengembalian()
                    .getValueAt(form.getTabelPengembalian().getSelectedRow(),4).toString();
            
            p = pdao.getPengembalian(kodeanggota, kodebuku, tglpinjam);
            Peminjaman peminjaman= peminjamanDao.getPeminjaman(p.getP().getA().getKodeanggota(),
                    p.getP().getB().getkodebuku(),
                    p.getP().getTglpinjam());
            form.getCbokodeanggota().setSelectedItem(peminjaman.getA().getKodeanggota()+"-"+peminjaman.getA().getNamaanggota());
            form.getCbokodebuku().setSelectedItem(peminjaman.getB().getkodebuku()+"-"+peminjaman.getB().getjudulbuku());
            form.getTxttglpinjam().setText(p.getP().getTglpinjam());
            form.getTxttglkembali().setText(p.getTgldikembalikan());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tableModel =(DefaultTableModel) form.getTabelPengembalian().getModel();
            tableModel.setRowCount(0);
            List<Pengembalian> list = pdao.getAll();
            for(Pengembalian pengembalian: list){
                Peminjaman peminjaman= peminjamanDao.getPeminjaman(p.getP().getA()
                        .getKodeanggota(),p.getP().getB()
                        .getkodebuku(),p.getP().getTglpinjam());
                
                Object[] row = {
                    peminjaman.getA().getKodeanggota(),
                    peminjaman.getA().getNamaanggota(),
                    peminjaman.getB().getkodebuku(),
                    peminjaman.getB().getjudulbuku(),
                    peminjaman.getTglpinjam(),
                    peminjaman.getTglkembali(),
                    p.getTgldikembalikan(),
                    p.getTerlambat(),
                    p.getDenda()
                    
                
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



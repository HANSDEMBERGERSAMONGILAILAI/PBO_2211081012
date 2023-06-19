/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.dao;
import hans.model.Buku;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class BukuDaoImpl implements BukuDao{
    private Connection connection;
    
    public BukuDaoImpl (Connection connection){
        this.connection = connection;
        
    }

    public void insert (Buku buku) throws Exception{
        String sql = "insert into buku values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, buku.getkodebuku());
        ps.setString(2, buku.getjudulbuku());
        ps.setString(3, buku.getpengarang());
        ps.setString(4, buku.getpenerbit());
        ps.executeUpdate();
        ps.close();
    }
    public void update(Buku buku) throws Exception{
        String sql = "UPDATE buku SET judulbuku =?, pengarang = ?, penerbit =? "
                +"WHERE kodebuku =?";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setString(4,buku.getkodebuku());
        ps.setString(1,buku.getjudulbuku());
        ps.setString(2,buku.getpengarang());
        ps.setString(3,buku.getpenerbit());
        ps.executeUpdate();
        //ps.close();
        
    }
    
    public void delete (Buku buku) throws Exception{
        String sql = "DELETE FROM buku WHERE kodebuku =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,buku.getkodebuku());
        ps.executeUpdate();
        ps.close();
    }
    
    public Buku getBuku(String kodebuku) throws Exception{
        String sql ="Select * FROM buku WHERE kodebuku =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodebuku);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if(rs.next()){
           buku = new Buku();
           buku.setkodebuku(rs.getString(1));
           buku.setjudulbuku(rs.getString(2));
           buku.setpengarang(rs.getString(3));
           buku.setpenerbit(rs.getString(4));
        }
        return buku;
        
    }
    public List<Buku>getAll() throws Exception{
         String sql ="Select * FROM buku ";
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         Buku buku;
         List<Buku>list = new ArrayList<>();
             while(rs.next()){
                 buku = new Buku();
                 buku.setkodebuku(rs.getString(1));
                 buku.setjudulbuku(rs.getString(2));
                 buku.setpengarang(rs.getString(3));
                 buku.setpenerbit(rs.getString(4));
                 list.add(buku);
             }
        return list;
    }
}


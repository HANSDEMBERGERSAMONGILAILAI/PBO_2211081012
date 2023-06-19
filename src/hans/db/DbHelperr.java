/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import hans.dao.BukuDao;
import hans.dao.BukuDaoImpl;
import hans.model.Buku;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DbHelperr {
     private static Connection connection;
    
    public  static Connection getConnection()throws SQLException{
        if(connection==null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/pbo_2211081012");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            
        }
        return connection;
        
    }
    public static void main(String[] args){
        try{
            connection = DbHelperr.getConnection();
            BukuDaoImpl dao = new BukuDaoImpl(connection);
            Buku buku = new Buku("A002", "pancingan", "saya","mu");
            dao.insert(buku);
            JOptionPane.showMessageDialog(null, "Koneksi Ok");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}



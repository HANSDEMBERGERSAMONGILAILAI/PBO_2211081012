/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hans.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import hans.dao.*;
import hans.model.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DbHelper {
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
            connection = DbHelper.getConnection();
            AnggotaDao dao = new AnggotaDaoImpl(connection);
            Anggota anggota = new Anggota("A002", "hans dem", "mentawai pagsel","L");
            dao.insert(anggota);
            JOptionPane.showMessageDialog(null, "Koneksi Ok");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

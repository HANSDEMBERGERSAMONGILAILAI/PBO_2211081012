/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger080423;

/**
 *
 * @author HP
 */
public class ExtendStudent {
    public static void main(String[] args) {
        // membuat objek dari kelas StudentRecord
        StudentRecord student = new StudentRecord("hans dem", "123 Main Street");
        
        // memanggil method print untuk menampilkan informasi siswa
        student.print(80, 90, 85);
        
        // memanggil method getStudentCount untuk menampilkan jumlah siswa
        System.out.println("Total Students: " + StudentRecord.getStudentCount());
    }
}


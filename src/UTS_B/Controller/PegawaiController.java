/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_B.Controller;
import UTS_B.View.FormPegawai;
import UTS_B.Model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class PegawaiController {
    private String golongan;
    private String tanggal;
    private double gajiPokok;
    private double tunjanganAnak;
    private double tunjanganIstri;

    public PegawaiController(String golongan, String tanggal) {
        this.golongan = golongan;
        this.tanggal = tanggal;
        this.gajiPokok = 0;
        this.tunjanganAnak = 0;
        this.tunjanganIstri = 0;
    }

    public void hitungGaji() {
        if (golongan.equals("IIIA")) {
            gajiPokok = 1000000;
        } else if (golongan.equals("IIIB")) {
            gajiPokok = 2000000;
        } else if (golongan.equals("IIIC")) {
            gajiPokok = 3000000;
        }

        tunjanganIstri = 0.05 * gajiPokok;
        tunjanganAnak = 0.05 * gajiPokok;
    }

    public double getGajiBersih() {
        return gajiPokok + tunjanganIstri + tunjanganAnak;
    }

    // Getter dan setter lainnya
}

public class PegawaiController {
    private List<Pegawai> listPegawai;

    public PegawaiController() {
        listPegawai = new ArrayList<>();
    }

    public void bersihForm() {
        // Mengosongkan form atau melakukan reset nilai-nilai input
        // sesuai dengan kebutuhan Anda
    }

    public void savePegawai(Pegawai pegawai) {
        // Menyimpan data pegawai ke dalam listPegawai atau database
        listPegawai.add(pegawai);
    }

    public Pegawai getPegawai(int index) {
        // Mendapatkan data pegawai berdasarkan indeks
        if (index >= 0 && index < listPegawai.size()) {
            return listPegawai.get(index);
        }
        return null;
    }

    public void updatePegawai(int index, Pegawai newData) {
        // Memperbarui data pegawai berdasarkan indeks dengan data baru
        if (index >= 0 && index < listPegawai.size()) {
            listPegawai.set(index, newData);
        }
    }

    public void deletePegawai(int index) {
        // Menghapus data pegawai berdasarkan indeks
        if (index >= 0 && index < listPegawai.size()) {
            listPegawai.remove(index);
        }
    }

    public void tampilData() {
        // Menampilkan data pegawai
        for (int i = 0; i < listPegawai.size(); i++) {
            Pegawai pegawai = listPegawai.get(i);
            System.out.println("Data Pegawai ke-" + (i + 1));
            System.out.println("Golongan: " + pegawai.getGolongan());
            System.out.println("Tanggal: " + pegawai.getTanggal());
            System.out.println("Gaji Pokok: " + pegawai.getGajiPokok());
            System.out.println("Tunjangan Istri: " + pegawai.getTunjanganIstri());
            System.out.println("Tunjangan Anak: " + pegawai.getTunjanganAnak());
            System.out.println("Gaji Bersih: " + pegawai.getGajiBersih());
            System.out.println();
        }
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hansdemberger02042023;

/**
 *
 * @author HP
 */
public class BukuAlamat {
    public static void main(String[] args) {
        BukuAlamat bukuAlamat = new BukuAlamat();
        bukuAlamat.tambahData(new DataAlamat("hans dem", "Jl. Merdeka No. 10", "08123456789", "hans.dem@gmail.com"));
        bukuAlamat.tambahData(new DataAlamat("ka je", "Jl. Sudirman No. 20", "08234567890", "ka.je@gmail.com"));
        bukuAlamat.tampilkanData();
    }
    private DataAlamat[] data;
    private int count;

    public BukuAlamat() {
        data = new DataAlamat[100];
        count = 0;
    }

    public void tambahData(DataAlamat newData) {
        if (count < 100) {
            data[count] = newData;
            count++;
        } else {
            System.out.println("Buku alamat sudah penuh");
        }
    }

    public void hapusData(String nama) {
        int index = cariIndex(nama);
        if (index != -1) {
            for (int i = index; i < count-1; i++) {
                data[i] = data[i+1];
            }
            count--;
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    public void tampilkanData() {
        if (count == 0) {
            System.out.println("Buku alamat kosong");
        } else {
            for (int i = 0; i < count; i++) {
                DataAlamat d = data[i];
                System.out.println("Nama    : " + d.getNama());
                System.out.println("Alamat  : " + d.getAlamat());
                System.out.println("Telepon : " + d.getTelepon());
                System.out.println("Email   : " + d.getEmail());
                System.out.println("------------------------------------");
            }
        }
    }

    public void updateData(String nama, String alamat, String telepon, String email) {
        int index = cariIndex(nama);
        if (index != -1) {
            data[index].setAlamat(alamat);
            data[index].setTelepon(telepon);
            data[index].setEmail(email);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    private int cariIndex(String nama) {
        for (int i = 0; i < count; i++) {
            if (data[i].getNama().equals(nama)) {
                return i;
            }
        }
        return -1;
    }
}


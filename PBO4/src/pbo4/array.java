/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo4;

import java.text.SimpleDateFormat;
import java.util.*;


public class array {
    private final java.util.ArrayList<String> nama = new java.util.ArrayList();
    private final java.util.ArrayList<String> NIM = new java.util.ArrayList();
    private final java.util.ArrayList<Integer> jk = new java.util.ArrayList();
    private final java.util.ArrayList<Date> tl = new java.util.ArrayList();
    Scanner in = new Scanner(System.in);
    
    void menu(){
        OUTER:
        while (true) {
            System.out.println("------------------");
            System.out.println("    Olah Data");
            System.out.println("------------------");
            System.out.println("Menu :");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data(menggunakan NIM)");
            System.out.println("3. Cari Data");
            System.out.println("4. Tampil Data");
            System.out.println("5. Keluar");
            System.out.print("Pilihan menu anda : ");
            String menu = in.next();
            switch (menu) {
                case "1":
                    {
                        System.out.println("-------------------");
                        System.out.println("    Tambah Data");
                        System.out.println("-------------------");
                        System.out.println("Masukkan Data yang akan ditambahkan");
                        System.out.print("Nama : ");
                        String name = in.next();
                        System.out.print("NIM  : ");
                        String nomor = in.next();
                        System.out.println("Tanggal Lahir: ");
                        System.out.print("Tahun: ");
                        int tahun = in.nextInt();
                        System.out.print("Bulan: ");
                        int bulan = in.nextInt();
                        System.out.print("Tanggal: ");
                        int hari = in.nextInt();
                        Date tanggal = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
                        System.out.print("Jenis Kelamin (0: Laki-laki atau 1: Perempuan)  : ");
                        int gdr = in.nextInt();
                        nama.add(name);
                        NIM.add(nomor);
                        tl.add(tanggal);
                        jk.add(gdr);
                        System.out.println("Data telah ditambahkan");
                        break;
                    }
                case "2":
                    {
                        System.out.println("------------------");
                        System.out.println("    Hapus Data");
                        System.out.println("------------------");
                        System.out.println("Masukkan NIM yang akan dihapus");
                        System.out.print("NIM : ");
                        String nomor = in.next();
                        int index = Collections.binarySearch(NIM, nomor);
                        nama.remove(index);
                        NIM.remove(index);
                        tl.remove(index);
                        jk.remove(index);
                        break;
                    }
                case "3":
                    System.out.println("-----------------");
                    System.out.println("    Cari Data");
                    System.out.println("-----------------");
                    System.out.println("1. Cari data berdasarkan jenis kelamin");
                    System.out.println("2. Cari data berdasarkan NIM");
                    System.out.print("Pilihan anda : ");
                    int pilihan = in.nextInt();
                    if (pilihan == 1){
                        System.out.println("-------------------------");
                        System.out.println("Berdasarkan Jenis Kelamin");
                        System.out.println("-------------------------");
                        System.out.print("Pilih gender (0 / 1) : ");
                        int gend = in.nextInt();
                        
                        for ( int i = 0; i < nama.size(); i++) {
                            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
                            if (jk.get(i) == 0){
                                System.out.println("Nama : " + nama.get(i));
                                System.out.println("NIM : " + NIM.get(i));
                                System.out.println("Tanggal Lahir : " + format.format(tl.get(i)));
                                System.out.println("Gender : " + jk.get(i));
                                System.out.println("-----------------------");
                            } else if (jk.get(i) == 1){
                                System.out.println("Nama : " + nama.get(i));
                                System.out.println("NIM : " + NIM.get(i));
                                System.out.println("Tanggal Lahir : " + format.format(tl.get(i)));
                                System.out.println("Gender : " + jk.get(i));
                                System.out.println("-----------------------");
                            }
                        }
                    } else if (pilihan == 2){
                        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
                        System.out.println("------------------");
                        System.out.println("Berdasarkan NIM");
                        System.out.println("------------------");
                        System.out.print("Masukkan NIM : ");
                        String nomor = in.next();
                        
                        int index = Collections.binarySearch(NIM, nomor);
                        String cariNama = nama.get(index);
                        String cariNIM = NIM.get(index);
                        Date cariTanggal = tl.get(index);
                        int cariJenisKelamin = jk.get(index);
                        
                        System.out.println("Nama : " + cariNama);
                        System.out.println("NIM : " + cariNIM);
                        System.out.println("Tanggal Lahir : " + format.format(cariTanggal));
                        System.out.println("Gender : " + cariJenisKelamin);
                    }   break;
                case "4":
                    System.out.println("------------------");
                    System.out.println("Tampilkan Data");
                    System.out.println("------------------");
                    for ( int i = 0; i < nama.size(); i++) {
                        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
                        System.out.println("Nama : " + nama.get(i));
                        System.out.println("NIM : " + NIM.get(i));
                        System.out.println("Tanggal Lahir : " + format.format(tl.get(i)));
                        System.out.println("Gender : " + jk.get(i));
                        System.out.println("-----------------------");
                    }   System.out.println("Jumlah mahasiswa : " + nama.size());
                    break;
                    
                case "5":
                    break OUTER;
                
            }
        }
    }

}

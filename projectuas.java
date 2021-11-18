/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Acer
 */
public class projectuas {

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();
    static Scanner sc = new Scanner(System.in);
    static Scanner cs = new Scanner(System.in);
    static String[] namaKota = {"Kota Batu", "Kota Blitar", "Kota Surabaya", "Kota Pasuruan", "Kota Kediri",
        "Kota Madiun", "Kota Mojokerto", "Kota Probolinggo", "Kabupaten Pacitan", "Kabupaten Ponorogo", "Kabupaten Trenggalek",
        "Kabupaten Tulungagung", "Kabupaten Blitar", "Kabupaten Kediri", "Kabupaten Malang", "Kabupaten Lumajang", "Kabupaten Jember",
        "Kabupaten Banyuwangi", "Kabupaten Bondowoso", "Kabupaten Situbondo", "Kabupaten Probolinggo", "Kabupaten Pasuruan",
        "Kabupaten Sidoarjo", "Kabupaten Mojokerto", "Kabupaten Jombang", "Kabupaten Nganjuk", "Kabupaten Madiun", "Kabupaten Magetan",
        "Kabupaten Ngawi", "Kabupaten Bojonegoro", "Kabupaten Tuban", "Kabupaten Lamongan", "Kabupaten Gresik", "Kabupaten Bangkalan", "Kabupaten Sampang",
        "Kabupaten Pamekasan", "Kabupaten Sumenep"};

    static int a = 0, ongkir = 7000, berat, layanan, uang, saldo = 0, member, pos, pack, biayaTambah = 0, asuransi;
    static String kota, namaPeng, namaPen, alamat, des, layanana, packaging, asuransia;

    static int total(int a, int b) {
        int A;

        A = a * b;

        return A;
    }

    static void daftarKota() {

        for (int j = 0; j < namaKota.length; j++) {
            System.out.println("- " + namaKota[j]);
        }
    }

    static void ekspedisi() {
        int kode = 0;
        System.out.println("Apakah Anda Member Dhani Express? 1 = ya, 0 = tidak");
        member = cs.nextInt();

        if (member == 1) {

            int konf;
            do {
                System.out.println("Masukkan Kode Member : ");
                kode = cs.nextInt();
            } while (kode != 17102000);

            do {
                System.out.println("Masukkan Nama Pengirim : ");
                namaPeng = sc.next();

                System.out.println("Masukkan Nama Penerima : ");
                namaPen = sc.next();

                System.out.println("Masukkan Kota Tujuan : ");
                kota = sc.next();

                System.out.println("Masukkan Kecamatan Penerima : ");
                alamat = sc.next();

                System.out.println("Masukkan Kode Pos : ");
                pos = cs.nextInt();

                System.out.println("Masukkan Deskripsi Barang : ");
                des = cs.next();

                System.out.println("Masukkan Berat Barang (Kg): ");
                berat = sc.nextInt();

                System.out.println("Pilih Jenis layanan : ");
                System.out.println("1. Reguler");
                System.out.println("2. Express");
                layanan = sc.nextInt();
                if (layanan == 1) {
                    biayaTambah += 0;
                    layanana = "Reguler";
                } else {
                    biayaTambah += 5000;
                    layanana = "Express";
                }
                System.out.println("Pilih Packaging : ");
                System.out.println("1. Bubble Wrap");
                System.out.println("2. Kayu");
                pack = cs.nextInt();
                if (pack == 1) {
                    biayaTambah += 0;
                    packaging = "Bubble Wrap";
                } else {
                    biayaTambah += 10000;
                    packaging = "Kayu";
                }
                System.out.println("Apakah Anda Ingin Menggunakan Asuransi? 1 = ya, 0 = tidak");
                asuransi = cs.nextInt();
                if (asuransi == 1) {
                    biayaTambah += 10000;
                    asuransia = "Ya";
                } else {
                    biayaTambah += 0;
                    asuransia = "Tidak";
                }

                System.out.println("++====================================++");
                System.out.println("++=======<<<KON F I R M ASI>>>========++");
                System.out.println("++====================================++");
                System.out.println("||Nama Pengirim     : " + namaPeng);
                System.out.println("||Nama Penerima     : " + namaPen);
                System.out.println("||Alamat Penerima   : " + kota + ", " + alamat);
                System.out.println("||Kode Pos          : " + pos);
                System.out.println("||Deskripsi Barang  : " + des);
                System.out.println("||Berat Barang      : " + berat + "Kg");
                System.out.println("||Layanan           : " + layanana);
                System.out.println("||Packaging         : " + packaging);
                System.out.println("||Asuransi          : " + asuransia);
                System.out.println("++====================================++");

                System.out.println("Apakah Data Tersebut Sudah Benar? 1 = ya, 0 = tidak");
                konf = cs.nextInt();
            } while (konf == 0);
            double diskon = (total(berat, ongkir)+ biayaTambah) * 0.1;
            double jmlTotal = total(berat, ongkir)+ biayaTambah - diskon;
            System.out.println("Total Biaya Ongkos Kirim Anda adalah : Rp. " + jmlTotal);

            System.out.println("Masukkan Jumlah Uang Anda : ");
            uang = cs.nextInt();

            double sisa = uang - jmlTotal;
            int konf2;
            System.out.println("Sisa Uang Anda adalah : Rp. " + sisa);
            System.out.println("Apakah Anda Mau Memasukkan Sisa Uang ke Saldo Anda? 1 = ya, 0 = tidak");
            konf2 = cs.nextInt();
            if (konf2 == 1) {
                saldo += sisa;
            } else {
                saldo += 0;
            }
            System.out.println("++====================================++");
            System.out.println("++>>>>>>>>>>>>> R E S I <<<<<<<<<<<<<<++");
            System.out.println("++>>>>>>> P E N G I R I M A N <<<<<<<<++");
            System.out.println("++====================================++");
            System.out.println("||Nama Pengirim     : " + namaPeng);
            System.out.println("||Nama Penerima     : " + namaPen);
            System.out.println("||Alamat Penerima   : " + kota + alamat);
            System.out.println("||Kode Pos          : " + pos);
            System.out.println("||Deskripsi Barang  : " + des);
            System.out.println("||Berat Barang      : " + berat + "Kg");
            System.out.println("||Layanan           : " + layanana);
            System.out.println("||Packaging         : " + packaging);
            System.out.println("||Asuransi          : " + asuransia);
            System.out.println("||Diskon            : Rp. " + diskon);
            System.out.println("||Biaya Ongkos Kirim: Rp. " + jmlTotal);
            System.out.println("---------------------------------------");
            System.out.println("||Nomor Resi        : 000" + pos);
            System.out.println("---------------------------------------");
            System.out.println("||Saldo Member      : Rp. " + saldo);
            System.out.println("++====================================++");
            System.out.println("++>>>>>>>>>^^Dhani Express^^<<<<<<<<<<++");
            System.out.println("++>>>>>>>>>" + formatter.format(date) + "<<<<<<<<++");
            System.out.println("++====================================++");
        } else {

            int konf;

            do {
                System.out.println("Masukkan Nama Pengirim : ");
                namaPeng = sc.next();

                System.out.println("Masukkan Nama Penerima : ");
                namaPen = sc.next();

                System.out.println("Masukkan Kota Tujuan : ");
                kota = sc.next();

                System.out.println("Masukkan Kecamatan Penerima : ");
                alamat = cs.next();

                System.out.println("Masukkan Kode Pos : ");
                pos = cs.nextInt();

                System.out.println("Masukkan Deskripsi Barang : ");
                des = cs.next();

                System.out.println("Masukkan Berat Barang (Kg): ");
                berat = sc.nextInt();

                System.out.println("Pilih Jenis layanan : ");
                System.out.println("1. Reguler");
                System.out.println("2. Express");
                layanan = sc.nextInt();
                if (layanan == 1) {
                    biayaTambah += 0;
                    layanana = "Reguler";
                } else {
                    biayaTambah += 5000;
                    layanana = "Express";
                }
                System.out.println("Pilih Packaging : ");
                System.out.println("1. Bubble Wrap");
                System.out.println("2. Kayu");
                pack = cs.nextInt();
                if (pack == 1) {
                    biayaTambah += 0;
                    packaging = "Bubble Wrap";
                } else {
                    biayaTambah += 10000;
                    packaging = "Kayu";
                }
                System.out.println("Apakah Anda Ingin Menggunakan Asuransi? 1 = ya, 0 = tidak");
                asuransi = cs.nextInt();
                if (asuransi == 1) {
                    biayaTambah += 10000;
                    asuransia = "Ya";
                } else {
                    biayaTambah += 0;
                    asuransia = "Tidak";
                }

                System.out.println("++====================================++");
                System.out.println("++=======<<<KON F I R M ASI>>>========++");
                System.out.println("++====================================++");
                System.out.println("||Nama Pengirim     : " + namaPeng);
                System.out.println("||Nama Penerima     : " + namaPen);
                System.out.println("||Alamat Penerima   : " + kota + ", " + alamat);
                System.out.println("||Kode Pos          : " + pos);
                System.out.println("||Deskripsi Barang  : " + des);
                System.out.println("||Berat Barang      : " + berat + "Kg");
                System.out.println("||Layanan           : " + layanana);
                System.out.println("||Packaging         : " + packaging);
                System.out.println("||Asuransi          : " + asuransia);
                System.out.println("++====================================++");

                System.out.println("Apakah Data Tersebut Sudah Benar? 1 = ya, 0 = tidak");
                konf = cs.nextInt();
            } while (konf == 0);

            int jmlTotal = total(berat, ongkir) + biayaTambah;
            System.out.println("Total Biaya Ongkos Kirim Anda adalah : Rp. " + jmlTotal);

            System.out.println("Masukkan Jumlah Uang Anda : Rp. ");
            uang = cs.nextInt();

            double sisa = uang - jmlTotal;

            System.out.println("Sisa Uang Anda adalah : Rp. " + sisa);

            System.out.println("++====================================++");
            System.out.println("++>>>>>>>>>>>>> R E S I <<<<<<<<<<<<<<++");
            System.out.println("++>>>>>>> P E N G I R I M A N <<<<<<<<++");
            System.out.println("++====================================++");
            System.out.println("||Nama Pengirim         : " + namaPeng);
            System.out.println("||Nama Penerima         : " + namaPen);
            System.out.println("||Alamat Penerima       : " + kota + ", " + alamat);
            System.out.println("||Kode Pos              : " + pos);
            System.out.println("||Deskripsi Barang      : " + des);
            System.out.println("||Berat Barang          : " + berat + " Kg");
            System.out.println("||Layanan               : " + layanana);
            System.out.println("||Packaging             : " + packaging);
            System.out.println("||Asuransi              : " + asuransia);
            System.out.println("||Biaya Ongkos Kirim    : " + "Rp. " + jmlTotal);
            System.out.println("---------------------------------------");
            System.out.println("||Nomor Resi            : 000" + pos);
            System.out.println("---------------------------------------");
            System.out.println("++====================================++");
            System.out.println("++>>>>>>>>>^^Dhani Express^^<<<<<<<<<<++");
            System.out.println("++>>>>>>>>>" + formatter.format(date) + "<<<<<<<<++");
            System.out.println("++====================================++");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("++=========================================++");
        System.out.println("||==== Selamat Datang di Dhani Express ====||");
        System.out.println("||Kurir Ekspedisi Terpercaya di Kota Malang||");
        System.out.println("++=========================================++");

        System.out.println("++=========================================++");
        System.out.println("Pilih Jenis Barang yang Akan Dikirim : ");
        System.out.println("1. Benda Keras");
        System.out.println("2. Benda Lunak");
        System.out.println("++=========================================++");
        a = sc.nextInt();

        System.out.println("++=========================================++");
        System.out.println("Berikut Daftar Kota/Kabupaten Tujuan : ");
        daftarKota();
        System.out.println("++=========================================++");
        if (a == 1) {
            ekspedisi();

        } else if (a == 2) {
            ekspedisi();
        }
    }
}
// TODO code application logic here


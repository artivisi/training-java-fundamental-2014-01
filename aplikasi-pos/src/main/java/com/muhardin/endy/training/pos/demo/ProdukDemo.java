package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.math.BigDecimal;
import java.util.Date;

public class ProdukDemo {

    public static void main(String[] args) {
        Produk.setJumlahStok(100);
        System.out.println("Jumlah Stok : " + Produk.getJumlahStok());

        String kode; // deklarasi
        kode = "P-001"; // inisialisasi
        Produk p = new Produk(); // deklarasi + inisialisasi
        p.setId(102);
        p.setKode("P-003");
        p.setNama("Produk 002");
        p.setHarga(new BigDecimal("130000.00"));
        p.setTanggalKadaluarsa(new Date());
        p.setJumlahStok(10);

        Integer idx = p.getId();
        System.out.println("ID Produk " + idx);
        System.out.println("Kode Produk " + p.getKode());
        System.out.println("Nama Produk " + p.getNama());
        System.out.println("Harga Produk " + p.getHarga());
        System.out.println("Tanggal Kadaluarsa Produk " + p.getTanggalKadaluarsa());

        Produk p2 = new Produk();
        p2.setId(200);
        p2.setJumlahStok(20);


    
        ProdukDao pd = new ProdukDao();
        pd.simpan(p);
    }
}

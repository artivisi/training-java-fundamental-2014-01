package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.math.BigDecimal;
import java.util.Date;

public class ProdukDemo {
    public static void main(String[] args) {
        Produk.setJumlahStok(100);
        System.out.println("Jumlah Stok : "+Produk.getJumlahStok());
        
        String kode; // deklarasi
        kode = "P-001"; // inisialisasi
        Produk p = new Produk(); // deklarasi + inisialisasi
        p.setId(100);
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150000.00"));
        p.setTanggalKadaluarsa(new Date());
        p.setJumlahStok(10);
        
        Integer idx = p.getId();
        System.out.println("ID Produk "+idx);
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        System.out.println("Tanggal Kadaluarsa Produk "+p.getTanggalKadaluarsa());
        
        Produk p2 = new Produk();
        p2.setId(200);
        p2.setJumlahStok(20);
        
        System.out.println("ID p2 : "+p2.getId());
        System.out.println("ID p : "+p.getId());
        
        System.out.println("Jumlah stok p2 "+p2.getJumlahStok());
        System.out.println("Jumlah stok p "+p.getJumlahStok());

        System.out.println("Jumlah stok "+Produk.getJumlahStok());
        ///---------
        
        ProdukDao ex = new ProdukDao();
        ex.simpan(p);
        
        
    }
}

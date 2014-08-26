package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Produk;
import java.math.BigDecimal;
import java.util.Date;

public class ProdukDemo {
    public static void main(String[] args) {
        Produk p = new Produk();
        p.setId(100);
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150000.00"));
        p.setTanggalKadaluarsa(new Date());
        
        System.out.println("ID Produk "+p.getId());
        System.out.println("Kode Produk "+p.getKode());
        System.out.println("Nama Produk "+p.getNama());
        System.out.println("Harga Produk "+p.getHarga());
        System.out.println("Tanggal Kadaluarsa Produk "+p.getTanggalKadaluarsa());
        
    }
}

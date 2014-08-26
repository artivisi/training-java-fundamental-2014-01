package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ProdukDaoDemo {
    public static void main(String[] args) {
        Produk p = new Produk(); // deklarasi + inisialisasi
        p.setId(new Random().nextInt());
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal("150000.00"));
        p.setTanggalKadaluarsa(new Date());
        
        
        ProdukDao pd = new ProdukDao();
        pd.simpan(p);
        
        Produk px = pd.cariById(p.getId());
        displayProduk(px);
        
        System.out.println("=====================");
        List<Produk> semua = pd.semuaProduk();
        for (Produk produk : semua) {
            displayProduk(produk);
        }
        System.out.println("=====================");
    }

    private static void displayProduk(Produk px) {
        System.out.println("ID : "+px.getId());
        System.out.println("Kode : "+px.getKode());
        System.out.println("Nama : "+px.getNama());
        System.out.println("Harga : "+px.getHarga());
        System.out.println("Tanggal Kadaluarsa : "+px.getTanggalKadaluarsa());
    }
}

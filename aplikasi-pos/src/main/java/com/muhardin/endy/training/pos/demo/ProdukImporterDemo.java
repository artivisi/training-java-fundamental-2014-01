package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Produk;
import com.muhardin.endy.training.pos.importer.ProdukImporter;
import java.io.File;
import java.util.List;

public class ProdukImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/produk.csv");
        
        ProdukImporter pi = new ProdukImporter();
        
        List<Produk> hasil = pi.importFile(f);
        System.out.println("======== Hasil : "+hasil.size()+" records ===========");
        for (Produk produk : hasil) {
            System.out.println("ID : "+produk.getId());
            System.out.println("Kode : "+produk.getKode());
            System.out.println("Nama : "+produk.getNama());
            System.out.println("Harga : "+produk.getHarga());
            System.out.println("Tanggal : "+produk.getTanggalKadaluarsa());
        }
    }
}

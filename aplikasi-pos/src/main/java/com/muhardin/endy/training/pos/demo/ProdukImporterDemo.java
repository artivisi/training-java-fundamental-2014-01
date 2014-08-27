package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Produk;
import com.muhardin.endy.training.pos.importer.HasilImportProduk;
import com.muhardin.endy.training.pos.importer.ImportError;
import com.muhardin.endy.training.pos.importer.ProdukImporter;
import java.io.File;

public class ProdukImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/produk.csv");
        
        ProdukImporter pi = new ProdukImporter();
        
        HasilImportProduk hasil = pi.importFile(f);
        System.out.println("======== Sukses : "+hasil.getData().size()+" records ===========");
        for (Produk produk : hasil.getData()) {
            System.out.println("ID : "+produk.getId());
            System.out.println("Kode : "+produk.getKode());
            System.out.println("Nama : "+produk.getNama());
            System.out.println("Harga : "+produk.getHarga());
            System.out.println("Tanggal : "+produk.getTanggalKadaluarsa());
        }
        
        System.out.println("=========== Gagal : "+hasil.getDaftarError().size()+" baris ========");
        for (ImportError err : hasil.getDaftarError()) {
            System.out.println("Baris : "+err.getBaris());
            System.out.println("Keterangan : "+err.getKeterangan());
            System.out.println("Data : "+err.getData());
        }
    }
}

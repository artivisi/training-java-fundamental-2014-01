package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;
import com.muhardin.endy.training.pos.importer.GudangImporter;
import com.muhardin.endy.training.pos.importer.HasilImportGudang;
import com.muhardin.endy.training.pos.importer.ImportError;
import java.io.File;

public class GudangImporterDemo {
    public static void main(String[] args) {
        File f = new File("src/main/resources/gudang.csv");

        GudangImporter gi = new GudangImporter();
        
        HasilImportGudang hasil = gi.importFile(f);
        System.out.println("======== Hasil : " + hasil.getDaftarError().size() + " records ===========");
        for (Gudang gudang : hasil.getData()) {
            System.out.println("ID Gudang     =  " + gudang.getId());
            System.out.println("Kode Gudang   =  " + gudang.getKodeGudang());
            System.out.println("Nama Gudang   =  " + gudang.getNamaGudang());
            System.out.println("Alamat Gudang =  " + gudang.getAlamatGudang());
            System.out.println("Nama Barang   =  " + gudang.getNamaBarang());
            System.out.println("Stock Barang  =  " + gudang.getStokBarang());

            System.out.println("=========== Gagal : " + hasil.getDaftarError().size() + " baris ========");
            for (ImportError err : hasil.getDaftarError()) {
                System.out.println("Baris : " + err.getBaris());
                System.out.println("Keterangan : " + err.getKeterangan());
                System.out.println("Data : " + err.getData());
            }
            GudangDao gd = new GudangDao();
            gd.simpan(gudang);
        }
    }
}

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;
import com.muhardin.endy.training.pos.importer.GudangImporter;
import java.io.File;
import java.util.List;

public class GudangImporterDemo {

    public static void main(String[] args) {
        File f = new File("src/main/resources/gudang.csv");

        GudangImporter gi = new GudangImporter();

        List<Gudang> hasil = gi.importFile(f);
        System.out.println("======== Hasil : " + hasil.size() + " records ===========");
        for (Gudang gudang : hasil) {
            System.out.println("ID Gudang     =  " + gudang.getId());
            System.out.println("Kode Gudang   =  " + gudang.getKodeGudang());
            System.out.println("Nama Gudang   =  " + gudang.getNamaGudang());
            System.out.println("Alamat Gudang =  " + gudang.getAlamatGudang());
            System.out.println("Nama Barang   =  " + gudang.getNamaBarang());
            System.out.println("Stock Barang  =  " + gudang.getStokBarang());

            GudangDao gd = new GudangDao();
            gd.simpan(gudang);
        }
    }
}

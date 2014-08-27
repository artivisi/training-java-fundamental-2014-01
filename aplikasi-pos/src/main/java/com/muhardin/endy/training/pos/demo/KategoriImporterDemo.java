/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Kategori;
import com.muhardin.endy.training.pos.importer.KategoriImporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class KategoriImporterDemo {

    public static void main(String[] args) {
        File f = new File("src/main/resources/kategori.csv");

        KategoriImporter pi = new KategoriImporter();

        List<Kategori> hasil = pi.importFile(f);
        System.out.println("======== Hasil : " + hasil.size() + " records ===========");
        for (Kategori kategori : hasil) {
            System.out.println("ID : " + kategori.getId());
            System.out.println("Kode : " + kategori.getKode());
            System.out.println("Nama : " + kategori.getNama());
            System.out.println("Definisi : " + kategori.getDefinisi());
        }
    }
}

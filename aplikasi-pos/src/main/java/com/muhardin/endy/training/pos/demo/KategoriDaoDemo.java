/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.KategoriDao;
import com.muhardin.endy.training.pos.domain.Kategori;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ceisa-djbc
 */
public class KategoriDaoDemo {

    public static void main(String[] args) {
        Kategori k = new Kategori(); // deklarasi + inisialisasi
        k.setId(new Random().nextInt());
        k.setKode("K-002");
        k.setNama("terpopuler");
        k.setDefinisi("uye");

        KategoriDao kd = new KategoriDao();
        kd.simpan(k);

        Kategori kx = kd.cariById(k.getId());
        displayKategori(kx);

        System.out.println("=====================");
        List<Kategori> semua = kd.semuaKategori();
        for (Kategori kategori : semua) {
            displayKategori(kategori);
        }
        System.out.println("=====================");
    }

    private static void displayKategori(Kategori kx) {
        System.out.println("ID : " + kx.getId());
        System.out.println("Kode : " + kx.getKode());
        System.out.println("Nama : " + kx.getNama());
        System.out.println("Definisi : " + kx.getDefinisi());
    }
}

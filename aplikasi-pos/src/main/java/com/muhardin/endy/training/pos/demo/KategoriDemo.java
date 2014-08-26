/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.KategoriDao;
import com.muhardin.endy.training.pos.domain.Kategori;

/**
 *
 * @author ceisa-djbc
 */
public class KategoriDemo {

    public static void main(String[] args) {
        Kategori k = new Kategori();
        k.setId(100);
        k.setKode("K-001");
        k.setNama("Terlaris");
        k.setDefinisi("Panglaris-panglaris");

        System.out.println("ID Kategori" + k.getId());
        System.out.println("Kode Kategori" + k.getKode());
        System.out.println("Nama Kategori" + k.getNama());
        System.out.println("Nama Kategori" + k.getDefinisi());
        
        KategoriDao kd = new KategoriDao();
        kd.simpan(k);
    }
}

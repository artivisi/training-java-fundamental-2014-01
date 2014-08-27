/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA3
 */
public class GudangDaoDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gudang g = new Gudang(); // deklarasi + inisialisasi
        g.setId(new Random().nextInt());
        g.setKodeGudang("GD0");
        g.setNamaGudang("GudangKe");
        g.setAlamatGudang("Jl.Gudang No");
        g.setNamaBarang("LaptopKe");
        g.setStokBarang(150);

        GudangDao gd = new GudangDao();
        gd.simpan(g);

        Gudang gx = gd.cariByID(g.getId());
        displayGudang(gx);

        System.out.println("=====================");
        List<Gudang> semua = gd.semuaGudang();
        
        for (Gudang gudang : semua) {
            displayGudang(gudang);
        }
        System.out.println("=====================");
    }

    private static void displayGudang(Gudang gx) {
            System.out.println("ID Gudang     =  " + gx.getId());
            System.out.println("Kode Gudang   =  " + gx.getKodeGudang());
            System.out.println("Nama Gudang   =  " + gx.getNamaGudang());
            System.out.println("Alamat Gudang =  " + gx.getAlamatGudang());
            System.out.println("Nama Barang   =  " + gx.getNamaBarang());
            System.out.println("Stock Barang  =  " + gx.getStokBarang());
    }
}

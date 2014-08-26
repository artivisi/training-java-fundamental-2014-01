/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;

/**
 *
 * @author Lenovo
 */
public class GudangDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gudang g = new Gudang();
        for (int i = 1; i <= 10; i++) {
            g.setId(i);
            g.setKodeGudang("GD0" + i);
            g.setNamaGudang("GudangKe" + i);
            g.setAlamatGudang("Jl.Gudang No" + i);
            g.setNamaBarang("LaptopKe" + i);
            g.setStokBarang(i);

            System.out.println("ID Gudang     =  " + g.getId());
            System.out.println("Kode Gudang   =  " + g.getKodeGudang());
            System.out.println("Nama Gudang   =  " + g.getNamaGudang());
            System.out.println("Alamat Gudang =  " + g.getAlamatGudang());
            System.out.println("Nama Barang   =  " + g.getNamaBarang());
            System.out.println("Stock Barang  =  " + g.getStokBarang());

            System.out.println("--------------------------------------");

            GudangDao gd = new GudangDao();
            gd.simpan(g);
        }
    }
}

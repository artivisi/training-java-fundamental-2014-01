/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.KantorCabangDao;
import com.muhardin.endy.training.pos.domain.KantorCabang;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangDemo {
    public static void main(String[] args) {
        KantorCabang kc = new KantorCabang();
        kc.setId_kantorCbg(new Random().nextInt());
        kc.setKode_kantorCbg("KC");
        kc.setNama_kantorCbg("KPPBC");
        kc.setAlamat_kantorCbg("Jawa Barat");
        kc.setNoTelp_kantorCbg("022-7123456");
        kc.setNamaKepala_kantorCbg("Bapak Dadang");
    
        KantorCabangDao kcd = new KantorCabangDao();
        kcd.simpan(kc);
        
        KantorCabang kcx = kcd.cariById(kc.getId_kantorCbg());
        displayKantorCabang(kcx);
        
        System.out.println("=====================");
        List<KantorCabang> semua = kcd.semuaKantorCabang();
        for (KantorCabang kantorCabang : semua) {
        displayKantorCabang(kantorCabang);
        }
        System.out.println("=====================");
    }

    private static void displayKantorCabang(KantorCabang kcx) {
        System.out.println("ID Kantor Cabang : "+kcx.getId_kantorCbg());
        System.out.println("Kode : "+kcx.getKode_kantorCbg());
        System.out.println("Nama : "+kcx.getNama_kantorCbg());
        System.out.println("Alamat : "+kcx.getAlamat_kantorCbg());
        System.out.println("No. Telepon : "+kcx.getNoTelp_kantorCbg());
        System.out.println("Nama Kepala : "+kcx.getNamaKepala_kantorCbg());
    }
}

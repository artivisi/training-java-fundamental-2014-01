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
    
        System.out.println("ID Kantor Cabang : "+kc.getId_kantorCbg());
        System.out.println("Kode : "+kc.getKode_kantorCbg());
        System.out.println("Nama : "+kc.getNama_kantorCbg());
        System.out.println("Alamat : "+kc.getAlamat_kantorCbg());
        System.out.println("No. Telepon : "+kc.getNoTelp_kantorCbg());
        System.out.println("Nama Kepala : "+kc.getNamaKepala_kantorCbg());
        
        KantorCabangDao kcd = new KantorCabangDao();
        kcd.simpan(kc);
    }
}

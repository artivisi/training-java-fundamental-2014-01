/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.KantorCabangDao;
import com.muhardin.endy.training.pos.domain.KantorCabang;

/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangDemo {
    public static void main(String[] args) {
        KantorCabang kc = new KantorCabang();
        for (int i=1;i<=10;i++){
        kc.setId_kantorCbg(i);
        kc.setKode_kantorCbg("KC"+i);
        kc.setNama_kantorCbg("KPPBC"+i);
        kc.setAlamat_kantorCbg("Jawa Barat"+i);
        kc.setNoTelp_kantorCbg("022-7123456"+i);
        kc.setNamaKepala_kantorCbg("Dadang"+i);
        }
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

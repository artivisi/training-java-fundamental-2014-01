/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.KantorCabang;
import com.muhardin.endy.training.pos.importer.KantorCabangImporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangImporterDemo {
     public static void main(String[] args) {
        File f = new File("src/main/resources/kantorcabang.csv");

        KantorCabangImporter pi = new KantorCabangImporter();

        List<KantorCabang> hasil = pi.importFile(f);
        System.out.println("======== Hasil : " + hasil.size() + " records ===========");
        for (KantorCabang kantorCabang : hasil) {
            System.out.println("ID : " + kantorCabang.getId_kantorCbg());
            System.out.println("Kode : " + kantorCabang.getKode_kantorCbg());
            System.out.println("Nama : " + kantorCabang.getNama_kantorCbg());
            System.out.println("Alamat : " + kantorCabang.getAlamat_kantorCbg());
            System.out.println("No. Telepeon : " + kantorCabang.getNoTelp_kantorCbg());
            System.out.println("Kepala Kantor : " + kantorCabang.getNamaKepala_kantorCbg());
        }
    }
}

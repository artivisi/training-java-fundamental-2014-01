/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.dao.KantorCabangDao;
import com.muhardin.endy.training.pos.domain.KantorCabang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangImporter {
     public List<KantorCabang> importFile(File f) {
        List<KantorCabang> hasil = new ArrayList<KantorCabang>();
        try {

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();

            if (data == null) {
                System.out.println("Tidak ada data");
                return null;
            }

            while ((data = br.readLine()) != null) {
                System.out.println("Data : " + data);
                String[] baris = data.split(",");
                if (baris.length != 4) {
                    System.out.println("Data invalid, hanya ada " + baris.length + " field");
                    continue;
                }
                KantorCabang kc = new KantorCabang();
                kc.setId_kantorCbg(Integer.parseInt(baris[0]));
                kc.setKode_kantorCbg(baris[1]);
                kc.setNama_kantorCbg(baris[2]);
                kc.setAlamat_kantorCbg(baris[3]);
                kc.setNoTelp_kantorCbg(baris[4]);
                kc.setNamaKepala_kantorCbg(baris[5]);
                hasil.add(kc);

                KantorCabangDao kcd = new KantorCabangDao();
                kcd.simpan(kc);
            }

            System.out.println("Selesai membaca file");
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
     }
}

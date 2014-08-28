/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.exporter;
import com.muhardin.endy.training.pos.dao.KantorCabangDao;
import com.muhardin.endy.training.pos.domain.KantorCabang;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangExporter {
     public File exportKeCsv(String namaFile){
        try {
            File tujuan = new File(namaFile);
            
            KantorCabangDao kcd = new KantorCabangDao();
            List<KantorCabang> data = kcd.semuaKantorCabang();
            
            FileWriter writer = new FileWriter(tujuan);
            // tulis header dulu
            writer.write("id_kantorCbg,kode_kantorCbg,nama_kantorCbg,alamat_kantorCbg,noTelp_kantorCbg,namaKepala_kantorCbg\r\n");
            
            for (KantorCabang kantorCabang : data) {
                writer.write(kantorCabang.getId_kantorCbg().toString());
                writer.write(",");
                writer.write(kantorCabang.getKode_kantorCbg());
                writer.write(",");
                writer.write(kantorCabang.getNama_kantorCbg());
                writer.write(",");
                writer.write(kantorCabang.getAlamat_kantorCbg());
                writer.write(",");
                writer.write(kantorCabang.getNoTelp_kantorCbg());
                writer.write(",");
                writer.write(kantorCabang.getNamaKepala_kantorCbg());
                writer.write(",");
                writer.write("\r\n");
            }
            
            writer.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(KategoriExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

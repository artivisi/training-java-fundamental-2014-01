/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.exporter;

import com.muhardin.endy.training.pos.dao.KategoriDao;
import com.muhardin.endy.training.pos.domain.Kategori;
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
 * @author ceisa-djbc
 */
public class KategoriExporter {
    public File exportKeCsv(String namaFile){
        try {
            File tujuan = new File(namaFile);
            
            KategoriDao pd = new KategoriDao();
            List<Kategori> data = pd.semuaKategori();
            
            FileWriter writer = new FileWriter(tujuan);
            // tulis header dulu
            writer.write("id,kode,nama,definisi\r\n");
            
            for (Kategori kategori : data) {
                writer.write(kategori.getId().toString());
                writer.write(",");
                writer.write(kategori.getKode());
                writer.write(",");
                writer.write(kategori.getNama());
                writer.write(",");
                writer.write(kategori.getDefinisi());
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

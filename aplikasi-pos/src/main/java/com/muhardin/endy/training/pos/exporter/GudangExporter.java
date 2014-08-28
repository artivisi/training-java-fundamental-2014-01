/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.exporter;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;
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
 * @author CEISA3
 */
public class GudangExporter {
    public File exportKeCsv(String namaFile){
        try {
            File tujuan = new File(namaFile);
            
            GudangDao pd = new GudangDao();
            List<Gudang> data = pd.semuaGudang();
            
            FileWriter writer = new FileWriter(tujuan);
            // tulis header dulu
            writer.write("id,kode,nama,harga,tanggalKadaluarsa\r\n");
            
            SimpleDateFormat formatterTanggal = new SimpleDateFormat("dd-MM-yyyy");
            NumberFormat formatterAngka = NumberFormat.getInstance();
            
            for (Gudang gudang : data) {
                writer.write(gudang.getId().toString());
                writer.write(",");
                writer.write(gudang.getKodeGudang());
                writer.write(",");
                writer.write(gudang.getNamaGudang());
                writer.write(",");
                writer.write(gudang.getAlamatGudang());
                writer.write(",");
                writer.write(gudang.getNamaBarang());
                writer.write(",");
                writer.write(formatterAngka.format(gudang.getStokBarang()));
                writer.write(",");
                
            }
            
            writer.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(ProdukExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
//
//                writer.write(gudang.getId().toString());
//                writer.write(",");
//                writer.write(gudang.getKodeGudang());
//                writer.write(",");
//                writer.write(gudang.getNamaGudang());
//                writer.write(",");
//                                writer.write(gudang.getAlamatGudang());
//                writer.write(",");
//                                writer.write(gudang.getNamaBarang()};
//                writer.write(",");
//                writer.write(formatterAngka.format(gudang.get()));
//                writer.write(",");
//                writer.write(formatterTanggal.format(produk.getTanggalKadaluarsa()));
//                writer.write("\r\n");
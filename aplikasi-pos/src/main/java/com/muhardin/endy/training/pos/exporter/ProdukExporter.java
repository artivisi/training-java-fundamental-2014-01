package com.muhardin.endy.training.pos.exporter;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdukExporter {
    public File exportKeCsv(String namaFile){
        try {
            File tujuan = new File(namaFile);
            
            ProdukDao pd = new ProdukDao();
            List<Produk> data = pd.semuaProduk();
            
            FileWriter writer = new FileWriter(tujuan);
            // tulis header dulu
            writer.write("id,kode,nama,harga,tanggalKadaluarsa\r\n");
            
            SimpleDateFormat formatterTanggal = new SimpleDateFormat("dd-MM-yyyy");
            NumberFormat formatterAngka = NumberFormat.getInstance();
            
            for (Produk produk : data) {
                writer.write(produk.getId().toString());
                writer.write(",");
                writer.write(produk.getKode());
                writer.write(",");
                writer.write(produk.getNama());
                writer.write(",");
                writer.write(formatterAngka.format(produk.getHarga()));
                writer.write(",");
                writer.write(formatterTanggal.format(produk.getTanggalKadaluarsa()));
                writer.write("\r\n");
            }
            
            writer.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(ProdukExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

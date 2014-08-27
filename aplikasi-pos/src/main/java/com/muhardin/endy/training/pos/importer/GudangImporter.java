package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Gudang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GudangImporter {

    public HasilImportGudang importFile(File f) {
        List<Gudang> dataGudang = new ArrayList<Gudang>();
        HasilImportGudang hasil = new HasilImportGudang();
        hasil.setData(dataGudang);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();

            Integer noBaris = 1;

            if (data == null) {
                System.out.println("Tidak ada data");
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            while ((data = br.readLine()) != null) {
                noBaris++;
                System.out.println("Data : " + data);
                String[] baris = data.split(",");
                
                if (baris.length != 6) {
                    System.out.println("Data invalid, hanya ada " + baris.length + " field");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Jumlah field salah, seharusnya 6, tapi ternyata " + baris.length);
                    hasil.getDaftarError().add(err);
                    continue;
                }
                
                Gudang g = new Gudang();
                g.setId(Integer.parseInt(baris[0]));
                g.setKodeGudang(baris[1]);
                g.setNamaGudang(baris[2]);
                g.setAlamatGudang(baris[3]);
                g.setNamaBarang(baris[4]);
                
                try {
                    g.setStokBarang(Integer.parseInt(baris[5]));
                } 
                catch (NumberFormatException ex) {
                    System.out.println("Gagal parsing Stok Barang");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Informasi harga harus angka semua");
                    hasil.getDaftarError().add(err);
                    ex.printStackTrace();
                    continue;
                }

                    dataGudang.add(g);
                
            }
            System.out.println("Selesai membaca file");
                br.close();
           
        }
         catch (Exception e) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, e);
        }
             return hasil;
    }
   
}

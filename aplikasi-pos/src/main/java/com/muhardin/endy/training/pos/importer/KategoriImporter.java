/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.dao.KategoriDao;
import com.muhardin.endy.training.pos.domain.Kategori;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc
 */
public class KategoriImporter {

    public HasilImportKategori importFile(File f) {
        List<Kategori> dataKategori = new ArrayList<Kategori>();
        HasilImportKategori hasil = new HasilImportKategori();
        hasil.setData(dataKategori);
        try {

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();

            Integer noBaris = 1;

            if (data == null) {
                System.out.println("Tidak ada data");
                return null;
            }

            while ((data = br.readLine()) != null) {
                noBaris++;
                System.out.println("Data : " + data);
                String[] baris = data.split(",");
                if (baris.length != 4) {
                    System.out.println("Data invalid, hanya ada " + baris.length + " field");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Jumlah field salah, seharusnya 4, tapi ternyata " + baris.length);
                    hasil.getDaftarError().add(err);
                    continue;
                }
                Kategori k = new Kategori();
                k.setId(Integer.parseInt(baris[0]));
                k.setKode(baris[1]);
                k.setNama(baris[2]);
                k.setDefinisi(baris[3]);
<<<<<<< HEAD
                hasil.add(k);

                KategoriDao kd = new KategoriDao();
                kd.simpan(k);
=======
                dataKategori.add(k);

//                KategoriDao kd = new KategoriDao();
//                kd.simpan(k);
>>>>>>> aba47c60fffa14c22b0ab247d368642611ca5934
            }

            System.out.println("Selesai membaca file");
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Gudang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GudangImporter {

    public List<Gudang> importFile(File f) {
        List<Gudang> hasil = new ArrayList<Gudang>();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();

            if (data == null) {
                System.out.println("Tidak ada data");
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            while ((data = br.readLine()) != null) {
                System.out.println("Data : " + data);
                String[] baris = data.split(",");
                if (baris.length != 6) {
                    System.out.println("Data invalid, hanya ada " + baris.length + " field");
                    continue;
                }
                Gudang g = new Gudang();
                g.setId(Integer.parseInt(baris[0]));
                g.setKodeGudang(baris[1]);
                g.setNamaGudang(baris[2]);
                g.setAlamatGudang(baris[3]);
                g.setNamaBarang(baris[4]);
                g.setStokBarang(Integer.parseInt(baris[5]));
                hasil.add(g);
            }

            System.out.println("Selesai membaca file");
            br.close();
        } catch (Exception e) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }
}

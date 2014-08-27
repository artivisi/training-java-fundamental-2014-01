package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Produk;
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

public class ProdukImporter {
    public List<Produk> importFile(File f){
        List<Produk> hasil = new ArrayList<Produk>();
        try {
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            
            if(data == null){
                System.out.println("Tidak ada data");
                return null;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            while((data = br.readLine()) != null){
                System.out.println("Data : "+data);
                String[] baris = data.split(",");
                if(baris.length != 5){
                    System.out.println("Data invalid, hanya ada "+baris.length+" field");
                    continue;
                }
                Produk p = new Produk();
                p.setId(Integer.parseInt(baris[0]));
                p.setKode(baris[1]);
                p.setNama(baris[2]);
                p.setHarga(new BigDecimal(baris[3]));
                try {
                    p.setTanggalKadaluarsa(formatter.parse(baris[4]));
                } catch (ParseException ex) {
                    System.out.println("Gagal parsing tanggal");
                    ex.printStackTrace();
                }
                hasil.add(p);
            }
            
            System.out.println("Selesai membaca file");
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

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
     public HasilImportProduk importFile(File f){
        
        List<Produk> dataProduk = new ArrayList<Produk>();
        HasilImportProduk hasil = new HasilImportProduk();
        hasil.setData(dataProduk);
        try {
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            
            Integer noBaris = 1;
            
            if(data == null){
                System.out.println("Tidak ada data");
                return null;
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            while((data = br.readLine()) != null){
                noBaris++;
                System.out.println("Data : "+data);
                String[] baris = data.split(",");
                if(baris.length != 5){
                    System.out.println("Data invalid, hanya ada "+baris.length+" field");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Jumlah field salah, seharusnya 5, tapi ternyata "+baris.length);
                    hasil.getDaftarError().add(err);
                    continue;
                }
                Produk p = new Produk();
                p.setId(Integer.parseInt(baris[0]));
                p.setKode(baris[1]);
                p.setNama(baris[2]);
                try {
                    p.setHarga(new BigDecimal(baris[3]));
                    p.setTanggalKadaluarsa(formatter.parse(baris[4]));
                } catch (ParseException ex) {
                    System.out.println("Gagal parsing tanggal");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Format tanggal salah, harusnya dd-MM-yyyy");
                    hasil.getDaftarError().add(err);
                    ex.printStackTrace();
                    continue;
                } catch (NumberFormatException ex){
                    System.out.println("Gagal parsing harga");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Informasi harga harus angka semua");
                    hasil.getDaftarError().add(err);
                    ex.printStackTrace();
                    continue;
                }
                dataProduk.add(p);
            }
            
            System.out.println("Selesai membaca file");
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

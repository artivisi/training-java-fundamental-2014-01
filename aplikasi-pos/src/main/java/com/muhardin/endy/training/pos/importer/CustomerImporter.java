package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Customer;
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

public class CustomerImporter {
    public List<Customer> importFile(File f){
        List<Customer> hasil = new ArrayList<Customer>();
        try{
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
                
                Customer c = new Customer();
                c.setIdCsr(Integer.parseInt(baris[0]));
                c.setKodeCsr(baris[1]);
                c.setNamaCsr(baris[2]);
                c.setAlamatCsr(baris[3]);
                try {
                    c.setTanggalDaftar(formatter.parse(baris[4]));
                } catch (ParseException ex) {
                    System.out.println("Gagal parsing tanggal");
                    ex.printStackTrace();
                }
                hasil.add(c);
            }
            
            System.out.println("Selesai membaca file");
            br.close();
    }catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

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
    public HasilImportCustomer importFile(File f){
        
        List<Customer> dataCustomer = new ArrayList<Customer>();
        HasilImportCustomer hasil = new HasilImportCustomer();
        hasil.setData(dataCustomer);
        try{
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
                
                Customer c = new Customer();
                c.setIdCsr(Integer.parseInt(baris[0]));
                c.setKodeCsr(baris[1]);
                c.setNamaCsr(baris[2]);
                c.setAlamatCsr(baris[3]);
                try {
                    c.setTanggalDaftar(formatter.parse(baris[4]));
                } catch (ParseException ex) {
                    System.out.println("Gagal parsing tanggal");
                    ImportError err = new ImportError();
                    err.setBaris(noBaris);
                    err.setData(data);
                    err.setKeterangan("Format tanggal salah, harusnya dd-MM-yyyy");
                    hasil.getDaftarError().add(err);
                    ex.printStackTrace();
                    continue;
                }
                dataCustomer.add(c);
            }
            
            System.out.println("Selesai membaca file");
            br.close();
    }catch (IOException ex) {
            Logger.getLogger(CustomerImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

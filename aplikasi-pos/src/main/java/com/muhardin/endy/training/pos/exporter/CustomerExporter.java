package com.muhardin.endy.training.pos.exporter;

import com.muhardin.endy.training.pos.dao.CustomerDao;
import com.muhardin.endy.training.pos.domain.Customer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerExporter {
    public File exportKeCsv(String namaFile){
        try{
        File tujuan = new File(namaFile);
        
        CustomerDao cd = new CustomerDao();
        List<Customer> data = cd.semuaCustomer();
        
        FileWriter writer = new FileWriter(tujuan);
         // tulis header dulu
        writer.write("idCsr,kodeCsr,namaCsr,alamatCsr,tanggalDaftar\r\n");
        
        SimpleDateFormat formatterTanggal = new SimpleDateFormat("dd-MM-yyyy");
        NumberFormat formatterAngka = NumberFormat.getInstance();
        
            for (Customer customer : data) {
                writer.write(customer.getIdCsr().toString());
                writer.write(",");
                writer.write(customer.getKodeCsr());
                writer.write(",");
                writer.write(customer.getNamaCsr());
                writer.write(",");
                writer.write(customer.getAlamatCsr());
                writer.write(",");
                writer.write(formatterTanggal.format(customer.getTanggalDaftar()));
                writer.write("\r\n");
            }
            
            writer.close();
            
            return tujuan;
        } catch (IOException ex) {
            Logger.getLogger(CustomerExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

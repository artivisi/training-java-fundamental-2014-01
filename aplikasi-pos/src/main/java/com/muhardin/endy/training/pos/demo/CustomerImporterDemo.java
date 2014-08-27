package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Customer;
import com.muhardin.endy.training.pos.importer.CustomerImporter;
import com.muhardin.endy.training.pos.importer.HasilImportCustomer;
import com.muhardin.endy.training.pos.importer.ImportError;
import java.io.File;
import java.util.List;

public class CustomerImporterDemo {
    public static void main(String[] args) {
       File f = new File("src/main/resources/customer.csv");
        
        CustomerImporter ci = new CustomerImporter();
        
        HasilImportCustomer hasil = ci.importFile(f);
        System.out.println("======== Hasil : "+hasil.getData().size()+" records ===========");
        for (Customer customer : hasil.getData()) {
            System.out.println("ID : "+customer.getIdCsr());
            System.out.println("Kode Csr : "+customer.getKodeCsr());
            System.out.println("Nama Csr : "+customer.getNamaCsr());
            System.out.println("Alamat Csr : "+customer.getAlamatCsr());
            System.out.println("Tanggal : "+customer.getTanggalDaftar());
        }
        System.out.println("=========== Gagal : "+hasil.getDaftarError().size()+" baris ========");
        for (ImportError err : hasil.getDaftarError()) {
            System.out.println("Baris : "+err.getBaris());
            System.out.println("Keterangan : "+err.getKeterangan());
            System.out.println("Data : "+err.getData());
        }
    }
    
}

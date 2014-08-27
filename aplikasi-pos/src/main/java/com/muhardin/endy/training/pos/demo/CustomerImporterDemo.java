package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Customer;
<<<<<<< HEAD
import com.muhardin.endy.training.pos.domain.Produk;
import com.muhardin.endy.training.pos.importer.CustomerImporter;
import com.muhardin.endy.training.pos.importer.ProdukImporter;
=======
import com.muhardin.endy.training.pos.importer.CustomerImporter;
import com.muhardin.endy.training.pos.importer.HasilImportCustomer;
import com.muhardin.endy.training.pos.importer.ImportError;
>>>>>>> aba47c60fffa14c22b0ab247d368642611ca5934
import java.io.File;
import java.util.List;

public class CustomerImporterDemo {
    public static void main(String[] args) {
       File f = new File("src/main/resources/customer.csv");
        
        CustomerImporter ci = new CustomerImporter();
        
<<<<<<< HEAD
        List<Customer> hasil = ci.importFile(f);
        System.out.println("======== Hasil : "+hasil.size()+" records ===========");
        for (Customer customer : hasil) {
=======
        HasilImportCustomer hasil = ci.importFile(f);
        System.out.println("======== Hasil : "+hasil.getData().size()+" records ===========");
        for (Customer customer : hasil.getData()) {
>>>>>>> aba47c60fffa14c22b0ab247d368642611ca5934
            System.out.println("ID : "+customer.getIdCsr());
            System.out.println("Kode Csr : "+customer.getKodeCsr());
            System.out.println("Nama Csr : "+customer.getNamaCsr());
            System.out.println("Alamat Csr : "+customer.getAlamatCsr());
            System.out.println("Tanggal : "+customer.getTanggalDaftar());
<<<<<<< HEAD
        } 
=======
        }
        System.out.println("=========== Gagal : "+hasil.getDaftarError().size()+" baris ========");
        for (ImportError err : hasil.getDaftarError()) {
            System.out.println("Baris : "+err.getBaris());
            System.out.println("Keterangan : "+err.getKeterangan());
            System.out.println("Data : "+err.getData());
        }
>>>>>>> aba47c60fffa14c22b0ab247d368642611ca5934
    }
    
}

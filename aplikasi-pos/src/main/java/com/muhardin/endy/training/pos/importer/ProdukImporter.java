package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Produk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            
            while((data = br.readLine()) != null){
                System.out.println("Data : "+data);
            }
            
            System.out.println("Selesai membaca file");
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProdukImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Region;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class RegionImport {
    public List<Region> importFile(File f){
       List<Region> hasil = new ArrayList<Region>();
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String data = br.readLine();
            
                if(data == null){
                    System.out.println("Tidak ada data");
                    return null;
                }  
                SimpleDateFormat tanggalan = new SimpleDateFormat("dd-MM-yyyy");
                 while((data = br.readLine()) != null){
                    System.out.println("Data : "+data);
                    String[] baris = data.split(",");
                //    if(baris.length != 7){
                //    System.out.println("Data invalid, hanya ada "+baris.length+" field");
                //    continue;
                //      }
              //      hasil.add(p);
                    
                    Region reg= new Region();
                    reg.setId(Integer.parseInt(baris[0]));
                    reg.setIdRegion(baris[1]);
                    reg.setDesa(baris[5]);
                      try {
                            reg.setCreated(tanggalan.parse(baris[6]));
                        } 
                      catch (ParseException ex) {
                            System.out.println("Gagal parsing tanggal");
                            ex.printStackTrace();
                        }
                    hasil.add(reg);
                 }
            }
            catch(IOException ex){
                
            }
        return hasil;
    }
}

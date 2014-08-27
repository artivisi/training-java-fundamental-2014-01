/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.exporter;

import com.muhardin.endy.training.pos.dao.RegionDao;
import com.muhardin.endy.training.pos.domain.Region;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceisa-djbc
 */
public class RegionExporter {
    public File exportCSV(String namaFile) {
    try{
        File tujuan = new File(namaFile);
        
        RegionDao regDao = new RegionDao();
        List<Region> data = regDao.semuaRegion();
        
        FileWriter writer = new FileWriter(tujuan);
        writer.write("id,idregion,provinsi,kota,kecamatan,desa,created\r\n");
        
        SimpleDateFormat formatterTanggal = new SimpleDateFormat("dd-MM-yyyy");
        
        for (Region region : data) {
            writer.write(region.getId()+","+region.getIdRegion()+","
                                           +region.getProvinsi()+","
                                           +region.getKota()+","
                                           +region.getKecamatan()+","
                                           +region.getDesa()+","            
                                           +formatterTanggal.format(region.getCreated())+"\r\n");
        }
        
          writer.close();
    }
    catch(IOException ex){
        Logger.getLogger(RegionExporter.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
}

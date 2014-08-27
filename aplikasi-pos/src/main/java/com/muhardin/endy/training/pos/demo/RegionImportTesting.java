/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.RegionDao;
import com.muhardin.endy.training.pos.domain.Region;
import com.muhardin.endy.training.pos.importer.RegionImport;
import java.io.File;
import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class RegionImportTesting {
    public static void main(String[] args) {
        File f = new File("src/main/resources/region.csv");
        
        RegionImport impor = new RegionImport();
        RegionDao dao = new RegionDao();
        List<Region> hasil = impor.importFile(f);
        System.out.println("======== Hasil : "+hasil.size()+" records ===========");
        for (Region region : hasil) {
            shoutout(region);
            dao.simpan(region);
            
        }
    }

    private static void shoutout(Region region) {
        System.out.println("ID "+region.getId());
        System.out.println("Kode "+region.getIdRegion());
        System.out.println("Provinsi "+region.getProvinsi());
        System.out.println("Kota "+region.getKota());
        System.out.println("Kecamatan "+region.getKecamatan());
        System.out.println("Desa "+region.getDesa());
        System.out.println("Tanggal buat "+region.getCreated());
    }
}

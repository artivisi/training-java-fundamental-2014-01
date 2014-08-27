package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.RegionDao;
import com.muhardin.endy.training.pos.domain.Region;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RegionTest {

    public static void main(String[] args) {
        Format tanggalan = new SimpleDateFormat("dd-MM-yyyy");
        RegionDao re = new RegionDao();
      //  for (int i = 1; i <= 10; i++) {
            Region reg = new Region();
      //      reg.setId(i);
            reg.setId(new Random().nextInt());
//            reg.setIdRegion("0001NAD0" + i);
//            reg.setProvinsi("NAD" + i);
//            reg.setKota("Meulaboh" + i);
//            reg.setKecamatan("Aserehe" + i);
//            reg.setDesa("Ohey" + i);
//            reg.setCreated(new Date());
            reg.setIdRegion("0001NAD0" );
            reg.setProvinsi("NAD" );
            reg.setKota("Meulaboh" );
            reg.setKecamatan("Aserehe" );
            reg.setDesa("Ohey" );
            reg.setCreated(new Date());

            System.out.println("----------------------------------");
            re.simpan(reg);
            tampilin(reg, tanggalan);
       // }
        
       Region rex = re.cariById(reg.getId());
            tampilin(rex, tanggalan);
        
        System.out.println("=====================");
        List<Region> semua = re.semuaRegion();
        for (Region region : semua) {
            tampilin(region,tanggalan);
            System.out.println("-------------------------");

        }
        System.out.println("=====================");
    

    }

    private static void tampilin(Region reg, Format tanggalan) {
        System.out.println("ID region " + reg.getId());
        System.out.println("Kode " + reg.getIdRegion());
        System.out.println("Provinsi " + reg.getProvinsi());
        System.out.println("Kota " + reg.getKota());
        System.out.println("Kecamatan " + reg.getKecamatan());
        System.out.println("Desa " + reg.getDesa());
        System.out.println("Created " + tanggalan.format(reg.getCreated()));
    }
}

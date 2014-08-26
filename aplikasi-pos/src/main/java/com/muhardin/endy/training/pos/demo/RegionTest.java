package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.domain.Region;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;




public class RegionTest {
    public static void main(String[] args) {
       Format tanggalan = new SimpleDateFormat("dd-MM-yyyy");
       Region r = new Region();
        for (int i=1;i<=10;i++){
        r.setId(i);
        r.setIdRegion("0001NAD0"+i);
        r.setProvinsi("NAD"+i);
        r.setKota("Meulaboh"+i);
        r.setKecamatan("Aserehe"+i);
        r.setDesa("Ohey"+i);
        r.setCreated(new Date());
        
        System.out.println("ID region "+r.getId());
        System.out.println("Kode "+r.getIdRegion());
        System.out.println("Provinsi "+r.getProvinsi());
        System.out.println("Kota "+r.getKota());
        System.out.println("Kecamatan "+r.getKecamatan());
        System.out.println("Desa "+r.getDesa());
        System.out.println("Created "+tanggalan.format(r.getCreated()));
        
        
        System.out.println("----------------------------------");
       
        
        }
    }
}

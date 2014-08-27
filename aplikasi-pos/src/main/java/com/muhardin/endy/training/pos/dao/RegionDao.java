/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Region;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myhan
 */
public class RegionDao{
    
    public static final String SQL_INSERT = "insert into region (id,idregion,provinsi,kota,kecamatan,desa,created) values (?,?,?,?,?,?,?)";
    
    public void simpan(Region reg) {
            try{
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            
            ps.setInt(1, reg.getId());
            ps.setString(2, reg.getIdRegion());
            ps.setString(3, reg.getProvinsi());
            ps.setString(4, reg.getKota());
            ps.setString(5, reg.getKecamatan());
            ps.setString(6, reg.getDesa());            
            ps.setDate(7, new java.sql.Date(reg.getCreated().getTime()));
            
            int hasil = ps.executeUpdate();
            System.out.println(hasil+" record berhasil diinsert");
                
            KoneksiDatabase.tutupKoneksi(koneksi);    
            }
            catch (SQLException ex) {
            Logger.getLogger(RegionDao.class.getName()).log(Level.SEVERE, null, ex);
            //  Logger.getLogger(RegionDao.class.getName()).log(Level.OFF, SQL_INSERT);
            } 
           
    }

    public void update(Region reg) throws Exception {
            
     }

     public void delete(Region reg) throws Exception {
            
     }
    
        
    public Region cariById(Integer id){
            return null;
    }
    
    public List<Region> semuaProduk(){
            return null;
    }
}

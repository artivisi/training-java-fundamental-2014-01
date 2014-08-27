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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myhan
 */
public class RegionDao{
    
    public static final String SQL_INSERT = "insert into region (id,idregion,provinsi,kota,kecamatan,desa,created) values (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from region where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from region where id = ?";
    private static final String SQL_SELECT_ALL = "select * from region";
    
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

    public void update(Region reg) {
            
     }

     public void delete(Region reg) {
         try{
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE);
            ps.setInt(1, reg.getId());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil dihapus");
            KoneksiDatabase.tutupKoneksi(koneksi);
            } 
         catch (SQLException ex) {
            Logger.getLogger(RegionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
    
        
    public Region cariById(Integer id){
       try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                Region p = konversiResultSetKeProduk(hasil);
                return p;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
        
    }
    
    public List<Region> semuaRegion(){
        List<Region> hasil = new ArrayList<Region>(); 
         try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Region p = konversiResultSetKeProduk(rs);
                hasil.add(p);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(RegionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    private Region konversiResultSetKeProduk(ResultSet hasil) throws SQLException{
        Region reg = new Region();
        reg.setId(hasil.getInt("id"));
        reg.setIdRegion(hasil.getString("idregion"));
        reg.setProvinsi(hasil.getString("provinsi"));
        reg.setKota(hasil.getString("kota"));
        reg.setKecamatan(hasil.getString("kecamatan"));
        reg.setDesa(hasil.getString("desa"));
        reg.setCreated(new Date(hasil.getDate("created").getTime()));
        
        return reg;
    }
}

package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Kategori;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategoriDao {
    
    private static final String SQL_INSERT = "insert into kategori (id,kode,nama,definisi)"
            + "values (?,?,?,?)";
    
    public void simpan(Kategori k){
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, k.getId());
            ps.setString(2, k.getKode());
            ps.setString(3, k.getNama());
            ps.setString(4, k.getDefinisi());
            int hasil = ps.executeUpdate();
            System.out.println(hasil+" record berhasil diinsert");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus(Kategori k){
        
    }
    
    public Kategori cariById(Integer id){
        return null;
    }
    
    public List<Kategori> semuaKategori(){
        return null;
    }
}

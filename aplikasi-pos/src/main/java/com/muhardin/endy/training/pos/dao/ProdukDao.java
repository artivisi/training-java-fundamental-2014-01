package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Produk;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdukDao {
    
    private static final String SQL_INSERT = "insert into produk (id,kode,nama,harga,tanggal_kadaluarsa)"
            + "values (?,?,?,?,?)";
    
    public void simpan(Produk p){
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getKode());
            ps.setString(3, p.getNama());
            ps.setBigDecimal(4, p.getHarga());
            ps.setDate(4, new java.sql.Date(p.getTanggalKadaluarsa().getTime()));
            int hasil = ps.executeUpdate();
            System.out.println(hasil+" record berhasil diinsert");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus(Produk p){
        
    }
    
    public Produk cariById(Integer id){
        return null;
    }
    
    public List<Produk> semuaProduk(){
        return null;
    }
}

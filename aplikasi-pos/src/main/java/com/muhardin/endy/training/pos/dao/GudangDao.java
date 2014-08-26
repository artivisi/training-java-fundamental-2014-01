/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Gudang;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class GudangDao {

    private final String SQL_INSERT = "insert into gudang (id,kodeGudang,namaGudang,AlamatGudang,NamaBarang,StokBarang)"
            + "values (?,?,?,?,?,?)";

//create table gudang(
//    id integer primary key,
//    kodeGudang varchar2(20),
//    namaGudang varchar2(20),
//    alamatGudang varchar2(20),
//    namaBarang varchar2(20),  
//    stokBarang Integer
//);
    
    public void simpan(Gudang g) {
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, g.getId());
            ps.setString(2, g.getKodeGudang());
            ps.setString(3, g.getNamaGudang());
            ps.setString(4, g.getAlamatGudang());
            ps.setString(5, g.getNamaBarang());
            ps.setInt(6, g.getStokBarang());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil diinsert");
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapus(Gudang g) {
    }

    public Gudang cari(Integer id) {
        return null;

    }

    public List<Gudang> semuaProduk() {
        return null;
    }
}

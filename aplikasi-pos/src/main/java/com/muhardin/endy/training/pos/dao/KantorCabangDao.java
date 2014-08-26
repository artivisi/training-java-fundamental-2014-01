/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.KantorCabang;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangDao {
     
    private static final String SQL_INSERT_KANTORCABANG = "insert into kantorCabang (id_kantorCbg,kode_kantorCbg,"
            + "nama_kantorCbg,alamat_kantorCbg,notelp_kantorCbg,namaKepala_kantorCbg)"
            + "values (?,?,?,?,?,?)";
     
    public void simpan(KantorCabang kc) {
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT_KANTORCABANG);
            ps.setInt(1, kc.getId_kantorCbg());
            ps.setString(2, kc.getKode_kantorCbg());
            ps.setString(3, kc.getNama_kantorCbg());
            ps.setString(4, kc.getAlamat_kantorCbg());
            ps.setString(5, kc.getNoTelp_kantorCbg());
            ps.setString(6, kc.getNamaKepala_kantorCbg());
            int hasil = ps.executeUpdate();
            System.out.println(hasil+" record berhasil diinsert");
            KoneksiDatabase.tutupKoneksi(koneksi);
        }catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(KantorCabang kc) {
    }

    public KantorCabang cari(Integer id) {
        return null;
    }
    
    public List<KantorCabang> semuaProduk() {
        return null;
    }
}

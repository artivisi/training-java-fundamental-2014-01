/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Penjualan;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA12
 */
public class PenjualanDao {

    private static final String SQL_INSERT = "insert into penjualan (id,nama_barang,nama_pembeli,jml_barang,harga,tgl_penjualan)"
            + "values (?,?,?,?,?,?)";

    public void simpanJual(Penjualan j) {
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, j.getId());
            ps.setString(2, j.getNamaBarang());
            ps.setString(3, j.getNamaPembeli());
            ps.setInt(4, j.getJmlBarang());
            ps.setBigDecimal(5, j.getHarga());
            ps.setDate(6, new java.sql.Date(j.getTglPenjualan().getTime()));
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil diinsert");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void batalJual(Penjualan j) {

    }

    public void diskonJual(Penjualan j) {

    }

    public Penjualan cariById(Integer id) {
        return null;
    }

    public List<Penjualan> listPenjualan() {
        return null;
    }
}

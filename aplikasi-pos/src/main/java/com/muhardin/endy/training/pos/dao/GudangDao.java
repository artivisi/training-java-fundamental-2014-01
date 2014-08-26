/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Gudang;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private static final String SQL_SELECT_BY_ID = "select * from gudang where id = ?";
    private static final String SQL_SELECT_SEMUA = "select * from gudang";
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

    public Gudang cariByID(Integer id) {

        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                Gudang g = konversiResultSetKeProduk(hasil);
                return g;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(GudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Gudang konversiResultSetKeProduk(ResultSet hasil) throws SQLException {
        Gudang ga = new Gudang();
        ga.setId(hasil.getInt("id"));
        ga.setKodeGudang(hasil.getString("kodeGudang"));
        ga.setNamaGudang(hasil.getString("namaGudang"));
        ga.setAlamatGudang(hasil.getString("alamatGudang"));
        ga.setNamaBarang(hasil.getString("namaBarang"));
        ga.setStokBarang(hasil.getInt("stokBarang"));

        return ga;
    }

    public List<Gudang> semuaGudang() {

        List<Gudang> hasil = new ArrayList<Gudang>();
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_SEMUA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Gudang gb = konversiResultSetKeProduk(rs);
                hasil.add(gb);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasil;
    }
}

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA-DJBC
 */
public class KantorCabangDao {
     
    private static final String SQL_INSERT_KANTORCABANG = "insert into kantor_cabang (id_kantorcbg,kode_kantorcbg,"
            + "nama_kantorcbg,alamat_kantorcbg,notelp_kantorcbg,namakepala_kantorcbg)"
            + "values (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from kantor_cabang where id_kantorcbg = ?";
    private static final String SQL_SELECT_BY_ID = "select * from kantor_cabang where id_kantorcbg = ?";
    private static final String SQL_SELECT_SEMUA = "select * from kantor_cabang";
     
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
            Logger.getLogger(KantorCabangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(KantorCabang kc) {
         try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE);
            ps.setInt(1, kc.getId_kantorCbg());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil dihapus");
            KoneksiDatabase.tutupKoneksi(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(KantorCabangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public KantorCabang cariById(Integer id_kantorcbg) {
         try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id_kantorcbg);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                KantorCabang kc = konversiResultSetKeKantorCabang(hasil);
                return kc;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(KantorCabangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private KantorCabang konversiResultSetKeKantorCabang(ResultSet hasil) throws SQLException {
        KantorCabang kc = new KantorCabang();
        kc.setId_kantorCbg(hasil.getInt("id_kantorcbg"));
        kc.setKode_kantorCbg(hasil.getString("kode_kantorcbg"));
        kc.setNama_kantorCbg(hasil.getString("nama_kantorcbg"));
        kc.setAlamat_kantorCbg(hasil.getString("alamat_kantorcbg"));
        kc.setNoTelp_kantorCbg(hasil.getString("notelp_kantorcbg"));
        kc.setNamaKepala_kantorCbg(hasil.getString("namakepala_kantorcbg"));
        return kc;
    }
    
    public List<KantorCabang> semuaKantorCabang() {
          List<KantorCabang> hasil = new ArrayList<KantorCabang>();
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_SEMUA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KantorCabang kc = konversiResultSetKeKantorCabang(rs);
                hasil.add(kc);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(KantorCabangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public static void main(String[] args) {
        KantorCabangDao d = new KantorCabangDao();
        d.semuaKantorCabang();
    }
}

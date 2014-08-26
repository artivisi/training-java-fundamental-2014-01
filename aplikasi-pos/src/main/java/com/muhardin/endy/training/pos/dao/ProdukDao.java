package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Produk;
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

public class ProdukDao {

    private static final String SQL_INSERT = "insert into produk (id,kode,nama,harga,tanggal_kadaluarsa)"
            + "values (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "select * from produk where id = ?";
    private static final String SQL_SELECT_SEMUA = "select * from produk";

    public void simpan(Produk p) {
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getKode());
            ps.setString(3, p.getNama());
            ps.setBigDecimal(4, p.getHarga());
            ps.setDate(5, new java.sql.Date(p.getTanggalKadaluarsa().getTime()));
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil diinsert");
            KoneksiDatabase.tutupKoneksi(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapus(Produk p) {

    }

    public Produk cariById(Integer id) {
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                Produk p = konversiResultSetKeProduk(hasil);
                return p;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Produk konversiResultSetKeProduk(ResultSet hasil) throws SQLException {
        Produk p = new Produk();
        p.setId(hasil.getInt("id"));
        p.setKode(hasil.getString("kode"));
        p.setNama(hasil.getString("nama"));
        p.setHarga(hasil.getBigDecimal("harga"));
        p.setTanggalKadaluarsa(new Date(hasil.getDate("tanggal_kadaluarsa").getTime()));
        return p;
    }

    public List<Produk> semuaProduk() {
        List<Produk> hasil = new ArrayList<Produk>();
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_SEMUA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produk p = konversiResultSetKeProduk(rs);
                hasil.add(p);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

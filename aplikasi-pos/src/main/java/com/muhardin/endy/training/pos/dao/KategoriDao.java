package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Kategori;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategoriDao {
    
    private static final String SQL_INSERT = "insert into kategori (id,kode,nama,definisi)"
            + "values (?,?,?,?)";
    private static final String SQL_DELETE = "delete from kategori where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from kategori where id = ?";
    private static final String SQL_SELECT_SEMUA = "select * from kategori";
    
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
        try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE);
            ps.setInt(1, k.getId());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil dihapus");
            KoneksiDatabase.tutupKoneksi(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Kategori cariById(Integer id){
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                Kategori k = konversiResultSetKeKategori(hasil);
                return k;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Kategori konversiResultSetKeKategori(ResultSet hasil) throws SQLException {
        Kategori k = new Kategori();
        k.setId(hasil.getInt("id"));
        k.setKode(hasil.getString("kode"));
        k.setNama(hasil.getString("nama"));
        k.setDefinisi(hasil.getString("definisi"));
        return k;
    }
    
    public List<Kategori> semuaKategori(){
        List<Kategori> hasil = new ArrayList<Kategori>();
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_SEMUA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Kategori k = konversiResultSetKeKategori(rs);
                hasil.add(k);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}

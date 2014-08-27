/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Customer;
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

/**
 *
 * @author CEISA-DJBC dhi
 */
public class CustomerDao {
    
    private static final String SQL_INSERT = "insert into customer (id_csr, kode_csr, nama_csr, alamat_csr, tanggal_daftar)" 
            + "values (?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from customer where id_csr = ?";
    private static final String SQL_SELECT_BY_ID = "select * from customer where id_csr = ?";
    private static final String SQL_SELECT_SEMUA = "select * from customer";
    
    public void simpan(Customer c){
     try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getIdCsr());
            ps.setString(2, c.getKodeCsr());
            ps.setString(3, c.getNamaCsr());
            ps.setString(4, c.getAlamatCsr());
            ps.setDate(5, new java.sql.Date(c.getTanggalDaftar().getTime()));
            int hasil = ps.executeUpdate();
            System.out.println(hasil+" record berhasil diinsert");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapus(Customer c){
            try {
            Connection koneksi = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdCsr());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " record berhasil dihapus");
            KoneksiDatabase.tutupKoneksi(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer cariById(Integer id){
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet hasil = ps.executeQuery();

            if (hasil.next()) {
                Customer c = konversiResultSetKeCustomer(hasil);
                return c;
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        private Customer konversiResultSetKeCustomer(ResultSet hasil) throws SQLException {
        Customer c = new Customer();
        c.setIdCsr(hasil.getInt("idCsr"));
        c.setKodeCsr(hasil.getString("kodeCsr"));
        c.setNamaCsr(hasil.getString("namaCsr"));
        c.setAlamatCsr(hasil.getString("alamatCsr"));
        c.setTanggalDaftar(new Date(hasil.getDate("tanggalDaftar").getTime()));
        return c;
    }
    
    public List<Customer> semuaCustomer(){
        List<Customer> hasil = new ArrayList<Customer>();
        try {
            Connection conn = KoneksiDatabase.bukaKoneksi();

            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_SEMUA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = konversiResultSetKeCustomer(rs);
                hasil.add(c);
            }

            KoneksiDatabase.tutupKoneksi(conn);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

}

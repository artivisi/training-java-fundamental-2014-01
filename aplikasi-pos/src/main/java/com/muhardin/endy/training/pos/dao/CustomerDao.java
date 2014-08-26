/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.dao;

import com.muhardin.endy.training.pos.domain.Customer;
import com.muhardin.endy.training.pos.helper.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    }
    
    public Customer cariById(Integer id){
        return null;
    }
    
    public List<Customer> semuaCustomer(){
    return null;
    }

}

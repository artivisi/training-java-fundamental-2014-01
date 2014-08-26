/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.CustomerDao;
import com.muhardin.endy.training.pos.domain.Customer;
import java.util.Date;

/**
 *
 * @author CEISA-DJBC 
 */
public class CustomerDemo {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setIdCsr(1);
        c.setKodeCsr("C-001");
        c.setNamaCsr("Dodo");
        c.setAlamatCsr("Jl. Mugeni 8 no. 1");
        c.setTanggalDaftar(new Date());
        
//         System.out.println("ID Customer "+c.getId());
//        System.out.println("Kode Customer "+c.getKode());
//        System.out.println("Nama Customer "+c.getNama());
//        System.out.println("Alamat Customer "+c.getAlamat());
//        System.out.println("Tanggal Daftar "+c.getTanggalDaftar());
        
        CustomerDao cd = new CustomerDao();
        cd.simpan(c);
    }
}
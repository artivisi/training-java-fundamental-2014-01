package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.CustomerDao;
import com.muhardin.endy.training.pos.domain.Customer;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CustomerDaoDemo {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setIdCsr(new Random().nextInt());
        c.setKodeCsr("C-001");
        c.setNamaCsr("Gogon");
        c.setAlamatCsr("Jl. Mugeni");
        c.setTanggalDaftar(new Date());

        CustomerDao cd = new CustomerDao();
        cd.simpan(c);

        Customer cx = cd.cariById(c.getIdCsr());
        displayCustomer(cx);

        System.out.println("=====================");
        List<Customer> semua = cd.semuaCustomer();
        
        for (Customer customer : semua) {
            displayCustomer(customer);
        }
        System.out.println("=====================");
    }

    private static void displayCustomer(Customer cx) {
            System.out.println("ID Csr     =  " + cx.getIdCsr());
            System.out.println("Kode Csr   =  " + cx.getKodeCsr());
            System.out.println("Nama Csr   =  " + cx.getNamaCsr());
            System.out.println("Alamat Csr =  " + cx.getAlamatCsr());
            System.out.println("Tanggal Daftar   =  " + cx.getTanggalDaftar());
         }
    }


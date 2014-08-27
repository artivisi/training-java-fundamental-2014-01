/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.dao.PenjualanDao;
import com.muhardin.endy.training.pos.domain.Penjualan;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author CEISA12
 */
public class PenjualanDemo {

    public static void main(String[] args) {
        Penjualan j = new Penjualan();
        j.setId(1);
        j.setNamaBarang("Rokok");
        j.setNamaPembeli("Alfamart");
        j.setJmlBarang(10);
        j.setHarga(new BigDecimal("10000.00"));
        j.setTglPenjualan(new Date());
        
        PenjualanDao pd = new PenjualanDao();
        pd.simpanJual(j);
    }

}

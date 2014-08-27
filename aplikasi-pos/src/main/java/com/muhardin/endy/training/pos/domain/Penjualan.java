/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author CEISA12
 */
public class Penjualan {
    private Integer id;
    private String namaBarang;
    private String namaPembeli;
    private Integer jmlBarang;
    private BigDecimal harga;
    private Date tglPenjualan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public Integer getJmlBarang() {
        return jmlBarang;
    }

    public void setJmlBarang(Integer jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Date getTglPenjualan() {
        return tglPenjualan;
    }

    public void setTglPenjualan(Date tglPenjualan) {
        this.tglPenjualan = tglPenjualan;
    }

    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.domain;

import java.util.Date;

/**
 *
 * @author CEISA-DJBC 
 */
public class Customer {
    private Integer idCsr;
    private String kodeCsr;
    private String namaCsr;
    private String alamatCsr;
    private Date tanggalDaftar;
    
    public Integer getId(){
        return idCsr;
    }
    
    public void setId(Integer id){
        this.idCsr = id;
    }
    
    public String getKode(){
        return kodeCsr;
    }
    
    public void setKode(String kode){
        this.kodeCsr = kode;
    }
    public String getNama(){
        return namaCsr;
    }
    
    public void setNama(String nama){
        this.namaCsr = nama;
    }
    
    public String getAlamat(){
        return alamatCsr;
    }
    
    public void setAlamat(String alamat){
        this.alamatCsr = alamat;
    }
    
    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }
}
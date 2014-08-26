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

    public Integer getIdCsr() {
        return idCsr;
    }

    public void setIdCsr(Integer idCsr) {
        this.idCsr = idCsr;
    }

    public String getKodeCsr() {
        return kodeCsr;
    }

    public void setKodeCsr(String kodeCsr) {
        this.kodeCsr = kodeCsr;
    }

    public String getNamaCsr() {
        return namaCsr;
    }

    public void setNamaCsr(String namaCsr) {
        this.namaCsr = namaCsr;
    }

    public String getAlamatCsr() {
        return alamatCsr;
    }

    public void setAlamatCsr(String alamatCsr) {
        this.alamatCsr = alamatCsr;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }
    
    
}
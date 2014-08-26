/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.pos.domain;

import java.math.BigDecimal;

/**
 *
 * @author CEISA-DJBC
 */
public class WilayahPengiriman {
    private Integer id;
    private String kode;
    private String namaWilayah;
    private BigDecimal ongkosKirim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaWilayah() {
        return namaWilayah;
    }

    public void setNamaWilayah(String namaWilayah) {
        this.namaWilayah = namaWilayah;
    }

    public BigDecimal getOngkosKirim() {
        return ongkosKirim;
    }

    public void setOngkosKirim(BigDecimal ongkosKirim) {
        this.ongkosKirim = ongkosKirim;
    }
     
}

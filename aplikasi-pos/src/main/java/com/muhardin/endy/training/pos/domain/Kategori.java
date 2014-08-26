package com.muhardin.endy.training.pos.domain;

public class Kategori {
    private Integer id;
    private String kode;
    private String nama;
    private String definisi;

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDefinisi() {
        return definisi;
    }

    public void setDefinisi(String definisi) {
        this.definisi = definisi;
    }
}

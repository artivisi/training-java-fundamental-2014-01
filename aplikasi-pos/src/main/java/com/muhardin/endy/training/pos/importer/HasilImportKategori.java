/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Kategori;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ceisa-djbc
 */
public class HasilImportKategori {
    private List<Kategori> data = new ArrayList<Kategori>();
    private List<ImportError> daftarError = new ArrayList<ImportError>();

    public List<Kategori> getData() {
        return data;
    }

    public void setData(List<Kategori> data) {
        this.data = data;
    }

    public List<ImportError> getDaftarError() {
        return daftarError;
    }

    public void setDaftarError(List<ImportError> daftarError) {
        this.daftarError = daftarError;
    }
}

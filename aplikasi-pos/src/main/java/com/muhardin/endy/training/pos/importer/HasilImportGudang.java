/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Gudang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class HasilImportGudang {
        private List<Gudang> data = new ArrayList<Gudang>();
    private List<ImportError> daftarError = new ArrayList<ImportError>();

    public List<Gudang> getData() {
        return data;
    }

    public void setData(List<Gudang> data) {
        this.data = data;
    }

    public List<ImportError> getDaftarError() {
        return daftarError;
    }

    public void setDaftarError(List<ImportError> daftarError) {
        this.daftarError = daftarError;
    }
    
    
}

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Produk;
import java.util.ArrayList;
import java.util.List;

public class HasilImportProduk {
    private List<Produk> data = new ArrayList<Produk>();
    private List<ImportError> daftarError = new ArrayList<ImportError>();

    public List<Produk> getData() {
        return data;
    }

    public void setData(List<Produk> data) {
        this.data = data;
    }

    public List<ImportError> getDaftarError() {
        return daftarError;
    }

    public void setDaftarError(List<ImportError> daftarError) {
        this.daftarError = daftarError;
    }
    
    
}

package com.muhardin.endy.training.pos.importer;

import com.muhardin.endy.training.pos.domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class HasilImportCustomer {
  private List<Customer> data = new ArrayList<Customer>();
    private List<ImportError> daftarError = new ArrayList<ImportError>();

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }

    public List<ImportError> getDaftarError() {
        return daftarError;
    }

    public void setDaftarError(List<ImportError> daftarError) {
        this.daftarError = daftarError;
    }

}

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.exporter.ProdukExporter;

public class ProdukExporterDemo {
    public static void main(String[] args) {
        String namaFile = "target/produk.csv";
        ProdukExporter pe = new ProdukExporter();
        pe.exportKeCsv(namaFile);
    }
}

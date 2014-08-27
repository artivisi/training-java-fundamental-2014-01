/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.exporter.KategoriExporter;

/**
 *
 * @author ceisa-djbc
 */
public class KategoriExporterDemo {
    public static void main(String[] args) {
        String namaFile = "target/kategori.csv";
        KategoriExporter pe = new KategoriExporter();
        pe.exportKeCsv(namaFile);
    }
}

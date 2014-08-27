/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.exporter.RegionExporter;

/**
 *
 * @author ceisa-djbc
 */
public class RegionExportCSV {
    public static void main(String[] args) {
        String namaFile="d:/region.csv";
        RegionExporter expor = new RegionExporter();
        expor.exportCSV(namaFile);
    }
}

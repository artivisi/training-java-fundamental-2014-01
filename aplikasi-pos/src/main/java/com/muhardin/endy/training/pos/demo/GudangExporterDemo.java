/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.demo;

import com.muhardin.endy.training.pos.exporter.GudangExporter;

/**
 *
 * @author CEISA3
 */
public class GudangExporterDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                String namaFile = "target/gudang.csv";
        GudangExporter pe = new GudangExporter();
        pe.exportKeCsv(namaFile);
    }
    
}

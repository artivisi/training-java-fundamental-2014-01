package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.exporter.ProdukExporter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class ProdukDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdukExporter pe = new ProdukExporter();
        File fileSementara = File.createTempFile("produk", ".csv");
        pe.exportKeCsv(fileSementara.getAbsolutePath());
        
        resp.setContentType("text/csv");
        // inline : langsung ditampilkan (embed) di browser
        // resp.setHeader("Content-Disposition", "inline; filename=\"filename.csv");
        // attachment : memunculkan popup dialog untuk save
        resp.setHeader("Content-Disposition", "attachment; filename=daftar-produk.csv");
        
        FileInputStream in = new FileInputStream(fileSementara);
        int data;
        while((data = in.read()) != -1){
            resp.getOutputStream().write(data);
        }
        in.close();
        resp.getOutputStream().flush();
    }
}

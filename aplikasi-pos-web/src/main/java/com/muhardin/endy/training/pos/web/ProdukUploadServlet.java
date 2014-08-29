package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import com.muhardin.endy.training.pos.importer.HasilImportProduk;
import com.muhardin.endy.training.pos.importer.ProdukImporter;
import java.io.IOException;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author endy
 */
public class ProdukUploadServlet extends HttpServlet {

    private static final String LOKASI_UPLOAD = "/upload";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/jsp/produk/upload.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String pathUpload = req.getServletContext().getRealPath(LOKASI_UPLOAD);
            System.out.println("Lokasi folder upload : "+pathUpload);
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(pathUpload));
            
            ServletFileUpload prosesorMultipart = new ServletFileUpload(factory);
            List<FileItem> hasilParsing = prosesorMultipart.parseRequest(req);
            
            System.out.println("Jumlah file yang diupload : "+hasilParsing.size());
            
            ProdukDao dao = new ProdukDao();
            for (FileItem fileItem : hasilParsing) {
                String contentType = fileItem.getContentType();
                String namaField = fileItem.getFieldName();
                String namaFile = fileItem.getName();
                
                System.out.println("Content Type : "+contentType);
                System.out.println("Nama Field : "+namaField);
                System.out.println("Nama File : "+namaFile);
                
                File tujuan = new File(pathUpload + File.separator + namaFile);
                fileItem.write(tujuan);
                
                ProdukImporter importer = new ProdukImporter();
                HasilImportProduk hasil = importer.importFile(tujuan);
                req.setAttribute("hasil", hasil);
                
                for (Produk produk : hasil.getData()) {
                    dao.simpan(produk);
                }
                
                req.getRequestDispatcher("/WEB-INF/templates/jsp/produk/hasilupload.jsp")
                        .forward(req, resp);
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(ProdukUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProdukUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

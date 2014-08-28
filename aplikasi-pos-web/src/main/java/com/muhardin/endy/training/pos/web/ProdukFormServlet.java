package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class ProdukFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        if(idString != null && !idString.isEmpty()){
            Integer id = Integer.parseInt(req.getParameter("id"));
            ProdukDao pd = new ProdukDao();
            Produk p = pd.cariById(id);
            req.setAttribute("produk", p);
        } else {
            req.setAttribute("produk", new Produk());
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/produk/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produk p = new Produk();
        String id = req.getParameter("id");
        if(id != null && !id.isEmpty()){
            p.setId(Integer.parseInt(id));
        }
        p.setKode(req.getParameter("kode"));
        p.setNama(req.getParameter("nama"));
        p.setHarga(new BigDecimal(req.getParameter("harga")));
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            p.setTanggalKadaluarsa(formatter.parse(req.getParameter("tanggalKadaluarsa")));
        } catch (ParseException ex) {
            Logger.getLogger(ProdukFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ProdukDao pd = new ProdukDao();
        pd.simpan(p);
        
        resp.sendRedirect("list");
    }
    
    
    
}

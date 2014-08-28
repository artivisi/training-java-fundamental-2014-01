/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.GudangDao;
import com.muhardin.endy.training.pos.domain.Gudang;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CEISA3
 */
public class GudangFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        if(idString != null && !idString.isEmpty()){
            Integer id = Integer.parseInt(req.getParameter("id"));
            GudangDao gd = new GudangDao();
            Gudang g = gd.cariByID(id);
            req.setAttribute("gudang", g);
        } else {
            req.setAttribute("gudang", new Gudang());
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/produk/formGudang.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gudang g = new Gudang();
        g.setKodeGudang(req.getParameter("kodeGudang"));
        g.setNamaGudang(req.getParameter("namaGudang"));
        g.setAlamatGudang(req.getParameter("alamatGudang"));
        g.setNamaBarang(req.getParameter("namaBarang"));
        
        try {
            g.setStokBarang(Integer.parseInt(req.getParameter("stokBarang")));
        } catch (NumberFormatException ex) {
            Logger.getLogger(GudangFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GudangDao gd = new GudangDao();
        gd.simpan(g);
        
        resp.sendRedirect("list");
    }
    
    
    
}

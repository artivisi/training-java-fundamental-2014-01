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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CEISA3
 */
public class GudangListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GudangDao pd = new GudangDao();
        List<Gudang> data = pd.semuaGudang();
        req.setAttribute("daftarGudang", data);
        req.getRequestDispatcher("/WEB-INF/templates/jsp/gudang/listGudang.jsp")
                .forward(req, resp);
    }
    
}
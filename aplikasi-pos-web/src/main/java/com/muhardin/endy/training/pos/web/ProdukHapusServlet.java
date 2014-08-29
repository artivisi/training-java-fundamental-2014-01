package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdukHapusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        ProdukDao pd = new ProdukDao();
        
        Produk p = new Produk();
        p.setId(id);
        pd.hapus(p);
        
        resp.sendRedirect("list");
    }
}

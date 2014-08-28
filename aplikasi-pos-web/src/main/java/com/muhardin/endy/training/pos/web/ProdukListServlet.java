package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.ProdukDao;
import com.muhardin.endy.training.pos.domain.Produk;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class ProdukListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdukDao pd = new ProdukDao();
        List<Produk> data = pd.semuaProduk();
        req.setAttribute("daftarProduk", data);
        req.getRequestDispatcher("/WEB-INF/templates/jsp/produk/list.jsp")
                .forward(req, resp);
    }
    
}

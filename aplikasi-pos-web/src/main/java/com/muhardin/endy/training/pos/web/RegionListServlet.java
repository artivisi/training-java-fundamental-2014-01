
package com.muhardin.endy.training.pos.web;

import com.muhardin.endy.training.pos.dao.RegionDao;
import com.muhardin.endy.training.pos.domain.Region;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ceisa-djbc
 */
public class RegionListServlet extends HttpServlet {

 
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        
        RegionDao dao = new  RegionDao();
        List<Region>data = dao.semuaRegion();
        
        req.setAttribute("daftar", data);
        req.getRequestDispatcher("/WEB-INF/templates/jsp/region/list.jsp").forward(req, resp);
    }
        
        
        
        
}

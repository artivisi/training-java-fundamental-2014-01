package com.muhardin.endy.training.pos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class HaloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter output = resp.getWriter();
        
        String nama = req.getParameter("nama");
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("HH:mm:ss");
        
        output.println("<html>");
        output.println("<head><title>Servlet Halo</title></head>");
        
        output.println("<body>");
        output.println("<h1>Servlet Halo</h1>");
        output.println("<h2>Halo "+nama+", sekarang jam "+formatterWaktu.format(new Date())+"</h2>");
        output.println("</body>");
        output.println("</html>");
        
        output.flush();
    }
   
}

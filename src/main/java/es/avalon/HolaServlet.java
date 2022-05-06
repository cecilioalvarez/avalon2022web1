package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaServlet extends HttpServlet {
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            PrintWriter pw= response.getWriter();
            pw.println("hola desde un servlet");
        
    }
}

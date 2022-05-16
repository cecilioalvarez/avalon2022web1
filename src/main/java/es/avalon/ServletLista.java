package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletLista extends HttpServlet {
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            PrintWriter pw= response.getWriter();
     
            response.setContentType("text/html");
 

           pw.println("<html>");
           pw.println("<body>");
           for (int i=0;i<100;i++) {
            pw.println("<p>"+i+"</p>");

           }
          
           pw.println("</body>");
           pw.println("</html>");
         
           
         


        
    }
}

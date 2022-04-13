/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

/**
 *
 * @author UMAR
 */
public class search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if(!(request.getParameter("hehe")==null)){
                
                //JDBC Connectity
                       ServletContext context=getServletContext(); 
                       Class.forName(context.getInitParameter("connecter"));
                       Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
                       Statement select=con.createStatement();
                       String query = "Select * from info where UserName='"+request.getParameter("uName")+"'&& Doctor='"+request.getParameter("hehe") +"'";
                        ResultSet rs= select.executeQuery(query);
                        if(rs.next()){
                        request.setAttribute("descri",rs.getString("Description"));
                        
                        request.setAttribute("Search",request.getParameter("uName"));
                        RequestDispatcher rd2 = request.getRequestDispatcher("patientForDoc.jsp");
                        rd2.forward(request,response);
                        //JDBC Connectity
                        } else{
                        String value="";
                        request.setAttribute("search",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patientForDoc.jsp");
                        rd2.forward(request,response);
                        
                        }
            }
            else{  
            response.sendRedirect("login.jsp");
            }
    
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

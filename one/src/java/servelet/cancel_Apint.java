/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author BatMan
 */
public class cancel_Apint extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //JDBC Connectity
           ServletContext context=getServletContext(); 
           Class.forName(context.getInitParameter("connecter"));
           Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
           Statement update=con.createStatement();

           //JDBC Connectity
           
           //session managment
           HttpSession session =request.getSession(false);
            if(session!=null){
                if(!"patient".equals(session.getAttribute("type").toString()) || session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    
                    String value="";                   
                    String query="Select Doctor from info where UserName='"+session.getAttribute("username").toString()+"'"; 
                    ResultSet rs = update.executeQuery(query );  
                    rs.next();
                    if(rs.getString("Doctor")==null || "".equals(rs.getString("Doctor"))) {
                        request.setAttribute("noAppoint",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                    }
                    else{
                        query="update info set Description='' where UserName='"+session.getAttribute("username").toString()+"'"; 
                        update.executeUpdate( query );
                        query="update info set Doctor='' where UserName='"+session.getAttribute("username").toString()+"'"; 
                        update.executeUpdate( query );
                        request.setAttribute("cancelled",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                    }                            
                }
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment           
           con.close();
            
            
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

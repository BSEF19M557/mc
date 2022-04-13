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
public class checked extends HttpServlet {

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
         
            
            HttpSession session =request.getSession(false);
            if(session!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    if("doctor".equals(session.getAttribute("type").toString())){
                        response.sendRedirect("login.jsp");
                    }
                    else{
                        //JDBC Connectity
                       ServletContext context=getServletContext(); 
                       Class.forName(context.getInitParameter("connecter"));
                       Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
                       Statement update=con.createStatement();
                       String query;
                       
                       query="Select * from info where UserName='"+session.getAttribute("username")+"' ";
                        ResultSet rs=update.executeQuery(query);
                        rs.next();
                        if(rs.getString("Doctor")==null || "".equals(rs.getString("Doctor"))){
                            query="update info set Description='' where UserName='"+session.getAttribute("username")+"' ";
                            update.executeUpdate(query);
                        }
                       query="update info set Remarks='' where UserName='"+session.getAttribute("username")+"' ";
                        update.executeUpdate(query);         
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                       //JDBC Connectity
                       con.close();
                    }
                }   
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment
            
            
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

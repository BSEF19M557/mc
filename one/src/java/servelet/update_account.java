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
public class update_account extends HttpServlet {

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
           PreparedStatement select=con.prepareStatement("Select * from info where UserName=? ");
           //JDBC Connectity
           
           //session managment
           HttpSession session =request.getSession(false);
            if(session!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    select.setString(1, session.getAttribute("username").toString());
                    ResultSet rs1 = select.executeQuery();
                    if(rs1.next()){
                        request.setAttribute("FName", rs1.getString("FirstName"));
                        request.setAttribute("LName", rs1.getString("LastName"));
                        request.setAttribute("UName", rs1.getString("UserName"));
                        request.setAttribute("Pass", rs1.getString("Password"));
                        request.setAttribute("Email", rs1.getString("Email"));
                        request.setAttribute("Address", rs1.getString("Address"));
                        request.setAttribute("Category", rs1.getString("Category"));
                        request.setAttribute("Type", rs1.getString("Type"));
                        request.setAttribute("Mobile", rs1.getString("MNumber"));
                        
                            String value="";
                            request.setAttribute("fromupdate",value);
                        
                        if(rs1.getString("Type").equals("patient")){
                            RequestDispatcher rd2 = request.getRequestDispatcher("patient_updateForm.jsp");
                            rd2.forward(request,response);
                        }
                        else{
                            RequestDispatcher rd2 = request.getRequestDispatcher("doctor_updateForm.jsp");
                            rd2.forward(request,response);
                        }
                            
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

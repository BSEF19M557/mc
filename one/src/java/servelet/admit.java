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
import java.util.ArrayList;

/**
 *
 * @author BatMan
 */
public class admit extends HttpServlet {

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
                if(!"patient".equals(session.getAttribute("type").toString())){
                    response.sendRedirect("login.jsp");
                }
                else if(session.getAttribute("admit")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                //valdation
                
                String value="";
                if("".equals(request.getParameter("Des"))) {
                    
                    request.setAttribute("jsOff",value);
                    RequestDispatcher rd2 = request.getRequestDispatcher("admit.jsp");
                    rd2.forward(request,response);
                }
                else{
                    
                    String query="Select Doctor,Remarks from info where UserName='"+session.getAttribute("username").toString()+"'"; 
                    ResultSet rs = update.executeQuery(query );
                    rs.next();
                    if(!(rs.getString("Doctor")==null || "".equals(rs.getString("Doctor")))){
                        request.setAttribute("appointed",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("admit.jsp");
                        rd2.forward(request,response);
                    }
                    else if(!(rs.getString("Remarks")==null || "".equals(rs.getString("Remarks")))){
                        request.setAttribute("marks",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("admit.jsp");
                        rd2.forward(request,response);
                    }
                    else{
                    ArrayList al=new ArrayList();
                    query ="Select Category,UserName from info"; 
                     rs   = update.executeQuery(query );
                    while(rs.next()){
                        if(request.getParameter("g3").equals(rs.getString("Category")))
                            al.add(rs.getString("UserName"));
                    }
                    if(al.isEmpty()){
                       request.setAttribute("noDoc",value); 
                       RequestDispatcher rd2 = request.getRequestDispatcher("admit.jsp");
                       rd2.forward(request,response); 
                    }
                    else{
                     int rand = (int)(Math.random() * al.size());  
                     query="update info set Description='"+request.getParameter("Des")+"' where UserName='"+session.getAttribute("username").toString()+"'"; 
                     update.executeUpdate( query );
                     query="update info set Doctor='"+al.get(rand)+"' where UserName='"+session.getAttribute("username").toString()+"'"; 
                     update.executeUpdate( query );
                     
                        request.setAttribute("admit",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                     
                     }
                    }
                   }

                //valdation    

                                            
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

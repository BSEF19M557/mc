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
public class update_qury extends HttpServlet {

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
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                if(session.getAttribute("fromupdate")!=null){
                    response.sendRedirect("login.jsp");
                }
                else{
                //valdation "errorin it"
                
                boolean Isn=false;
                try{
                    double d = Double.parseDouble(request.getParameter("mNumber"));
                }
                catch(NumberFormatException e){
                    Isn =true;
                    }
                String value="";
                request.setAttribute("jsOff",value);
                if("".equals(request.getParameter("fName")) || "".equals(request.getParameter("lName")) || "".equals(request.getParameter("mNumber")) || request.getParameter("mNumber").length()!=11 || Isn || "".equals(request.getParameter("pass"))|| !request.getParameter("pass").equals(request.getParameter("conPass")) || "".equals(request.getParameter("address"))|| "".equals(request.getParameter("mail"))){
                    
                   if("patient".equals(session.getAttribute("type").toString())){ 
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_updateForm.jsp");
                        rd2.forward(request,response);
                   }
                   else{
                        RequestDispatcher rd2 = request.getRequestDispatcher("doctor_updateForm.jsp");
                        rd2.forward(request,response);
                   }
                }
                else if(request.getParameter("fName") ==null || request.getParameter("lName")==null || request.getParameter("mNumber")==null || request.getParameter("pass")==null|| request.getParameter("address")==null|| request.getParameter("mail")==null){
                    
                    if("patient".equals(session.getAttribute("type").toString())){ 
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_updateForm.jsp");
                        rd2.forward(request,response);
                   }
                   else{
                        RequestDispatcher rd2 = request.getRequestDispatcher("doctor_updateForm.jsp");
                        rd2.forward(request,response);
                   }
                }

                //valdation    

                else{
                    String username=session.getAttribute("username").toString();
                    String query;
                    query="update info set FirstName='"+request.getParameter("fName")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                    query="update info set LastName='"+request.getParameter("lName")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                    query="update info set Password='"+request.getParameter("pass")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                    query="update info set MNumber='"+request.getParameter("mNumber")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                    query="update info set Address='"+request.getParameter("address")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                    query="update info set Email='"+request.getParameter("mail")+"' where UserName='"+username+"' ";
                        update.executeUpdate(query);
                 
                    if("patient".equals(session.getAttribute("type").toString())){
                            
                        request.setAttribute("updated",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                    }
                    else{                     
                        request.setAttribute("updated",value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("doctor_detail.jsp");
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

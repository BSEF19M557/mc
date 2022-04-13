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
public class create_validation extends HttpServlet {

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
            //including loder 
           
           if(request.getSession(false)==null){
               response.sendRedirect("login.jsp");
           } 

           //JDBC Connectity
           ServletContext context=getServletContext(); 
           Class.forName(context.getInitParameter("connecter"));
           Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
           PreparedStatement select=con.prepareStatement("Select * from info where UserName=? ");
           PreparedStatement insert=con.prepareStatement("insert into info values(?,?,?,?,?,?,?,?,?,?,?,?)");
           //JDBC Connectity
           
           //feching values
           String fName   = request.getParameter("fName");
           String lName   = request.getParameter("lName");
           String uName   = request.getParameter("uName");
           String mNumber = request.getParameter("mNumber");
           String pass    = request.getParameter("pass");
           String conPass = request.getParameter("conPass");
           String g3      = request.getParameter("g3");
           String address = request.getParameter("address");
           String mail    = request.getParameter("mail");
           String hide    = request.getParameter("hide");
           //feching values
           
           // sleeping
                     //Thread.sleep(2000);
           // sleepimg
           
           if(hide.equals("Signup")){
           
            //Validation
            boolean Isn=false;
           try{
            double d = Double.parseDouble(mNumber);
            }
            catch(NumberFormatException e){
                Isn =true;
                }
           if("".equals(fName) || "".equals(lName) || "".equals(uName) || "".equals(mNumber) || mNumber.length()!=11 || Isn || "".equals(pass)|| !pass.equals(conPass)){
            String value="";
            request.setAttribute("jsOff",value);
            RequestDispatcher rd2 = request.getRequestDispatcher("Signup.jsp");
            rd2.forward(request,response);
            }
           //Validation
           
           //User checking
                select.setString(1, uName);
                ResultSet rs1 = select.executeQuery();
                if(rs1.next()){
                String value="";
                request.setAttribute("uExist",value);
                RequestDispatcher rd2 = request.getRequestDispatcher("Signup.jsp");
                rd2.forward(request,response);
                }
           //User checking
                else{
                    //SuccessMessage
                        //inserting in table
                        insert.setString(1, fName);
                        insert.setString(2, lName);
                        insert.setString(3, uName);
                        insert.setString(4, pass);
                        insert.setDouble(5, Double.parseDouble(mNumber));
                        insert.setString(6, "");
                        insert.setString(7, "");
                        insert.setString(8, "-");
                        insert.setString(9, "patient");
                        insert.setString(10, "");
                        insert.setString(11, "");
                        insert.setString(12, "");
                        
                        insert.executeUpdate();
                        //inserting in table
                        
                     String value="";
                     request.setAttribute("success",value);
                     RequestDispatcher rd2 = request.getRequestDispatcher("Signup.jsp");
                     rd2.forward(request,response);
                     //SuccessMessage
                    }
           }
           
           if(hide.equals("Signupdoc")){
           
                //Validation
                boolean Isn=false;
               try{
                double d = Double.parseDouble(mNumber);
                }
                catch(NumberFormatException e){
                    Isn =true;
                    }
               if("".equals(fName) || "".equals(lName) || "".equals(uName) || "".equals(mNumber) || mNumber.length()!=11 || Isn || "".equals(pass)|| !pass.equals(conPass) || "".equals(address)|| "".equals(mail)){
                String value="";
                request.setAttribute("jsOff",value);
                RequestDispatcher rd2 = request.getRequestDispatcher("Signupdoc.jsp");
                rd2.forward(request,response);
                }
               //Validation

               //User checking
                    select.setString(1, uName);
                    ResultSet rs1 = select.executeQuery();
                    if(rs1.next()){
                    String value="";
                    request.setAttribute("uExist",value);
                    RequestDispatcher rd2 = request.getRequestDispatcher("Signupdoc.jsp");
                    rd2.forward(request,response);
                    }
               //User checking
                    else{
               //SuccessMessage
                            //inserting in table
                            insert.setString(1, fName);
                            insert.setString(2, lName);
                            insert.setString(3, uName);
                            insert.setString(4, pass);
                            insert.setDouble(5, Double.parseDouble(mNumber));
                            insert.setString(6, mail);
                            insert.setString(7, address);
                            insert.setString(8, g3);
                            insert.setString(9, "doctor");
                            insert.setString(10,"-");
                            insert.setString(11,"-");
                            insert.setString(12,"-");
                            insert.executeUpdate();
                            //inserting in table

                            String value="";
                            request.setAttribute("success",value);
                            RequestDispatcher rd2 = request.getRequestDispatcher("Signupdoc.jsp");
                            rd2.forward(request,response);
                //SuccessMessage
                        } 
            }
        if(hide.equals("login")){
            
            if("".equals(fName) || "".equals(uName)){
            String value="";
            request.setAttribute("jsOff",value);
            RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
            rd2.forward(request,response);
            }
            
            select.setString(1, uName);
            ResultSet rs1 = select.executeQuery();
            
            
          
            if(!rs1.next()){
                String value="";
                request.setAttribute("iUser",value);
                RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
                rd2.forward(request,response);
            }
            else if(!pass.equals(rs1.getString("Password"))){
                String value="";
                request.setAttribute("iPass",value);
                RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
                rd2.forward(request,response);
                
            }
            else{
                
                
            //session
                HttpSession session =request.getSession();
                session.setAttribute("name", rs1.getString("UserName"));
                session.setAttribute("type",rs1.getString("Type"));
                session.setAttribute("username",rs1.getString("UserName"));
            
            
            //session 
                
                
                
                if("patient".equals(rs1.getString("Type"))){
                
                    RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                    rd2.forward(request,response);
                }
                else{
                    RequestDispatcher rd2 = request.getRequestDispatcher("doctor_detail.jsp");
                    rd2.forward(request,response);
                }
            }
            
        } 
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

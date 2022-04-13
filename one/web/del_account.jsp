<%-- 
    Document   : del_account
    Created on : Jan 2, 2022, 4:35:41 PM
    Author     : BatMan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>del</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            //JDBC Connectity
           ServletContext context=getServletContext(); 
           Class.forName(context.getInitParameter("connecter"));
           Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
           Statement st = con.createStatement();
           
           
           //JDBC Connectity
           
           //session managment
               session =request.getSession(false);
            if(session!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    
                    String value="";
                    String sql ="select Description,Remarks from info where username='"+session.getAttribute("username").toString()+"' ";
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    
                    if(rs.getString("Description").equals("-") && rs.getString("Remarks").equals("-") ){
                        boolean f=true;
                        sql ="select Doctor from info";
                        rs = st.executeQuery(sql);
                        while(rs.next()){
                            if(rs.getString("Doctor").equals(session.getAttribute("username").toString())){
                                f=false;
                                request.setAttribute("hasAppoint", value);
                                RequestDispatcher rd2 = request.getRequestDispatcher("doctor_detail.jsp");
                                rd2.forward(request,response);
                            }
                        }
                        if(f){
                            sql ="delete from info where username='"+session.getAttribute("username").toString()+"' ";
                            st.executeUpdate( sql );
                            session.invalidate();
                        }
                        
                    }
                    else{
                        if(!(rs.getString("Description").equals("") && rs.getString("Remarks").equals("") )){
                            request.setAttribute("hasAppoint", value);
                            RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                            rd2.forward(request,response);
                        }
                        else{
                            sql ="delete from info where username='"+session.getAttribute("username").toString()+"' ";
                            st.executeUpdate( sql );
                            session.invalidate();
                        }
                    
                    }
                
                
                
                   /* String value="";
                     String sql ="select Description,Remarks from info where username='"+session.getAttribute("username").toString()+"' ";
                     ResultSet rs = st.executeQuery(sql);
                     rs.next();
                     if(rs.getString("Description").equals("") && rs.getString("Remarks").equals("") ){
                        request.setAttribute("hasAppoint", value);
                        RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                        rd2.forward(request,response);
                    }
                    else{
                        sql ="select Doctor from info";
                        rs = st.executeQuery(sql);
                        while(rs.next()){
                            if(rs.getString("Doctor").equals(session.getAttribute("username").toString())){
                                request.setAttribute("hasAppoint", value);
                                RequestDispatcher rd2 = request.getRequestDispatcher("doctor_detail.jsp");
                                rd2.forward(request,response);
                            }
                        }
                        sql ="delete from info where username='"+session.getAttribute("username").toString()+"' ";
                        st.executeUpdate( sql );
                        session.invalidate();    
                    }*/
                }
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment
        %>
        
        <jsp:include page="head.html" />
        
            <div class="row">
                <div class="col m6 offset-m3">
                    <div class="card green lighten-5">
                        <div class="card-content" style="padding-bottom:0px">
                            <h3 style="text-align: center;font-family: 'Brush Script MT', cursive;"><b>Account Deleted Successfully</b></h3>
                            <div class="center-align"><br><br><br>
                                <button type="button" class="btn"  ><a style="color: white" href="login.jsp">SignIN Page</a></button><br><br>                   
                            </div>             
                        </div>
                    </div>
                </div>
             </div>       
    </body>
</html>

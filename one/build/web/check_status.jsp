<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admit</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <script type="text/javascript" src="JavaScript.js"></script>
        <jsp:include page="head.html" />
        <%!
            String description;
            String doctor;
            String remarks;
            String docname;
            String cat;
        %>
        <%
           
           //session managment
               session =request.getSession(false);
            if(session!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    if(!"patient".equals(session.getAttribute("type").toString())){
                        response.sendRedirect("login.jsp");
                    }
                    else{
                        //JDBC Connectity
                        ServletContext context=getServletContext(); 
                        Class.forName(context.getInitParameter("connecter"));
                        Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
                        PreparedStatement select=con.prepareStatement("Select * from info where UserName=? ");
                        //JDBC Connectity
                        
                        String value="";
                        select.setString(1,session.getAttribute("username").toString());
                        ResultSet rs = select.executeQuery();
                        rs.next();
                        if(rs.getString("Description")==null || "".equals(rs.getString("Description"))) {
                            request.setAttribute("noAppoint",value);
                            RequestDispatcher rd2 = request.getRequestDispatcher("patient_detail.jsp");
                            rd2.forward(request,response);
                        }
                        else{
                             description=rs.getString("Description");
                             doctor=rs.getString("Doctor");
                             remarks=rs.getString("Remarks");
                             if(remarks==null || remarks.equals(""))
                                 remarks = "NO Remarks yet !!!!";
                            select.setString(1,rs.getString("Doctor"));
                            rs = select.executeQuery();
                            rs.next();
                          //  docname = rs.getString("FirstName")+" "+rs.getString("LastName");
                           // cat     = rs.getString("Category");
                        }
                    }
                }   
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment
 
        
        %>
        
        <div class="row">
            <form class="col s6 offset-m3 green lighten-5">
        <div class="row">
            <br><br>
          <div class="input-field col s12">
              <h><b>Description</b></h>
              <textarea class="materialize-textarea" disabled><%=description%></textarea>
          </div>
        </div>

        <div class="row">
          <div class="input-field col s12">
              <h><b>Doctor Remarks</b></h>
              <textarea class="materialize-textarea" disabled><%=remarks%></textarea>
          </div>
        </div> 
        <div class="col s6 left-align">
              <button type="button" class="btn"><a style="color: white" href="patient_detail.jsp">Back</a></button>
        </div>
        <div class="col s6 right-align">
            <%
                String value="";
                request.setAttribute("",value);%>
              <button type="button" class="btn"><a style="color: white" href="checked">Checked</a></button>
        </div>
      </form>
    </div>
        
    </body>
</html>    
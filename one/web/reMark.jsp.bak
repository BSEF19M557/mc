<%-- 
    Document   : patient
    Created on : Jan 18, 2022, 10:27:00 PM
    Author     : UMAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>remark</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <jsp:include page="head.html" />
       <%!
           ResultSet rs;
       %>
             <%           
           //session managment
               session =request.getSession(false);
            if(session!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                    if("patient".equals(session.getAttribute("type").toString())){
                        response.sendRedirect("login.jsp");
                    }
                    //JDBC Connectity
           ServletContext context=getServletContext(); 
           Class.forName(context.getInitParameter("connecter"));
           Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
           Statement update=con.createStatement();
           //JDBC Connectity
           String query="Select UserName from info where Doctor='"+session.getAttribute("username").toString()+"'"; 
                     rs = update.executeQuery(query );
                }   
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment        
        %>
        
        
        <div class="row">
            <form name="admit" class="col s6 offset-m3 green lighten-5" action="admit" method="post" onsubmit="return validate4()">
        <div class="row">
            <br><br><br> 
          <div class="input-field col s12">
              <textarea name="Des" id="t1" disabled class="materialize-textarea"><%=request.getAttribute("user")%></textarea>
            <label for="textarea2">Description</label>
          </div>
          <div class="input-field col s12">
            <textarea name="Rem" id="t2" class="materialize-textarea"></textarea>
            <label for="textarea2">Description</label>
          </div>
        </div>
 
          
        <div class="col s6 left-align">
              <button type="button" class="btn"><a style="color: white" href="patientForDoc.jsp">Back</a></button>
        </div>
        <div class="col s6 right-align">
              <button type="submit" class="btn" >Appoint</button>
        </div>
      </form>
    </div>     
        
        
    </body>
</html>

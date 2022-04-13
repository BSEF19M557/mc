<%-- 
    Document   : logout
    Created on : Jan 2, 2022, 2:53:45 PM
    Author     : BatMan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            //session managment
            if(request.getSession(false)!=null){
                if(session.getAttribute("type")==null){
                    response.sendRedirect("login.jsp");
                }
                else{
                session.invalidate();    
                response.sendRedirect("login.jsp");
                }
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment

            
        %> 
        
    </body>
</html>

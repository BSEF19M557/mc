<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Detail</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            //session managment
            if(request.getSession(false)!=null){
                if(session.getAttribute("type")==null){
                    String value="";
                    request.setAttribute("expired",value);
                    RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
                    rd2.forward(request,response);
                }
                if(!"patient".equals(session.getAttribute("type").toString())){
                response.sendRedirect("login.jsp");
                }
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment    
        %>
        <jsp:include page="head.html" />
            <div class="row">
                <div class="col m12 ">
                    <div class="card green lighten-5">
                        <div class="card-content" style="padding-bottom:0px">
                            <h3 style="text-align: center;font-family: 'Brush Script MT', cursive;">Welcome <b><%out.print(" "+session.getAttribute("name"));%></b></h3>
                            
                            <center><span style="color:  green"><b><% 
                                
                                if((request.getAttribute("updated")!=null))
                                    out.print("Successfully Updated !!");
                                if((request.getAttribute("admit")!=null))
                                    out.print("Successfully appointed !!");
                                if((request.getAttribute("cancelled")!=null))
                                    out.print("Appointment Cancelled successfully !!");
                     
                                %></b>
                            </span></center>
                            <center><span style="color:  red"><b><% 
                                
                                if((request.getAttribute("noAppoint")!=null))
                                    out.print("You Didn't have any appoitment !!");                     
                                if((request.getAttribute("hasAppoint")!=null))
                                    out.print("Can't Delete Untill You Have an Appointment !!");                     
                                %></b>
                            </span></center>
                            
                            <div class="form">
                                <form>
                                    <div class="row">
                                        <form class="col s12">
                                            <div class="row">
                                                <div class="input-field col s2" >
                                                  <button type="button" class="btn"><a style="color: white" href="update_account">Edit Account</a></button><br><br>
                                                  <button type="button" class="btn"><a style="color: white" href="del_account.jsp">Del Account</a></button><br><br>
                                                  <button type="button" class="btn"><a style="color: white" href="logout.jsp">Logout</a></button><br><br>
                                                </div>
                                                <div class="input-field col s8" id="default" >
                                                  <h>`</h>
                                                </div>
                                                <div class="input-field col s2 right-align" >
                                                    <button type="button" class="btn"><a style="color: white" href="admit.jsp">Appointment</a></button><br><br>
                                                    <button type="button" class="btn"><a style="color: white" href="cancel_Apint">Cancel Apint</a></button><br><br>
                                                    <button type="button" class="btn"><a style="color: white" href="check_status.jsp">check Status </a></button><br><br>
                                                </div>
                                            </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>    
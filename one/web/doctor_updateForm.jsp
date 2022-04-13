
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>form</title>
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
                if(!"doctor".equals(session.getAttribute("type"))){
                    response.sendRedirect("login.jsp");
                }
                else{
                    if(request.getAttribute("fromupdate")==null ){
                       response.sendRedirect("login.jsp");
                    }
                }
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment

            
        %>

        
        <script type="text/javascript" src="JavaScript.js"></script>
        <jsp:include page="head.html" /> 
        <div class="container">
            <div class="row">
                <div class="col m8 offset-m2">
                    <div class="card green lighten-5">
                        <div class="card-content" style="padding-bottom:0px">
                            <h3 style="text-align: center;font-family: 'Brush Script MT', cursive;">Edit</h3>                            
                            <center><span style="color: red "><b><%                                 
                                if((request.getAttribute("jsOff")!=null))
                                    out.print("Invalid Values in Some Fields !!");
                                %></b>
                            </span></center>                           
                            <div class="form">
                                <form name="form1" action="update_qury" method="post" onsubmit="return validate3()">
                                      <div class="row">
                                        <form class="col s12">
                                          <div class="row">
                                            <div class="input-field col s4">
                                                <input id="i1" type="text" name="fName" class="validate" value="<% out.print(request.getAttribute("FName")); %>">
                                              <label for="i1">First Name</label>
                                            </div>
                                            <div class="input-field col s4">
                                              <input id="i2" type="text" name="lName" class="validate" value="<% out.print(request.getAttribute("LName")); %>">
                                              <label for="i2">Last Name</label>
                                            </div>
                                            <div class="input-field col s4">
                                                <input id="i3" type="text" name="uName" disabled="true" class="validate" value="<% out.print(request.getAttribute("UName")); %>">
                                              <label for="i3">User Name</label>
                                            </div>
                                           <div class="input-field col s4">
                                              <input id="i4" type="tel" name="mNumber" class="validate" onKeyPress="return letternumber(event)" value="<% out.print(request.getAttribute("Mobile")); %>">
                                              <label for="i4">Mobile Number</label>
                                            </div>
                                            <div class="input-field col s4">
                                              <input id="i5" type="password" name="pass" class="validate" value="<% out.print(request.getAttribute("Pass")); %>">
                                              <label for="i5">Password</label>
                                            </div>
                                            <div class="input-field col s4">
                                              <input id="i6" type="password" name="conPass" class="validate" value="<% out.print(request.getAttribute("Pass")); %>">
                                              <label for="i6">Conform Password</label>
                                            </div>
                                           <div class="input-field col s12">
                                               <span><b>Select Category</b></span><br>
                                               <span>
                                                <label>
                                                    <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("General-Doctor"))out.print("checked"); %> value="General-Doctor" />
                                                  <span>General Doctor</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("Cardiologist"))out.print("checked"); %>  value="Cardiologist" />
                                                  <span>Cardiologist&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("Ophthalmologist"))out.print("checked"); %> value="Ophthalmologist" />
                                                  <span>Ophthalmologist</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                    <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("Gynecologist"))out.print("checked"); %> value="Gynecologist" />
                                                  <span>Gynecologist&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("Dermatologist"))out.print("checked"); %> value="Dermatologist" />
                                                  <span>Dermatologist</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="group" type="radio" disabled <% if(request.getAttribute("Category")==null); else if(request.getAttribute("Category").equals("Psychologist"))out.print("checked"); %> value="Psychologist" />
                                                  <span>Psychologist</span>
                                                </label>
                                              </span>
                                            </div>
                                            
                                              <div class="input-field col s6">
                                              <input id="i7" type="text" name="address" class="validate" value="<% out.print(request.getAttribute("Address")); %>">
                                              <label for="i7">Address</label>
                                            </div>
                                            <div class="input-field col s6">
                                              <input id="i8" type="email" name="mail" class="validate" value="<% out.print(request.getAttribute("Email")); %>">
                                              <label for="i8">Email</label>
                                            </div>
                                           
                                              
                                              <div class="input-field col s4" style="text-align: left">
                                                  <button  class="btn" ><a style="color: white" href="doctor_detail.jsp">Back</a></button>
                                              </div>
                                              <div class="input-field col s8" style="text-align: right">
                                                  <button type="submit" class="btn" >Update</button>
                                              </div>
                                            </div>  
                                        </div>
                                </form>
                            </div>
                        </div>
                    </div>
                        
                </div>

            </div>

        </div>
    </body>
</html>

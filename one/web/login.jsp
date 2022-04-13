<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <script type="text/javascript" src="JavaScript.js"></script>
        <jsp:include page="head.html" />
        
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">
                    <div class="card green lighten-5">
                        <div class="card-content" style="padding-bottom:0px">
                            <h3 style="text-align: center;font-family: 'Brush Script MT', cursive;">Login</h3>
                            
                            <center><span style="color: red "><b><% 
                                
                                if((request.getAttribute("iUser")!=null))
                                    out.print("User Name Not Found!!");
                                
                                if((request.getAttribute("iPass")!=null))
                                    out.print("Invalid Password !!");
                                
                                if((request.getAttribute("jsOff")!=null))
                                    out.print("Invalid values in field !!");
                                if((request.getAttribute("expired")!=null))
                                    out.print("session was expired login again!!");
                     
                                %></b>
                            </span></center>
                            
                            <div class="form">
                                <form name="signin" action="create_validation" method="post" onsubmit="return validate2()">
                                      <div class="row">
                                        <form class="col s12">
                                          <div class="row">
                                            <div class="input-field col s6">
                                                <input id="i3" type="text" name="uName" class="validate">
                                              <label for="i3">User Name</label>
                                            </div>
                                            <div class="input-field col s6">
                                                <input id="i5" type="password" name="pass" class="validate">
                                              <label for="i5">Password</label>
                                            </div>
                                            <div>
                                               <input id="hide" type="text" name="hide" hidden="true" value="login" class="validate">
                                            </div>
                                            <div class="input-field col s6" style="text-align: left">
                                                  <label>Sign Up</label><br><br>
                                                  <button  class="btn" ><a style="color: white" href="Signup.jsp">Patient</a></button><br><br>
                                                  <button  class="btn" ><a style="color: white" href="Signupdoc.jsp">Doctor</a></button>
                                            </div>
                                            <div class="input-field col s6" style="text-align: right">
                                                  <button type="submit" class="btn" >Sign In</button>
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
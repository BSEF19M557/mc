
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="images/logo.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
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
                            <h3 style="text-align: center;font-family: 'Brush Script MT', cursive;">Patient Account</h3>
                            <center><span style="color: red "><b><% 
                                
                                if((request.getAttribute("jsOff")!=null))
                                    out.print("Invalid Values in Some Fields !!");
                                
                                if((request.getAttribute("uExist")!=null))
                                    out.print("User Name Already Exist !!");
                                
                                %></b>
                                </span></center>
                                
                                </span></center>
                            <center><span style="color: green "><b><% 
                                
                                if((request.getAttribute("success")!=null))
                                    out.print("Account Created SuccessFully !!");
                                  
                                %></b>
                            </span></center>
                                
                            <div class="form">
                                <form name="signUp" action="create_validation" method="post" onsubmit="return validate()">
                                      <div class="row">
                                        <form class="col s12">
                                          <div class="row">
                                            <div class="input-field col s6">
                                                <input id="i1" type="text" name="fName" class="validate">
                                              <label for="i1">First Name</label>
                                            </div>
                                             <div>
                                                <input id="hide" type="text" name="hide" hidden="true" value="Signup" class="validate">
                                            </div> 
                                            <div class="input-field col s6">
                                              <input id="i2" type="text" name="lName" class="validate">
                                              <label for="i2">Last Name</label>
                                            </div>
                                            <div class="input-field col s6">
                                              <input id="i3" type="text" name="uName" class="validate">
                                              <label for="i3">User Name</label>
                                            </div>
                                           <div class="input-field col s6">
                                              <input id="i4" type="tel" name="mNumber" class="validate" onKeyPress="return letternumber(event)">
                                              <label for="i4">Mobile Number</label>
                                            </div>
                                            <div class="input-field col s6">
                                              <input id="i5" type="password" name="pass" class="validate">
                                              <label for="i5">Password</label>
                                            </div>
                                            <div class="input-field col s6">
                                              <input id="i6" type="password" name="conPass" class="validate">
                                              <label for="i6">Conform Password</label>
                                            </div>
                                              <div class="input-field col s6" style="text-align: left">
                                                  <button  class="btn" ><a style="color: white" href="login.jsp">Back</a></button>
                                              </div>
                                              <div class="input-field col s6" style="text-align: right">
                                                  <button type="submit" class="btn" >Sign Up</button>
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

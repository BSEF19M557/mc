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
        <script>
            function validate4(){
    
                if ( document.getElementById("t1").value == "" ){
                    document.getElementById("t1").style.borderColor='red';	
                    return false;
                }
                else{
                    document.getElementById("t1").style.borderColor='';
                    return true;
                }
}
        </script>
    </head>
    <body>
        <script type="text/javascript" src="JavaScript.js"></script>
        <jsp:include page="head.html" />
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
                String value="";
                    session.setAttribute("admit",value);

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
        <div class="col s12 right-align">
              <center><span style="color:  red"><b><% 
                if((request.getAttribute("jsOff")!=null))
                    out.print(" Description cant be null!!");
                if((request.getAttribute("noDoc")!=null))
                    out.print(" Sorry No Doctor  avaible for Selected Category !!");
                if((request.getAttribute("appointed")!=null))
                    out.print(" You All ready have an appointment !!");
                if((request.getAttribute("marks")!=null))
                    out.print(" Check Your Previous Appoint Remarks !!");
                 %></b>
              </span></center>
        </div> 
          <div class="input-field col s12">
            <textarea name="Des" id="t1" class="materialize-textarea"></textarea>
            <label for="textarea2">Description</label>
          </div>
        </div>
          
         <div class="input-field col s12">
                                               <span><b>Select Category</b></span><br>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" checked value="General-Doctor" />
                                                  <span>General Doctor</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" value="Cardiologist" />
                                                  <span>Cardiologist&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" value="Ophthalmologist" />
                                                  <span>Ophthalmologist</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" value="Gynecologist" />
                                                  <span>Gynecologist&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" value="Dermatologist" />
                                                  <span>Dermatologist</span>
                                                </label>
                                              </span>
                                               <span>
                                                <label>
                                                  <input class="with-gap" name="g3" type="radio" value="Psychologist" />
                                                  <span>Psychologist</span>
                                                </label>
                                              </span>
                                            </div> 
          
        <div class="col s6 left-align">
              <button type="button" class="btn"><a style="color: white" href="patient_detail.jsp">Back</a></button>
        </div>
        <div class="col s6 right-align">
              <button type="submit" class="btn" >Appoint</button>
        </div>
      </form>
    </div>
        
    </body>
</html>    
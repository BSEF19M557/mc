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
        <title>patients</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <jsp:include page="head.html" />
       <%!
           ResultSet rs,rs1;
           PreparedStatement select;
           int a=1;
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
                    else{
                        //JDBC Connectity
                        ServletContext context=getServletContext(); 
                        Class.forName(context.getInitParameter("connecter"));
                        Connection con=DriverManager.getConnection(context.getInitParameter("url"),context.getInitParameter("dbname"),context.getInitParameter("dbpass"));
                        Statement update=con.createStatement();
                        //JDBC Connectity
                        String query="Select UserName from info where Doctor='"+session.getAttribute("username").toString()+"'"; 
                        rs = update.executeQuery(query );
                        select=con.prepareStatement("Select * from info where UserName=? ");         
                    }
                }   
            }
            else{
                response.sendRedirect("login.jsp");
            }
            //session managment        
        %>
        
        
        <div class="row center-align">
            <div class="col s12 green lighten-5" >
                <div class="row left-align col s10"> 
                    <button type="button" class="btn"><a style="color: white" href="doctor_detail.jsp">Back</a></button>
                </div>
                <form  action="search" method="post">
                <div class="row right-align col s2">
                    <input  type="text" name="uName" placeholder="search" class="validate right-align">
                    <input  type="text" name="hehe" hidden="true" value="<%=session.getAttribute("username").toString() %>" class="validate right-align">
                    <button type="submit" class="btn" >Go</button>
                </div> 
                </form>
            </div>
            
            
            <form class="col s6 offset-m3 green lighten-5" action="remark" method="post" onsubmit="return validate4()">
            <div class="row">
                <br><br><br>
            </div>
                <h4>Patients</h4>      
                <center><span style="color: red "><b><% 
                                
                    if((request.getAttribute("jsOff")!=null))
                        out.print("Filed can be empty!!");
                    %></b>
                </span></center>
                <center><span style="color: green "><b><% 
                                
                     if((request.getAttribute("remarked")!=null))
                         out.print("Patient discharged!!");
                     %></b>
                </span></center>
                     <%if(request.getAttribute("Search")!=null){%>            
                <div class="row">
                    <%=request.getAttribute("Search")%>
                    <div class="input-field col s12">
                        <textarea name="Des" id="t1" disabled class="materialize-textarea"><%out.print(request.getAttribute("descri"));%></textarea>
                    <label for="textarea2">Description</label>
                  </div>
                  <div class="input-field col s12">
                    <textarea name="Rem" id="t2" class="materialize-textarea"></textarea>
                    <label for="textarea2">Remarks</label>
                  </div>
                </div>
                <div class="col s12 right-align">
                      <button type="submit" class="btn" >Give Remark</button>
                </div>
                    
                    <% out.print("<b>Other Patients </b>"); }%>
                   <%if(request.getAttribute("search")!=null){
                    out.print(" Search Empty <br><br>");
                    out.print("<b>Other Patients </b>");
                    
                   }%> 
                            
            <%while(rs.next()){
                a++;
                select.setString(1,rs.getString("UserName"));
                rs1 = select.executeQuery();
                rs1.next();
                
            %>
            <div class="row">        
                <form name="hehe" class="col s6 offset-m3 green lighten-5" action="remark" method="post" onsubmit="return validate4()">
                <div class="row">
                    <br><br><br>
                    <div>
                        <input  type="text" name="uName" hidden="true" value="<%=rs1.getString("UserName")%>" class="validate">
                    </div>
                    <%=rs1.getString("UserName")%>
                  <div class="input-field col s12">
                      <textarea name="Des" id="t1" disabled class="materialize-textarea"><%=rs1.getString("Description")%></textarea>
                    <label for="textarea2">Description</label>
                  </div>
                  <div class="input-field col s12">
                    <textarea name="Rem" id="t2" class="materialize-textarea"></textarea>
                    <label for="textarea2">Remarks</label>
                  </div>
                </div>
                <div class="col s12 right-align">
                      <button type="submit" class="btn" >Give Remark</button>
                </div>
              </form>
            </div>
            
            <%} if(a==1){out.print("NO Patient till Now");}%>             
        </div>     
        
        
    </body>
</html>

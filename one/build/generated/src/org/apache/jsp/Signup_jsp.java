package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

   
        boolean ali (int n){  
            return true; 
        }
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"images/logo.png\"> \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sign up</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\" src=\"JavaScript.js\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.html", out, false);
      out.write(" \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col m6 offset-m3\">\n");
      out.write("                    <div class=\"card green lighten-5\">\n");
      out.write("                        <div class=\"card-content\" style=\"padding-bottom:0px\">\n");
      out.write("                            <h3 style=\"text-align: center;font-family: 'Brush Script MT', cursive;\">Patient Account</h3>\n");
      out.write("                            <div class=\"form\">\n");
      out.write("                                <form name=\"signUp\" action=\"create_account.jsp\" method=\"post\" onsubmit=\"return validate()\">\n");
      out.write("                                      <div class=\"row\">\n");
      out.write("                                        <form class=\"col s12\">\n");
      out.write("                                          <div class=\"row\">\n");
      out.write("                                            <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i1\" type=\"text\" class=\"validate\">\n");
      out.write("                                              <label for=\"i1\">First Name</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i2\" type=\"tel\" class=\"validate\">\n");
      out.write("                                              <label for=\"i2\">Last Name</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i3\" type=\"text\" class=\"validate\">\n");
      out.write("                                              <label for=\"i3\">User Name</label>\n");
      out.write("                                            </div>\n");
      out.write("                                           <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i4\" type=\"tel\" class=\"validate\" onKeyPress=\"return letternumber(event)\">\n");
      out.write("                                              <label for=\"i4\">Mobile Number</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i5\" type=\"password\" class=\"validate\">\n");
      out.write("                                              <label for=\"i5\">Password</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"input-field col s6\">\n");
      out.write("                                              <input id=\"i6\" type=\"password\" class=\"validate\">\n");
      out.write("                                              <label for=\"i6\">Conform Password</label>\n");
      out.write("                                            </div>\n");
      out.write("                                              <div class=\"input-field col s6\" style=\"text-align: left\">\n");
      out.write("                                                  <button  class=\"btn\" ><a style=\"color: white\" href=\"login.jsp\">Back</a></button>\n");
      out.write("                                              </div>\n");
      out.write("                                              <div class=\"input-field col s6\" style=\"text-align: right\">\n");
      out.write("                                                  <button type=\"submit\" class=\"btn\" >Sign Up</button>\n");
      out.write("                                              </div>\n");
      out.write("                                            </div>  \n");
      out.write("                                        </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

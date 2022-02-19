package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Student Attendance System</title>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("<link\n");
      out.write("\thref=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    #login-alert{\n");
      out.write("        width: auto;\n");
      out.write("        margin: auto;\n");
      out.write("    }\n");
      out.write("    #loginbox{\n");
      out.write("        margin-top: 150px;\n");
      out.write("        margin-bottom: 50px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    #bbt:hover{\n");
      out.write("        background:#09C;\n");
      out.write("    }\n");
      out.write("    input[type=text], select {\n");
      out.write("  width: 100%;\n");
      out.write("  padding: 12px 20px;\n");
      out.write("  margin: 8px 0;\n");
      out.write("  display: inline-block;\n");
      out.write("  border: 1px solid #ccc;\n");
      out.write("  border-radius: 4px;\n");
      out.write("  box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=submit] {\n");
      out.write("  cursor:pointer;\n");
      out.write("\twidth:100%;\n");
      out.write("\tborder:none;\n");
      out.write("\tbackground:#0492C2;\n");
      out.write("\tcolor:#FFF;\n");
      out.write("\tmargin:8px 0 5px;\n");
      out.write("\tpadding:10px;\n");
      out.write("\tfont-size:15px;\n");
      out.write("}\n");
      out.write("input[type=password] {\n");
      out.write("  width: 100%;\n");
      out.write("  padding: 12px 20px;\n");
      out.write("  margin: 8px 0;\n");
      out.write("  display: inline-block;\n");
      out.write("  border: 1px solid #ccc;\n");
      out.write("  border-radius: 4px;\n");
      out.write("  box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#ch{\n");
      out.write("    font-size: 15px;\n");
      out.write("    font-style: italic;\n");
      out.write("}\n");
      out.write("input[type=submit]:hover {\n");
      out.write("  background:#09C;\n");
      out.write("}\n");
      out.write("\n");
      out.write("div {\n");
      out.write("  border-radius: 5px;\n");
      out.write("  background-color: #f2f2f2;\n");
      out.write("  padding: 20px;\n");
      out.write("  width: 600px;\n");
      out.write("    margin: auto;\n");
      out.write("    margin-top: 180px;\n");
      out.write("}\n");
      out.write("label{\n");
      out.write("    font-size: 13px;\n");
      out.write("    color: gray;\n");
      out.write("}\n");
      out.write("h4{\n");
      out.write("    font-style: italic;\n");
      out.write("    \n");
      out.write("    margin-left: 370px;\n");
      out.write("}\n");
      out.write(".navbar-header{\n");
      out.write("   color: blue; \n");
      out.write("   font-size: 15px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("</head>\n");
      out.write("<body\n");
      out.write("\tstyle=\"background-image: url(bb.jpg); background-size:1860px; background-repeat: no-repeat\">\n");
      out.write("\t<nav class=\"navbar navbar-expand-sm bg-white background:#0065A2\">\n");
      out.write("\t\t<!-- Brand/logo -->\n");
      out.write("\t\t<img src=\"logo.jpg\" width=\"120px\" height=\"70px\" /> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"empLogin.jsp\"><strong><span class=\"glyphicon glyphicon-user\"></span>&nbsp;Employee Login</strong></a> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"index.jsp\"><strong><span class=\"glyphicon glyphicon-user\"></span>&nbsp;Admin Login</strong></a> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"\">&nbsp;</a> <a class=\"navbar-brand\"\n");
      out.write("\t\t\thref=\"\">&nbsp;</a> <a class=\"navbar-brand\" href=\"\">&nbsp;</a> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"\">&nbsp;</a> <a class=\"navbar-brand\"\n");
      out.write("\t\t\thref=\"\">&nbsp;</a> <a class=\"navbar-brand\" href=\"\">&nbsp;</a> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"\">&nbsp;</a> <a class=\"navbar-brand\"\n");
      out.write("\t\t\thref=\"\">&nbsp;</a> <a class=\"navbar-brand\" href=\"\">&nbsp;</a> <a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"\">&nbsp;</a> <a class=\"navbar-brand\"\n");
      out.write("\t\t\thref=\"\">&nbsp;</a><a class=\"navbar-brand\" href=\"\">&nbsp;</a><a\n");
      out.write("\t\t\tclass=\"navbar-brand\" href=\"\"><strong>");
      out.print((new java.util.Date()).toLocaleString());
      out.write("</strong></a> &nbsp; &nbsp; &nbsp; &nbsp;\n");
      out.write("                         <h4 class=\"navbar-header\"> <strong>Hello Admins</strong></h4>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\t\t<!-- Links -->\n");
      out.write("\t</nav>\n");
      out.write("\t<div>\n");
      out.write("  <form action=\"adminValidation.jsp\">\n");
      out.write("    <label for=\"uname\">User Name</label>\n");
      out.write("    <input type=\"text\" id=\"uname\" name=\"uname\">\n");
      out.write("\n");
      out.write("    <label for=\"id\">User ID</label>\n");
      out.write("    <input type=\"text\" id=\"name\" name=\"idd\">\n");
      out.write("\n");
      out.write("    <label for=\"pass\">Password</label>\n");
      out.write("    <input type=\"password\" id=\"pass\" name=\"pass\">\n");
      out.write("    <input type=\"checkbox\" id=\"ch\" onclick=\"myFunction()\"> <b>Show Password</b>\n");
      out.write("      \n");
      out.write("    \n");
      out.write("    <input type=\"submit\" value=\"Log in\">\n");
      out.write("  </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("   <script>\n");
      out.write("            $('.btn').click(function () {\n");
      out.write("                $(this).toggleClass(\"click\");\n");
      out.write("                $('.sidebar').toggleClass(\"show\");\n");
      out.write("            });\n");
      out.write("            $('.recru-btn').click(function () {\n");
      out.write("                $('nav ul .recru-show').toggleClass(\"show\");\n");
      out.write("                $('nav ul .first').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('.affairs-btn').click(function () {\n");
      out.write("                $('nav ul .affairs-show').toggleClass(\"show1\");\n");
      out.write("                $('nav ul .second').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $('.eva-btn').click(function () {\n");
      out.write("                $('nav ul .eva-show').toggleClass(\"show2\");\n");
      out.write("                $('nav ul .third').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('.payroll-btn').click(function () {\n");
      out.write("                $('nav ul .pay-show').toggleClass(\"show3\");\n");
      out.write("                $('nav ul .forth').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('.employee-btn').click(function () {\n");
      out.write("                $('nav ul .emp-show').toggleClass(\"show4\");\n");
      out.write("                $('nav ul .fifth').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $('.pro-btn').click(function () {\n");
      out.write("                $('nav ul .pro-show').toggleClass(\"show6\");\n");
      out.write("                $('nav ul .sixth').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('nav ul li').click(function () {\n");
      out.write("                $(this).addClass(\"active\").siblings().removeClass(\"active\");\n");
      out.write("            });\n");
      out.write("            function myFunction() {\n");
      out.write("  var x = document.getElementById(\"pass\");\n");
      out.write("  if (x.type === \"password\") {\n");
      out.write("    x.type = \"text\";\n");
      out.write("  } else {\n");
      out.write("    x.type = \"password\";\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("        </script>\n");
      out.write("</body>\n");
      out.write("\n");
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

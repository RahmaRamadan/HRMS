package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Application.EmployeesAffairs.Employees_Affairs;
import Entity.Employee_Data;
import java.util.ArrayList;
import DataAccess.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("+\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee Registration</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"  >\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');\n");
      out.write("\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                background-image: url('p4.jpg');\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-attachment: fixed;\n");
      out.write("                background-size: 100% 100%;\n");
      out.write("                font-family:\"Open Sans\", Helvetica, Arial, sans-serif;\n");
      out.write("                font-weight:300;\n");
      out.write("                font-size: 12px;\n");
      out.write("                line-height:30px;\n");
      out.write("                color:#777;\n");
      out.write("                background:window;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            * {\n");
      out.write("                margin:0;\n");
      out.write("                padding:0;\n");
      out.write("                user-select: none;   \n");
      out.write("                font-family: 'Poppins', sans-serif;\n");
      out.write("                box-sizing:border-box;\n");
      out.write("                -webkit-box-sizing:border-box;\n");
      out.write("                -moz-box-sizing:border-box;\n");
      out.write("                -webkit-font-smoothing:antialiased;\n");
      out.write("                -moz-font-smoothing:antialiased;\n");
      out.write("                -o-font-smoothing:antialiased;\n");
      out.write("                font-smoothing:antialiased;\n");
      out.write("                text-rendering:optimizeLegibility;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("           \n");
      out.write("            .btn-suc{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 100px;\n");
      out.write("                left: 40px;\n");
      out.write("                height: 45px;\n");
      out.write("                width: 45px;\n");
      out.write("                text-align: center;\n");
      out.write("                background: #eae9e9;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: left 0.4s ease;\n");
      out.write("            }\n");
      out.write("            .btn-suc.click{\n");
      out.write("                left: 220px;\n");
      out.write("            }\n");
      out.write("            .btn-suc span{\n");
      out.write("                color: #0492C2;\n");
      out.write("                font-size: 28px;\n");
      out.write("                line-height: 40px;\n");
      out.write("            }\n");
      out.write("            .btn-suc.click span:before{\n");
      out.write("                content: '\\f00d';\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            .text{\n");
      out.write("                background: gray;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .container {\n");
      out.write("                max-width:800px;\n");
      out.write("                width:100%;\n");
      out.write("                margin:0 auto;\n");
      out.write("                position:relative;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            .btn-success1{\n");
      out.write("                background-color:#0492C2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn-success1:hover{\n");
      out.write("                background-color:cornflowerblue;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-group{\n");
      out.write("                font-size: 15px;\n");
      out.write("                font-style:normal;\n");
      out.write("            }\n");
      out.write("            h2{\n");
      out.write("                color:#0492C2;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");


            Connection con;
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
               try {
                   
                   Employee_Data emp = new Employee_Data(request.getParameter("id"),request.getParameter("first_name"),
                   request.getParameter("last_name"),request.getParameter("gender"),request.getParameter("username"),request.getParameter("password"),
                   request.getParameter("address"),request.getParameter("salary"), request.getParameter("position"),
                   request.getParameter("numOfVacations"), request.getParameter("hiring_date"), request.getParameter("age"),
                   request.getParameter("empType"),request.getParameter("dep_id"),request.getParameter("type"), request.getParameter("hrComponent") );
                
                 boolean updateEmployees = new Employees_Affairs().updateEmployee(emp);
                 
                 if (updateEmployees && !(request.getParameter("id").equals(""))) {
                    color = "blue"; 
                    message = "Employee Updated Successfully";
                    
                } else {
                    color = "red";
                    message = "Error Occured";
                }

                } catch (Exception ex) {
                    out.println("ex: " + ex);
                    
                }
            }
        
      out.write("\n");
      out.write("        <div class=\"form-group col-12 p-0\">\n");
      out.write("            <h4 style =\"color: ");
      out.print( color);
      out.write('"');
      out.write('>');
      out.print( message);
      out.write("</h4>\n");
      out.write("        </div>\n");
      out.write("        <form id=\"form\" method=\"post\" action=\"update.jsp\" class=\"form-horizontal\">\n");
      out.write("            ");

                PreparedStatement pat;
                ResultSet rs;
                
                con = DatabaseConnection.getConnection();
                String id = request.getParameter("id");
                pat = con.prepareStatement("select * from employee where id = ?");
                pat.setString(1, id);
                rs = pat.executeQuery();
                while (rs.next()) {

            
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <h2 style=\"text-align: center\">Employee Details</h2>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <hr/>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"id\"> ID </label>\n");
      out.write("                    <input type=\"text\" name=\"id\" class=\"form-control\" id =\"id\"  value = \"");
      out.print( rs.getString("id"));
      out.write("\">\n");
      out.write("\n");
      out.write("                </div>     \n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"firstname\"> First Name </label>\n");
      out.write("                    <input type=\"text\" name=\"first_name\" class=\"form-control\" id =\"first\"  value = \"");
      out.print(rs.getString("first_name"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"lastname\"> Last Name </label>\n");
      out.write("                    <input type=\"text\" name=\"last_name\" class=\"form-control\" id =\"last\"  value = \"");
      out.print(rs.getString("last_name"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"gender\"> Gender </label>\n");
      out.write("                    <input type=\"text\" list=\"genderr\" autocomplete=\"off\" name=\"gender\" class=\"form-control\" id =\"last\"  value = \"");
      out.print(rs.getString("gender"));
      out.write("\">\n");
      out.write("                    <datalist id=\"genderr\">\n");
      out.write("                        <option>Male</option>\n");
      out.write("                        <option>Female</option>\n");
      out.write("                    </datalist>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"username\"> User Name </label>\n");
      out.write("                    <input type=\"text\" name=\"username\" class=\"form-control\" id =\"uname\"  value = \"");
      out.print(rs.getString("username"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"password\"> Password </label>\n");
      out.write("                    <input type=\"text\" name=\"password\" class=\"form-control\" id =\"pass\"  value = \"");
      out.print(rs.getString("password"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"address\"> Address</label>\n");
      out.write("                    <input type=\"text\" name=\"address\" class=\"form-control\" id =\"addressE\"  value = \"");
      out.print(rs.getString("address"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"salary\"> Salary </label>\n");
      out.write("                    <input type=\"text\" name=\"salary\" class=\"form-control\" id =\"salary\"  value = \"");
      out.print(rs.getString("salary"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"position\"> Position </label>\n");
      out.write("                    <input type=\"text\" name=\"position\" class=\"form-control\" id =\"position\"  value = \"");
      out.print(rs.getString("position"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"numOfVacations\"> Number of Vacation days available </label>\n");
      out.write("                    <input type=\"text\" name=\"numOfVacations\" class=\"form-control\" id =\"numOfVacations\"  value = \"");
      out.print(rs.getString("numOfVacations"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"hiring_date\"> Hiring Date </label>\n");
      out.write("                    <input type=\"text\" name=\"hiring_date\" class=\"form-control\" id =\"hiring_date\"  value = \"");
      out.print(rs.getString("hiring_date"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"age\"> Age </label>\n");
      out.write("                    <input type=\"text\" name=\"age\" class=\"form-control\" id =\"age\"  value = \"");
      out.print(rs.getString("age"));
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"empType\"> Type </label>\n");
      out.write("                    <input type=\"text\" list=\"mangOrEmp\" autocomplete=\"off\" name=\"empType\" class=\"form-control\" id =\"empType\"  value = \"");
      out.print(rs.getString("empType"));
      out.write("\">\n");
      out.write("                     <datalist id=\"mangOrEmp\">\n");
      out.write("                        <option>Manager</option>\n");
      out.write("                        <option>Employee</option>\n");
      out.write("                    </datalist>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"dep_id\"> Department ID </label>\n");
      out.write("                    <input type=\"text\" list=\"depID\" autocomplete=\"off\" name=\"dep_id\" class=\"form-control\" id =\"dep_id\"  value = \"");
      out.print(rs.getString("dep_id"));
      out.write("\">\n");
      out.write("                    <datalist id=\"depID\">\n");
      out.write("                <option>HR11</option>\n");
      out.write("                <option>FIN11</option>\n");
      out.write("                <option>MAR11</option>\n");
      out.write("                <option>SAL11</option>\n");
      out.write("                <option>IT11</option>\n");
      out.write("                <option>ACC11</option>\n");
      out.write("                <option>GEN11</option>\n");
      out.write("                </datalist>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"type\"> Department </label>\n");
      out.write("                    <input type=\"text\" list=\"typee\" autocomplete=\"off\" name=\"type\" class=\"form-control\" id =\"type\"  value = \"");
      out.print(rs.getString("type"));
      out.write("\">\n");
      out.write("                    <datalist id=\"typee\">\n");
      out.write("                <option>Human Resources</option>\n");
      out.write("                <option>Finance</option>\n");
      out.write("                <option>Marketing</option>\n");
      out.write("                <option>Sales</option>\n");
      out.write("                <option>Information Technology</option>\n");
      out.write("                <option>Accounting</option>\n");
      out.write("                <option>General</option>\n");
      out.write("                </datalist>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("                 </div>\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <div class=\"col-sm-4\"></div>\n");
      out.write("                <div class=\"col-sm-4 mx-auto\"> \n");
      out.write("                    <label for=\"hrComp\"> HR Component </label>\n");
      out.write("                    <input type=\"text\" list=\"hrComp\" autocomplete=\"off\" name=\"hrComponent\" class=\"form-control\" id =\"hrComponent\"  value = \"");
      out.print(rs.getString("hrComponent"));
      out.write("\">\n");
      out.write("                     <datalist id=\"hrComp\">\n");
      out.write("                <option>Employee Affairs</option>\n");
      out.write("                <option>Recruitment</option>\n");
      out.write("                <option>Payroll</option>\n");
      out.write("                <option>Evaluation</option>\n");
      out.write("                </datalist>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"form-group\" align=\"center\">\n");
      out.write("                <div class=\"col-sm-2\">\n");
      out.write("                    <Button class=\"btn btn-success1\" style=\"width: 120px\">Submit</Button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"col-sm-12\" align=\"center\">\n");
      out.write("            <a href=\"homePage.jsp\"><Button class=\"btn btn-success1\" style=\"width:120px;\">Home </Button> </a>\n");
      out.write("        </div>                          \n");
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

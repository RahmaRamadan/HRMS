package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Application.Payroll.Payrolls;
import Entity.Salary_Data;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class payroll_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee Registration</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"  >\n");
      out.write("        <link rel=\"stylesheet\" href=\"cssPayroll.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"divScroll\">\n");
      out.write("        <div class=\"navBar\">\n");
      out.write("\n");
      out.write("            <a href=\"#\">ABOUT US</a>\n");
      out.write("            <a href=\"#\">SERVICES</a> \n");
      out.write("            <a href=\"careers.jsp\">CAREERS</a>\n");
      out.write("            <a href=\"navBar.jsp\"<i class=\"fa fa-home\"></i> HR HOME</a>\n");
      out.write("            <img class=\"logo\" src = \"logo.jpg\" >\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("        <div class=\"btn btn-suc\">\n");
      out.write("            <span class=\"fas fa-bars\"></span>\n");
      out.write("        </div>\n");
      out.write("        <nav class=\"sidebar\">\n");
      out.write("            <div class=\"text\"> HR System</div>\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"active\"><a href=\"#\">Dashboard</a></li>\n");
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\" class=\"recru-btn\">Recruitment\n");
      out.write("                        <span class=\"fas fa-caret-down first\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"recru-show\">\n");
      out.write("                        <li><a href=\"#\">Post a Job</a></li>\n");
      out.write("                        <li><a href=\"#\">Jobs</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\" class=\"affairs-btn\">Employee Affairs\n");
      out.write("                        <span class=\"fas fa-caret-down second\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"affairs-show\">\n");
      out.write("                        <li><a href=\"add.jsp\">Add Employees</a></li>\n");
      out.write("                        <li><a href=\"showEmployees.jsp\">Show Employees</a></li>\n");
      out.write("                        <li><a href=\"vacation.jsp\">Request Vacation</a></li>\n");
      out.write("                        <li><a href=\"showAnalysis.jsp\">Show Analysis</a></li>\n");
      out.write("                        <li><a href=\"deductions.jsp\">Make Deductions/Rewards</a></li>\n");
      out.write("                        <li><a href=\"AddMonthlySalary.jsp\">Add Monthly Salary</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\" class=\"pro-btn\">Project Management\n");
      out.write("                        <span class=\"fas fa-caret-down sixth\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"pro-show\">\n");
      out.write("                        <li><a href=\"add.jsp\">Add Milestone</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\" class=\"eva-btn\">Evaluation\n");
      out.write("                        <span class=\"fas fa-caret-down third\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"eva-show\">\n");
      out.write("                        <li><a href=\"Score.jsp\">View Scores</a></li>\n");
      out.write("                        <li><a href=\"TrainMang.jsp\">Training Management</a></li> \n");
      out.write("                        <li><a href=\"Trainings.jsp\">View Training</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\" class=\"payroll-btn\">Payroll\n");
      out.write("                        <span class=\"fas fa-caret-down forth\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"pay-show\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\" class=\"employee-btn\">Employees\n");
      out.write("                                <span class=\"fas fa-caret-down fifth\"></span>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"emp-show\">\n");
      out.write("                                <li><a href=\"cashAdvance.jsp\">Cash Advance</a></li>\n");
      out.write("                                <li><a href=\"deductions_1.jsp\">Deductions</a></li>\n");
      out.write("                                <li><a href=\"payroll.jsp\">Payroll</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("           \n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <div class=\"col-sm-4\"></div>\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <h2 style=\"text-align: left \" class=\"head\">Employee's Salary Details</h2> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-2\">\n");
      out.write("            <form action=\"\" method=\"get\"  >\n");
      out.write("                <div class=\"search\">\n");
      out.write("                    <input type=\"text\" class=\"search\" name=\"q\" placeholder=\"Search here...\"/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br/>\n");
      out.write("        <button class=\"print-button\" onclick=\"printDiv('printableArea')\"><span class=\"print-icon\"></span></button>\n");
      out.write("\n");
      out.write("        <div id=\"printableArea\"media=\"print\">\n");
      out.write("\n");
      out.write("            <br/>\n");
      out.write("           \n");
      out.write("            <table class=\"table table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Employee Name</th>\n");
      out.write("                        <th scope=\"col\">Employee ID</th>\n");
      out.write("                        <th scope=\"col\">Gross</th>\n");
      out.write("                        <th scope=\"col\">Deductions</th>\n");
      out.write("                        <th scope=\"col\">Cash Advance</th>\n");
      out.write("                        <th scope=\"col\">Net Pay</th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");


                        try {

                            String search = request.getParameter("q");
                            ArrayList<Salary_Data> salary = new Payrolls().Get_Salary_Data(search);
                            //System.out.println("searrrrrch: "+search);
                            for (int i = 0; i < salary.size(); i++) {


                    
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"row\">");
      out.print( salary.get(i).getEmployeeName());
      out.write(" </th>\n");
      out.write("                        <td> ");
      out.print( salary.get(i).getEmployeeID());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( salary.get(i).getGross());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( salary.get(i).getDeductions());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( salary.get(i).getCashAdv());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( salary.get(i).getNetPay());
      out.write("</td>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <td><a class=\"btn btn-success\" id=\"edit\" href=\"editSalay.jsp?id=");
      out.print( salary.get(i).getEmployeeID());
      out.write("\" role=\"button\">Edit</a>\n");
      out.write("                            <a class=\"btn btn-danger\" id=\"remove\" href=\"removeSalary.jsp?id=");
      out.print( salary.get(i).getEmployeeID());
      out.write("\" role=\"button\">Remove</a>\n");
      out.write("                            <a class=\"btn btn-info\" id=\"info\" href=\"employeeInfo.jsp?id=");
      out.print( salary.get(i).getEmployeeID());
      out.write("\" role=\"button\">Info</a>\n");
      out.write("                            <a class=\"btn btn-info\" id=\"info\" href=\"viewStatistics.jsp?id=");
      out.print( salary.get(i).getEmployeeID());
      out.write("\" role=\"button\">Chart</a>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    ");
 }
                        } catch (Exception ex) {
                            out.println("ex: " + ex);
                            ex.printStackTrace();
                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("                </div>\n");
      out.write("      \n");
      out.write("        <script>\n");
      out.write("\n");
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
      out.write("\n");
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
      out.write("\n");
      out.write("            $('.pro-btn').click(function () {\n");
      out.write("                $('nav ul .pro-show').toggleClass(\"show6\");\n");
      out.write("                $('nav ul .sixth').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('nav ul li').click(function () {\n");
      out.write("                $(this).addClass(\"active\").siblings().removeClass(\"active\");\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("\n");
      out.write("            function printDiv(divName) {\n");
      out.write("                var printContents = document.getElementById(divName).innerHTML;\n");
      out.write("                var originalContents = document.body.innerHTML;\n");
      out.write("\n");
      out.write("                document.body.innerHTML = printContents;\n");
      out.write("\n");
      out.write("                window.print();\n");
      out.write("\n");
      out.write("                document.body.innerHTML = originalContents;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        </div>\n");
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

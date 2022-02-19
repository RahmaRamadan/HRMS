package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class after_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Student Attendance System</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color: #F0F0F0\";>\n");
      out.write("\t");

		if (session.getAttribute("uname") != null && session.getAttribute("uname") != "") {
	
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "student_side_header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"panel panel-default shadow p-3 mb-5\"\n");
      out.write("\t\t\tstyle=\"height: 450px;\">\n");
      out.write("\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t<div class=\"alert alert-info shadow p-3 mb-5\"\n");
      out.write("\t\t\t\t\tstyle=\"text-transform: uppercase\">Welcome To Student Portal</div>\n");
      out.write("\t\t\t\t<div class=\"well col-lg-12 shadow p-3 mb-5\">\n");
      out.write("\t\t\t\t\t<img src=\"images/logo.png\" /><br /> <br /> <br />\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t");

						Connection con;
                                                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system","root","rootPassword12");
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(
								"select student_id,count(case when attendance ='present' then 1 end) as Present_Count,count(case when attendance ='absent' then 1 end) as Absent_Count,count(distinct system_date) as Total_Count from student_attendance where student_id='"
										+ session.getAttribute("student_id") + "' group by student_id");
						while (rs.next()) {
							int id = rs.getInt(1);
							int present_count = rs.getInt(2);
							int absent_count = rs.getInt(3);
							int total_days = rs.getInt(4);
				
      out.write("\n");
      out.write("\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">\n");
      out.write("\t\t\t\t\t<div class=\"shadow p-3 mb-5 bg-white rounded text-center\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-users fa-5x\"></i>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<h3>\n");
      out.write("\t\t\t\t\t\t\t<font color=\"#FF9933\"><span class=\"counter\">");
      out.print(id);
      out.write("</span></font>\n");
      out.write("\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t<strong style=\"text-transform: uppercase; font-size: 12px;\">My Id</strong>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">\n");
      out.write("\t\t\t\t\t<div class=\"shadow p-3 mb-5 bg-white rounded text-center\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-users fa-5x\"></i>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<h3>\n");
      out.write("\t\t\t\t\t\t\t<font color=\"#FF9933\"><span class=\"counter\">");
      out.print(present_count);
      out.write("</span></font>\n");
      out.write("\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t<strong style=\"text-transform: uppercase; font-size: 12px;\">Total\n");
      out.write("\t\t\t\t\t\t\t\tPresent Days</strong>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">\n");
      out.write("\t\t\t\t\t<div class=\"shadow p-3 mb-5 bg-white rounded text-center\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-users fa-5x\"></i>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<h3>\n");
      out.write("\t\t\t\t\t\t\t<font color=\"#FF9933\"><span class=\"counter\">");
      out.print(absent_count);
      out.write("</span></font>\n");
      out.write("\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t<strong style=\"text-transform: uppercase; font-size: 12px;\">Total\n");
      out.write("\t\t\t\t\t\t\t\tAbsent Days</strong>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">\n");
      out.write("\t\t\t\t\t<div class=\"shadow p-3 mb-5 bg-white rounded text-center\">\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-users fa-5x\"></i>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<h3>\n");
      out.write("\t\t\t\t\t\t\t<font color=\"#FF9933\"><span class=\"counter\">");
      out.print(total_days);
      out.write("</span></font>\n");
      out.write("\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t<strong style=\"text-transform: uppercase; font-size: 12px;\">Total\n");
      out.write("\t\t\t\t\t\t\t\tDays</strong>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t");

		} else {
			response.sendRedirect("index.jsp");
		}
	
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
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

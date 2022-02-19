package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dailyAttendance_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Student Attendance System</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.dataTables.css\" />\n");
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
      out.write("\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color: #F0F0F0\";>\n");
      out.write("\t");

		if (session.getAttribute("uname") != null && session.getAttribute("uname") != "") {
	
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_side_header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"panel panel-default shadow p-3 mb-5\">\n");
      out.write("\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t<div class=\"alert alert-info shadow p-3 mb-5\"\n");
      out.write("\t\t\t\t\tstyle=\"text-transform: uppercase\">Attendance Reports / Daily\n");
      out.write("\t\t\t\t\tAttendance Report</div>\n");
      out.write("\t\t\t\t<div class=\"panel panel shadow p-3 mb-5\">\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading bg-light\"\n");
      out.write("\t\t\t\t\t\tstyle=\"text-transform: uppercase; font-size: small; font-weight: bold;\">\n");
      out.write("\t\t\t\t\t\tDaily Attendance Report&nbsp;&nbsp;&nbsp;[&nbsp;");
      out.print((new java.util.Date()).toLocaleString());
      out.write("&nbsp;]&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t<form action=\"dailyAttendance.jsp\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-row\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group col-md-3\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type='date' class=\"form-control\" id=\"sdate\" name=\"sdate\">\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group col-md-4\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"Search\">\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<table id=\"table\" class=\"table table-bordered\">\n");
      out.write("\t\t\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Student Id</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Student Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Today's Present</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Today's Absent</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

											boolean found = false;
											String sdate = request.getParameter("sdate");
											if (sdate != null) {
												Connection con;
                                                                                                Class.forName("com.mysql.jdbc.Driver");
                                                                                                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system","root","rootPassword12");
												Statement st = con.createStatement();
												ResultSet rs = st.executeQuery(
														"select employee.id,employee.first_name,employee.last_name,count(case when attendance ='present' then 1 end) as Present_Count,count(case when attendance ='absent' then 1 end) as Absent_Count,count(distinct sysDate) as Total_Count from attendance,students where attendance.idAttendance=employee.id and sysDate='"
																+ sdate + "' group by id");
												while (rs.next()) {
													found = true;
													int id = rs.getInt(1);
													String student_name = rs.getString(2);
													int toadys_present = rs.getInt(3);
													int todays_absent = rs.getInt(4);
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs.getInt(1));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs.getString(2));
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><label style='color: #00ff00;'>");
      out.print(rs.getInt(3));
      out.write("</label></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><label style='color: #ff0000;'>");
      out.print(rs.getInt(4));
      out.write("</label></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
												if (!found) {
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>No attendance found this date.</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
											}
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t");

		} else {
			response.sendRedirect("index.jsp");
		}
	
      out.write("\n");
      out.write("</body>\n");
      out.write("<script src=\"js/jquery-3.1.1.js\"></script>\n");
      out.write("<script src=\"js/bootstrap.js\"></script>\n");
      out.write("<script src=\"js/script.js\"></script>\n");
      out.write("<script src=\"js/jquery.dataTables.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t$('#table').DataTable();\n");
      out.write("\t})\n");
      out.write("</script>\n");
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

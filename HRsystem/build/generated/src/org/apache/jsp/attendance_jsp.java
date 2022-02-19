package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.*;

public final class attendance_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Student Attendance System</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
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
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color:#F0F0F0\";>\n");
      out.write("\t");

		if (session.getAttribute("uname") != null && session.getAttribute("uname") != "") {
	
      out.write('\n');
      out.write('	');

            
            Connection con;
            PreparedStatement pat,pat3;
            ResultSet rs,rs3;
            Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system", "root", "rootPassword12");
		String query = ("select count(*) from employee where status=1");
                pat = con.prepareStatement(query);
                rs = pat.executeQuery();
			rs.next();
			int count = rs.getInt(1);
                        
        String id2 = request.getParameter("id");
                                            int id_int = Integer.parseInt(id2);
                                             String query3 = "select empType from employee where id = " +id_int;
                                   pat3 = con.prepareStatement(query3);
                                   rs3 = pat.executeQuery();
                                    String type = rs3.getString("empType");
                                    out.print(type);
	
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_side_header.jsp", out, false);
      out.write("\n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("\t\t<div class=\"panel panel-default shadow p-3 mb-5\">\n");
      out.write("\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t<div class=\"alert alert-info shadow p-3 mb-5\" style=\"text-transform: uppercase\">Take Students Attendance</div>\n");
      out.write("\t\t\t\t");

					String alreadyTaken = (String) session.getAttribute("todays-attendance-already-taken");
						if (alreadyTaken != null) {
							session.removeAttribute("todays-attendance-already-taken");
				
      out.write("\n");
      out.write("\t\t\t\t<div class=\"alert alert-danger\" id='danger'>Today's attendance\n");
      out.write("\t\t\t\t\talready taken.</div>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t\t");

					String attendanceTaken = (String) session.getAttribute("attendance-taken");
						if (attendanceTaken != null) {
							session.removeAttribute("attendance-taken");
				
      out.write("\n");
      out.write("\t\t\t\t<div class=\"alert alert-success\" id='success'>Attendance taken successfully.</div>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t\t<div class=\"panel panel shadow p-3 mb-5\">\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading bg-light\" style=\"text-transform: uppercase;font-size:small;font-weight: bold;\">\n");
      out.write("\t\t\t\t\t\tFill Attendance &nbsp;[&nbsp;");
      out.print((new java.util.Date()).toLocaleString());
      out.write("&nbsp;]&nbsp;\n");
      out.write("\t\t\t\t\t\t<a class=\"btn btn-success\"><span class=\"badge\">");
      out.print(count);
      out.write("</span>\n");
      out.write("\t\t\t\t\t\t\tActive Students</a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("                                            ");

                                                if(type.equals("Manager"))
                                                {
                                            
                                            
      out.write("\n");
      out.write("\t\t\t\t\t\t<form action=\"\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t<table id=\"table\"\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"table table-striped table-hover table-bordered\">\n");
      out.write("\t\t\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Student Id</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Student Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Mobile</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Email</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Present</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>Absent</th>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										
											Statement st = con.createStatement();
											ResultSet rs2 = st.executeQuery("select * from students where status=1");
											while (rs2.next()) {
												int id = rs2.getInt(1);
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs2.getInt(1));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs2.getString(2));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs2.getString(4));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rs2.getString(6));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"");
      out.print(id);
      out.write("\" value=\"present\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trequired></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"");
      out.print(id);
      out.write("\" value=\"absent\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trequired></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"Take Attendance\"\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"btn btn-primary\"> <input type=\"reset\"\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"btn btn-danger\" value=\"Clear\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("                                                                        ");

                                                                            }
else{
out.print("You are not an admin, please go to Employee Login");
}
                                                                            
      out.write("\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$('#success').delay(5000).show().fadeOut('slow');\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$('#danger').delay(5000).show().fadeOut('slow');\n");
      out.write("\t});\n");
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

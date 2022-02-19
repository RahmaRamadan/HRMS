package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import hr.dbConnection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class adminValidation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ADMIN VALIDATION</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         ");

            
              try
              {
                  String type;
           String name =  request.getParameter("uname");
           String idd =  request.getParameter("idd");
           String password = request.getParameter("pass");
            
      out.write("\n");
      out.write("            \n");
      out.write("    <form action=\"homePage.jsp\" method=\"post\">\n");
      out.write("    ");

    session.setAttribute("idd", idd);
        
      out.write("\n");
      out.write("       \n");
      out.write("    </form>\n");
      out.write("           ");

            Connection con;
                PreparedStatement pat;
                ResultSet rs;
                con = dbConnection.getConnection();
                String query;
                query = "SELECT empType from employee where id = ?";
                
                pat = con.prepareStatement(query);
                pat.setString(1, idd);
                rs = pat.executeQuery();
                 
                if(rs.next())  {
    type=new String(rs.getString(1));
      
    if(type.equals("Manager")){
       response.sendRedirect("homePage.jsp"); 
       Date CurrentDate = GregorianCalendar.getInstance().getTime();
       DateFormat df = DateFormat.getDateInstance();
       String dateString = df.format(CurrentDate);
       SimpleDateFormat f = new SimpleDateFormat("MMM");
       String strMonth = f.format(new Date());
       
       Date d = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       String timeString = sdf.format(d);
       int value = timeString.compareTo("10:00:00");
        Connection con2;
                PreparedStatement pat2;
                ResultSet rs2;
                con2 = dbConnection.getConnection();
                String query2;
       if(value > 0){ //After 10 AM
         
       query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month) VALUES (?,?,?,?,?)";
                pat2 = con2.prepareStatement(query2);
                pat2.setString(1, "Present");
                pat2.setString(2, dateString);
                pat2.setString(3, "Late");
                pat2.setString(4, idd);
                pat2.setString(5, strMonth);
                pat2.executeUpdate();     
    }
       else if (value == 0){
          query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month) VALUES (?,?,?,?,?)";
                out.print("less mn 10");
                pat2 = con2.prepareStatement(query2);
                pat2.setString(1, "Present");
                pat2.setString(2, dateString);
                pat2.setString(3, "On Time");
                pat2.setString(4, idd);
                pat2.setString(5, strMonth);
                pat2.executeUpdate();     
       }
       else{
           query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month) VALUES (?,?,?,?,?)";
                out.print("less mn 10");
                pat2 = con2.prepareStatement(query2);
                pat2.setString(1, "Present");
                pat2.setString(2, dateString);
                pat2.setString(3, "Early");
                pat2.setString(4, idd);
                pat2.setString(5, strMonth);
                pat2.executeUpdate();    
       }
    }
    else if(type.equals("Employee")){
        out.print("You are not admin, please go to Employee Login");
    }
    else{
        out.print("Unidentified Employee");
    }
}
                
             }
              catch(Exception e){
out.print(e);
}


      out.write("\n");
      out.write("\n");
      out.write("    \n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hr.dbConnection;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.time.Duration;
import java.time.temporal.TemporalQueries;

public final class deductionRewardData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Confirmation</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 id=\"h\">Salary update has been applied successfully</h1> \n");
      out.write("        <hr id=\"line\">\n");
      out.write("        <style>\n");
      out.write("            #h{\n");
      out.write("                font-family:initial;\n");
      out.write("                color: #09C;\n");
      out.write("            } \n");
      out.write("            #line{\n");
      out.write("               height: 50px;\n");
      out.write("               background-color: #09C;\n");
      out.write("               margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            #out1{\n");
      out.write("                color: #09C;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("             #out2{\n");
      out.write("                color: #09C;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("             #out3{\n");
      out.write("                color: #09C;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            #out4{\n");
      out.write("                color: #09C;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #out11{\n");
      out.write("                font-style: italic;\n");
      out.write("                color: white;\n");
      out.write("               \n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            #out21{\n");
      out.write("                font-style: italic;\n");
      out.write("                color: white;\n");
      out.write("                \n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            #out31{\n");
      out.write("                font-style: italic;\n");
      out.write("                color: white;\n");
      out.write("                \n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            #out41{\n");
      out.write("                font-style: italic;\n");
      out.write("                color: white;\n");
      out.write("                \n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            p span{\n");
      out.write("                background-color: #09C;\n");
      out.write("                display: inlineblock;\n");
      out.write("                line-height:normal;\n");
      out.write("                border: 2px;\n");
      out.write("                white-space:pre-line;\n");
      out.write("              font-family: monospace;\n");
      out.write("              display: block;\n");
      out.write("            }\n");
      out.write("            #ss{\n");
      out.write("                size: 20px;\n");
      out.write("                width: 160px;\n");
      out.write("            }\n");
      out.write("        </style> \n");
      out.write("          ");

              String message = "", color= "";
              String ded = "";
              String re = "";
              int ded2 = 0;
              int re2 = 0;
              int amount2;
              
              
         /*     
           String name =  (String)request.getParameter("empName");
           String idd =  (String)request.getParameter("empID");
           String dedOrReward =  (String)request.getParameter("deductionOrReward");
           String date =  (String)request.getParameter("datee");
           String amount =  (String)request.getParameter("amountt");
           String reason =  (String)request.getParameter("reas");
           out.println(name+" Added Succesfully");
           */
              try
              {
           String name =  request.getParameter("empName");
           String idd =  request.getParameter("empID");
           String dedOrReward =  request.getParameter("deductionOrReward");
           String date =  request.getParameter("datee");
           String amount =  request.getParameter("amountt");
           String reason =  request.getParameter("reas");
           
            Connection con;
                PreparedStatement pat,pat2;
                ResultSet rs;
                
                con = dbConnection.getConnection();
                String query, query2;
                
      out.write("\n");
      out.write("                 <p id=\"out1\">");
out.println("Name : ");
      out.write("</p><p id = \"out11\"><b><span id=\"ss\">");
  out.println(name);
      out.write("  </span></b></p>\n");
      out.write("\n");
      out.write("         <p id=\"out2\"> ");
 out.println("ID : ");
      out.write("</p><p id = \"out11\"><b><span id=\"ss\">");
  out.println(idd);
      out.write("  </span></b></p>\n");
      out.write("         <p id=\"out3\"> ");
 out.println(dedOrReward + " amount : ");
      out.write("</p><p id = \"out31\"><b><span id=\"ss\">");
  out.println(amount); 
      out.write("</span></b></p>\n");
      out.write("         <p id=\"out4\"> ");
 out.println("Reason for " + dedOrReward + " : " );
      out.write("</p><p id = \"out41\"><b><span id=\"ss\">");
  out.println(reason); 
      out.write("</span></b></p>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("         ");

                /*Duration delay = Duration.ofDays(30);
                long delay2 = TimeUnit.MINUTES.toMillis(1);
                Timer timer = new Timer();
                timer.schedule(new TimerTask()
                {
               @Override
               public void run() {
                   try{
                   Connection con2;
                   con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system","root","rootPassword12");
                   String query3,query4,query5;
                   PreparedStatement pat3,pat4,pat5;
                  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                   
                 query3 = "SET GLOBAL event_scheduler = ON";
                    pat3 = con2.prepareStatement(query3);
                    pat3.executeQuery();
                    
                    query4 = "CREATE EVENT IF NOT exists eventDefaulttTTtttttttt2 " +
                             "ON SCHEDULE every 1 month " +
                             "DO "+                           
                             "UPDATE employee SET deduction = 60";
                    pat4 = con2.prepareStatement(query4);
                    pat4.executeUpdate();
                    
                    query5 = "set GLOBAL event_scheduler = 0;";
                    pat5 = con2.prepareStatement(query5);
                    pat5.executeQuery();
                }
                catch(Exception exx){
                    
                    
                }
               }
           }, delay2);*/
                
                query = "SELECT deduction, reward from employee where id = "+idd;
                pat = con.prepareStatement(query);
                rs = pat.executeQuery();
                amount2 = Integer.parseInt(amount);
                  while(rs.next())
                  {
                    ded =rs.getString("deduction");
                    ded2 = Integer.parseInt(ded);
                    
                   re =rs.getString("reward");
                    re2 = Integer.parseInt(re);
                  }
                  
                 
              if(dedOrReward.equals("Reward"))
              {
                  amount2 += re2;
                  query2= "UPDATE employee SET reward= ? WHERE id=?";
                  
                    
              }
                    else
              {
                  amount2 += ded2;
                  
               query2= "UPDATE employee SET deduction = ? WHERE id=?" ;

                  
              }
               
                pat2 = con.prepareStatement(query2);
                pat2.setInt(1, amount2);
                pat2.setString(2, idd);
                    pat2.executeUpdate();
                    color = "green";
                    message = "Employee's salary issues updated successfully";
                    
                    

                } catch (Exception ex) {
                    out.println("ex: " + ex);
                    ex.printStackTrace();
                    color = "red";
                    message = "Error Occured";
                }
                
                
               
       
            
      out.write("\n");
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

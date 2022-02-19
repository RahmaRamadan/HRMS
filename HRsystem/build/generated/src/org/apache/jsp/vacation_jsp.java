package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class vacation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Vacations Request</title>\n");
      out.write("        <style>\n");
      out.write("            @import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600);\n");
      out.write("\n");
      out.write("* {\n");
      out.write("\tmargin:20px;\n");
      out.write("\tpadding:0;\n");
      out.write("\tbox-sizing:border-box;\n");
      out.write("\t-webkit-box-sizing:border-box;\n");
      out.write("\t-moz-box-sizing:border-box;\n");
      out.write("\t-webkit-font-smoothing:antialiased;\n");
      out.write("\t-moz-font-smoothing:antialiased;\n");
      out.write("\t-o-font-smoothing:antialiased;\n");
      out.write("\tfont-smoothing:antialiased;\n");
      out.write("\ttext-rendering:optimizeLegibility;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("\tfont-family:\"Open Sans\", Helvetica, Arial, sans-serif;\n");
      out.write("\tfont-weight:300;\n");
      out.write("\tfont-size: 12px;\n");
      out.write("\tline-height:30px;\n");
      out.write("\tcolor:#777;\n");
      out.write("\tbackground:white;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("\tmax-width:500px;\n");
      out.write("\twidth:100%;\n");
      out.write("                height: 800px;\n");
      out.write("\tmargin:0 auto;\n");
      out.write("\tposition:relative;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("#contact {\n");
      out.write("\tbackground:buttonface;\n");
      out.write("\tpadding:25px;\n");
      out.write("\tmargin:50px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact h3 {\n");
      out.write("\tcolor: #0492C2;\n");
      out.write("\tdisplay: block;\n");
      out.write("\tfont-size: 30px;\n");
      out.write("\tfont-weight:bold;\n");
      out.write("        margin:5px 0 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("fieldset {\n");
      out.write("\tborder: medium none !important;\n");
      out.write("\tmargin: 0 0 10px;\n");
      out.write("\tmin-width: 100%;\n");
      out.write("\tpadding: 0;\n");
      out.write("\twidth: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact input[type=\"text\"], #contact input[type=\"text\"], #contact input[type=\"text\"], #contact input[type=\"date\"],#contact input[type=\"number\"],#contact textarea {\n");
      out.write("\twidth:100%;\n");
      out.write("\tborder:1px solid #CCC;\n");
      out.write("\tbackground:#FFF;\n");
      out.write("\tmargin:0 0 5px;\n");
      out.write("\tpadding:10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact input[type=\"text\"]:hover, #contact input[type=\"text\"]:hover, #contact input[type=\"text\"]:hover, #contact input[type=\"date\"]:hover,#contact input[type=\"number\"]:hover, #contact textarea:hover {\n");
      out.write("\t-webkit-transition:border-color 0.3s ease-in-out;\n");
      out.write("\t-moz-transition:border-color 0.3s ease-in-out;\n");
      out.write("\ttransition:border-color 0.3s ease-in-out;\n");
      out.write("\tborder:1px solid #AAA;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact textarea {\n");
      out.write("\theight:100px;\n");
      out.write("\tmax-width:100%;\n");
      out.write("  resize:none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact button[type=\"submit\"] {\n");
      out.write("\tcursor:pointer;\n");
      out.write("\twidth:100%;\n");
      out.write("\tborder:none;\n");
      out.write("\tbackground:#0492C2;\n");
      out.write("\tcolor:#FFF;\n");
      out.write("\tmargin:0 0 5px;\n");
      out.write("\tpadding:10px;\n");
      out.write("\tfont-size:15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact button[type=\"submit\"]:hover {\n");
      out.write("\tbackground:#09C;\n");
      out.write("\t-webkit-transition:background 0.3s ease-in-out;\n");
      out.write("\t-moz-transition:background 0.3s ease-in-out;\n");
      out.write("\ttransition:background-color 0.3s ease-in-out;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contact button[type=\"submit\"]:active { box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5); }\n");
      out.write("\n");
      out.write("#contact input:focus, #contact textarea:focus {\n");
      out.write("\toutline:0;\n");
      out.write("\tborder:1px solid #999;\n");
      out.write("}\n");
      out.write("::-webkit-input-placeholder {\n");
      out.write(" color:#888;\n");
      out.write("}\n");
      out.write(":-moz-placeholder {\n");
      out.write(" color:#888;\n");
      out.write("}\n");
      out.write("::-moz-placeholder {\n");
      out.write(" color:#888;\n");
      out.write("}\n");
      out.write(":-ms-input-placeholder {\n");
      out.write(" color:#888;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#datee{\n");
      out.write("     height: 35px;\n");
      out.write("\tmax-width:100%;\n");
      out.write("        width:550px;\n");
      out.write("  resize:none;\n");
      out.write("  margin: 0 0 10px;\n");
      out.write("}   \n");
      out.write("\n");
      out.write("#numDays{\n");
      out.write("     height: 35px;\n");
      out.write("\tmax-width:100%;\n");
      out.write("        width:550px;\n");
      out.write("  resize:none;\n");
      out.write("  margin: 0 0 10px;\n");
      out.write("}\n");
      out.write("#vacs{\n");
      out.write("    height: 35px;\n");
      out.write("\tmax-width:100%;\n");
      out.write("        width:550px;\n");
      out.write("  resize:none;\n");
      out.write("  margin: 0 0 10px;\n");
      out.write("}  \n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">  \n");
      out.write("  <form id=\"contact\" action=\"vacationData.jsp\" method=\"get\">\n");
      out.write("    <h3>Vacation Form</h3>\n");
      out.write("    <fieldset >\n");
      out.write("      <input name = \"nameField\" placeholder=\"Name\" type=\"text\" tabindex=\"1\" required autofocus>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset >\n");
      out.write("      <input name = \"idField\" placeholder=\"ID\" type=\"text\" tabindex=\"2\" required>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset >\n");
      out.write("      <input name = \"jobField\" placeholder=\"Job\" type=\"text\" tabindex=\"3\" required>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset >\n");
      out.write("      <input name =\"datee\" placeholder=\"Date\" type=\"date\" tabindex=\"4\" required>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset >\n");
      out.write("        \n");
      out.write("  <select id=\"vacs\" name=\"vactions\" tabindex=\"5\" required>\n");
      out.write("    <option value=\"\" disabled selected>Choose Vacation Type:</option> \n");
      out.write("    <option value=\"req\">Regular</option>\n");
      out.write("    <option value=\"opp\">Opposing</option>\n");
      out.write("    <option value=\"morb\">Morbidity</option>\n");
      out.write("    <option value=\"per\">Permission</option>\n");
      out.write("  </select>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset>\n");
      out.write("      <input name=\"numDays\" placeholder=\"Number of Days\" type=\"number\" tabindex=\"6\" required>\n");
      out.write("    </fieldset>\n");
      out.write("    <fieldset>\n");
      out.write("      <button name=\"submit\" type=\"submit\" id=\"contact-submit\" data-submit=\"...Sending\">Make Request</button>\n");
      out.write("    </fieldset>\n");
      out.write("  \n");
      out.write("  </form>\n");
      out.write(" \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("      \n");
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

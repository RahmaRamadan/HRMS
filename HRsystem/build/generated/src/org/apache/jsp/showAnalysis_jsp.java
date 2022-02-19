package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showAnalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Employee Affairs Section</title>\n");
      out.write("        <style>\n");
      out.write("                \n");
      out.write("                *\n");
      out.write("                {\n");
      out.write("                    margin: 0;\n");
      out.write("                    padding: 0;\n");
      out.write("                }\n");
      out.write("                #nav-bar{\n");
      out.write("                    position: sticky;\n");
      out.write("                    top: 0;\n");
      out.write("                    z-index: 10;\n");
      out.write("                    background:#0065A2;\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                .navbar-brand img{\n");
      out.write("                    height: 70px;\n");
      out.write("                    width: 120px;\n");
      out.write("                    padding-left: 30px;\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .navbar-nav li{\n");
      out.write("                    padding: 0 10px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .navbar-nav li a{\n");
      out.write("                    float: right;\n");
      out.write("                    text-align: left;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                #nav-bar ul li a:hover{\n");
      out.write("                    color: blue;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .navbar-toggler{\n");
      out.write("                    border: none;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .nav-link{\n");
      out.write("                    color: #555;\n");
      out.write("                    position:static;\n");
      out.write("                    font-weight: 600;\n");
      out.write("                    font-size: 16px;                   \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                #slider{\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .carousel-caption{\n");
      out.write("                    top: 85%;\n");
      out.write("                    transform: translateY(-50%);\n");
      out.write("                    bottom: initial;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .carousel-caption h5{\n");
      out.write("                    color: white;\n");
      out.write("                    font-size: 50px;\n");
      out.write("                }\n");
      out.write("                .d-block{\n");
      out.write("                    width: 100%;\n");
      out.write("                    height: 600px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                #head1{\n");
      out.write("                    color:#0065A2;\n");
      out.write("                    background-color:#F6F7FB;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .btn-primary{\n");
      out.write("                    display: block;\n");
      out.write("  width: 320px;\n");
      out.write("  max-width: 100%;\n");
      out.write("  margin: 0 auto;\n");
      out.write("  margin-bottom: 0;\n");
      out.write("  overflow: hidden;\n");
      out.write("  position: relative;\n");
      out.write("  transform: translatez(0);\n");
      out.write("  text-decoration: none;\n");
      out.write("  box-sizing: border-box;\n");
      out.write("  font-size: 24px;\n");
      out.write("\tfont-weight: normal;\n");
      out.write("\tbox-shadow: 0 9px 18px rgba(0,0,0,0.2);\n");
      out.write("        text-align: center;\n");
      out.write("\tborder-radius: 40px;\n");
      out.write("  padding: 7px;\n");
      out.write("  color: white;\n");
      out.write("  background: #BD3381;\n");
      out.write("  transition: all 0.2s ease-out 0s;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                \n");
      out.write("           </style>   \n");
      out.write("          <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href =\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-\n");
      out.write("              awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com./bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section id=\"nav-bar\">\n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\"><img src = \"logo.jpg\"> </a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("      <ul class=\"navbar-nav ml-auto\">\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"#\">ABOUT US</a>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"#\">SERVICES</a>\n");
      out.write("        </li>\n");
      out.write("        \n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"#\">CAREERS</a>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a href=\"homePage.jsp\"<i class=\"fa fa-home\"></i> HR HOME</a>\n");
      out.write("        </li>\n");
      out.write("        \n");
      out.write("         \n");
      out.write("        \n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav> \n");
      out.write("                  <h1 id= \"head1\" align = \"center\">Employee Affairs Analysis</h1>\n");
      out.write("\n");
      out.write("</section>\n");
      out.write("        <div id=\"slider\">\n");
      out.write("            <div id=\"headerSlider\" class=\"carousel slide\" data-bs-ride=\"carousel\">\n");
      out.write("  <ol class=\"carousel-indicators\">\n");
      out.write("    <li data-bs-target=\"#headerSlider\" data-bs-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("    <li data-bs-target=\"#headerSlider\" data-bs-slide-to=\"1\"></li>\n");
      out.write("    <li data-bs-target=\"#headerSlider\" data-bs-slide-to=\"2\"></li>\n");
      out.write("  </ol>\n");
      out.write("  <div class=\"carousel-inner\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("      <img class=\"d-block\" src=\"analys1.jpg\">\n");
      out.write("      <div class=\"carousel-caption\">\n");
      out.write("          <h5>Data Analysis</h5>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block\" src=\"analys2.jpg\">\n");
      out.write("       <div class=\"carousel-caption\">\n");
      out.write("          <h5>Charts</h5>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block\" src=\"analys3.jpg\">\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <a class=\"carousel-control-prev\" href=\"#headerSlider\" role=\"button\" data-bs-slide=\"prev\">\n");
      out.write("    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"visually-hidden\">Previous</span>\n");
      out.write("  </a>\n");
      out.write("  <a class=\"carousel-control-next\" href=\"#headerSlider\" role=\"button\" data-bs-slide=\"next\">\n");
      out.write("    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"visually-hidden\">Next</span>\n");
      out.write("  </a><br/>\n");
      out.write("</div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("        \n");
      out.write("        <div class = \"container\">\n");
      out.write("        <button class = \"btn-primary\" onclick=\"window.location.href='empAff_charts.jsp' \">Show Gender Distribution</button><br/>\n");
      out.write("        <button class = \"btn-primary\" onclick=\"window.location.href='attendDataChart.jsp'\">Show Employee Arrival Time</button><br/>\n");
      out.write("        \n");
      out.write("        </div>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Algorithms.Evaluation.Trainings_Management;
import Entity.Training;
import java.util.ArrayList;

public final class addTraining_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Training</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"  >\n");
      out.write("  \n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            .navBar {\n");
      out.write("                overflow: hidden;\n");
      out.write("                padding-right: 20px;\n");
      out.write("                padding-left: 40px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navBar a {\n");
      out.write("                float: right;\n");
      out.write("                color: #0065A2;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 20px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navBar a:hover {\n");
      out.write("                /* background-color: #0065A2;\n");
      out.write("                 color: whitesmoke;*/\n");
      out.write("                background: none;\n");
      out.write("                color: #0492C2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navBar a.back {\n");
      out.write("                color: cadetblue;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            .logo {\n");
      out.write("                color: white;\n");
      out.write("                float: left;\n");
      out.write("                width: 120px;\n");
      out.write("                height: 70px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .btn-primary{\n");
      out.write("                    display: block;\n");
      out.write("                    right: 140px;\n");
      out.write("                    width: 300px;\n");
      out.write("                    max-width: 100%;\n");
      out.write("                    margin: 0 auto;\n");
      out.write("                    margin-bottom: 0;\n");
      out.write("                    overflow: hidden;\n");
      out.write("                    position: relative;\n");
      out.write("                    transform: translatez(0);\n");
      out.write("                    text-decoration: none;\n");
      out.write("                    box-sizing: border-box;\n");
      out.write("                    font-size: 24px;\n");
      out.write("                    font-weight: normal;\n");
      out.write("                    box-shadow: 0 9px 18px rgba(0,0,0,0.2);\n");
      out.write("                    text-align: center;\n");
      out.write("                    border-radius: 40px;\n");
      out.write("                    padding: 7px;\n");
      out.write("                    color: white;\n");
      out.write("                    transition: all 0.2s ease-out 0s;\n");
      out.write("                }\n");
      out.write("                #hh\n");
      out.write("                {\n");
      out.write("                    color: blue;\n");
      out.write("                    text-align: center;\n");
      out.write("                    font-size: 30px;\n");
      out.write("                }\n");
      out.write("                #err{\n");
      out.write("                    color: red;\n");
      out.write("                    text-align: center;\n");
      out.write("                    font-size: 30px;\n");
      out.write("                }\n");
      out.write("                #sk{\n");
      out.write("                    width: 300px;\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"navBar\">\n");
      out.write("\n");
      out.write("            <a href=\"#\">ABOUT US</a>\n");
      out.write("            <a href=\"#\">SERVICES</a> \n");
      out.write("            <a   href=\"careers.jsp\">CAREERS</a>\n");
      out.write("            <a href=\"homePage.jsp\"<i class=\"fa fa-home\"></i> HR HOME</a>\n");
      out.write("            <img class=\"logo\" src = \"logo.jpg\" >\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

          
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
              try{
              Training t = new Training(Integer.parseInt(request.getParameter("id")),request.getParameter("title"), 
                      request.getParameter("startDate"), request.getParameter("endDate"), request.getParameter("description"),
                      Integer.parseInt(request.getParameter("score")));
             
              ArrayList<String> trainingSkills = new ArrayList<>();
              String[] skills = request.getParameterValues("skills");
              for(int i = 0 ; i < skills.length ; i++)
              {
                  trainingSkills.add(i, skills[i]);
              }
              t.setSkills(trainingSkills);
              
              boolean add_Training  ;
              Trainings_Management training = new Trainings_Management();
               add_Training =   training.addTraining(t);
               color = "green";
                if (add_Training) {
                    
      out.write("        \n");
      out.write("                    <h4 id=\"hh\">Training Added Successfully</h4>\n");
      out.write("                     ");

                } else {
                    color = "red";

      out.write("\n");
      out.write("                <h4 id=\"err\">Error Occured</h4>\n");
      out.write("                    ");

                   // message = "Error Occured";
                }
             
                 } catch (Exception ex) {
                    out.println("ex: " + ex);
                  
                }

            }
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        <h1 style=\"text-align: center\">Enter Training Data</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form  method=\"post\" action=\"addTraining.jsp\" >\n");
      out.write("            <table style=\"margin-left: 500px; width: 900px \" >\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>  <h3>Training Info</h3></td>\n");
      out.write("                    <td>\n");
      out.write("                        <table>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td><h6>ID</h6><input class=\"form-control m-input\" type=\"text\" name=\"id\" value=\"\" required/></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td><h6>Title</h6><input class=\"form-control m-input\" type=\"text\" name=\"title\" value=\"\" required/></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td><h6>Start Date</h6><input class=\"form-control m-input\" type=\"text\" name=\"startDate\" value=\"\" required/></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td><h6>End Date</h6><input class=\"form-control m-input\" type=\"text\" name=\"endDate\" value=\"\" required/></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                     \n");
      out.write("                            <tr>\n");
      out.write("                                <td><h6>Description</h6><textarea name=\"description\" rows=\"4\" cols=\"40\" class=\"form-control m-input\"></textarea></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                             <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <br>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h6>Score</h6><input class=\"form-control m-input\" type=\"text\" name=\"score\" value=\"\" required/></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            <tr><td><hr></td><td><hr></td></tr> \n");
      out.write("            <tr><td><br></td></tr>    \n");
      out.write("            <tr><td><h3>Required Skills</h3></td><td>\n");
      out.write("\n");
      out.write("                    <table>\n");
      out.write("\n");
      out.write("                       <tr><td>\n");
      out.write("\n");
      out.write("                                <div id=\"inputFormSkill\">\n");
      out.write("                                    <table>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <h6>Skill</h6> <input id=\"sk\" type=\"text\" name=\"skills\" class=\"form-control m-input\" placeholder=\"Enter a Skill\" autocomplete=\"off\" required>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table> \n");
      out.write("                                    <div class=\"input-group mb-3\"> </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </td></tr>\n");
      out.write("                        <tr><td>\n");
      out.write("                                <div id=\"newSkill\"></div>\n");
      out.write("                             \n");
      out.write("                                <input  style=\"background-color: white; color:blue; right: 500px; border: none ; font-size: 20px \" id=\"addSkill\" value=\"Add Extra Skill\" type=\"button\">\n");
      out.write("\n");
      out.write("                            </td></tr>\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </td></tr>\n");
      out.write("\n");
      out.write("            <tr><td><hr></td><td><hr></td></tr> \n");
      out.write("            <tr><td><br></td></tr>\n");
      out.write("            <tr><td></td><td>\n");
      out.write("            <button  class = \"btn-primary\" type=\"submit\" onclick=\"\">Add Training</button></td></tr>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("    $('.btn').click(function () {\n");
      out.write("        $(this).toggleClass(\"click\");\n");
      out.write("        $('.sidebar').toggleClass(\"show\");\n");
      out.write("    });\n");
      out.write("    $('.recru-btn').click(function () {\n");
      out.write("        $('nav ul .recru-show').toggleClass(\"show\");\n");
      out.write("        $('nav ul .first').toggleClass(\"rotate\");\n");
      out.write("    });\n");
      out.write("    $('.affairs-btn').click(function () {\n");
      out.write("        $('nav ul .affairs-show').toggleClass(\"show1\");\n");
      out.write("        $('nav ul .second').toggleClass(\"rotate\");\n");
      out.write("    });\n");
      out.write("    $('.eva-btn').click(function () {\n");
      out.write("        $('nav ul .eva-show').toggleClass(\"show2\");\n");
      out.write("        $('nav ul .third').toggleClass(\"rotate\");\n");
      out.write("    });\n");
      out.write("    $('.payroll-btn').click(function () {\n");
      out.write("        $('nav ul .pay-show').toggleClass(\"show3\");\n");
      out.write("        $('nav ul .forth').toggleClass(\"rotate\");\n");
      out.write("    });\n");
      out.write("    $('.employee-btn').click(function () {\n");
      out.write("        $('nav ul .emp-show').toggleClass(\"show4\");\n");
      out.write("        $('nav ul .fifth').toggleClass(\"rotate\");\n");
      out.write("    });\n");
      out.write("    $('nav ul li').click(function () {\n");
      out.write("        $(this).addClass(\"active\").siblings().removeClass(\"active\");\n");
      out.write("    });\n");
      out.write("    // add row\n");
      out.write("    $(\"#addSkill\").click(function () {\n");
      out.write("        var html = '';\n");
      out.write("        html += '<div id=\"inputFormSkill\">';\n");
      out.write("\n");
      out.write("        html += '<div class=\"input-group mb-3\">';\n");
      out.write("        html += '<br>';\n");
      out.write("        html += '<table><tr><td>Skill <input type=\"text\" name=\"skills\" class=\"form-control m-input\" placeholder=\"Enter a Skill\" autocomplete=\"off\">';\n");
      out.write("        html += '<div class=\"input-group-append\">';\n");
      out.write("\n");
      out.write("        html += '<input style=\"background-color: red; color:white\" id=\"removeSkill\" value=\"Remove\" type=\"button\"> </td></tr></table>';\n");
      out.write("        html += '</div>';\n");
      out.write("        html += '</div>';\n");
      out.write("\n");
      out.write("        $('#newSkill').append(html);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // remove row\n");
      out.write("    $(document).on('click', '#removeSkill', function () {\n");
      out.write("        $(this).closest('#inputFormSkill').remove();\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Algorithms.Evaluation.Charts;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import java.util.ArrayList;

public final class Exp_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Charts c = new Charts();
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    list = c.traningsChart();
    String dataPoints = gsonObj.toJson(list);

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
      out.write("        <title>Training Section</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"  >\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        window.onload = function() { \n");
      out.write("\n");
      out.write("        var chart = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                animationEnabled: true,\n");
      out.write("                theme: \"light2\",\n");
      out.write("                title:{\n");
      out.write("                        text: \"Ranges for Trainings Duration\"\n");
      out.write("                },\n");
      out.write("                subtitles: [{\n");
      out.write("                        text: \"\"\n");
      out.write("                }],\n");
      out.write("                axisY: {\n");
      out.write("                        title: \"Date\",\n");
      out.write("                        prefix: \"$\",\n");
      out.write("                        lineThickness: 1\n");
      out.write("                },\n");
      out.write("                data: [{\n");
      out.write("                        type: \"rangeBar\",\n");
      out.write("                        indexLabel: \"{y[#index]}\",\n");
      out.write("                        yValueFormatString: \"$#,##0\",\n");
      out.write("                        dataPoints: ");
out.print(dataPoints);
      out.write("\n");
      out.write("                }]\n");
      out.write("        });\n");
      out.write("        chart.render();\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');\n");
      out.write("            body {\n");
      out.write("                background-image: url('');\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-attachment: fixed;\n");
      out.write("                background-size: 100% 100%;\n");
      out.write("                \n");
      out.write("                margin: 0;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("                }\n");
      out.write("      \n");
      out.write("            .navBar {\n");
      out.write("                overflow: hidden;\n");
      out.write("                padding-right: 20px;\n");
      out.write("                padding-left: 40px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            .navBar a {\n");
      out.write("                float: right;\n");
      out.write("                color: #0492C2;\n");
      out.write("                background: none;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 20px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 18px;\n");
      out.write("                }\n");
      out.write("            .navBar a:hover {\n");
      out.write("                background: none;\n");
      out.write("                color: #0492C2;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            .navBar a.back {\n");
      out.write("                color: cadetblue;\n");
      out.write("                float: left;\n");
      out.write("               }\n");
      out.write("            .logo {\n");
      out.write("                color: white;\n");
      out.write("                float: left;\n");
      out.write("\n");
      out.write("                height: 50px;\n");
      out.write("                width: 100px;\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("            .B_Score \n");
      out.write("           {\n");
      out.write("                background-color: #ddd; \n");
      out.write("                border: none;\n");
      out.write("                color:#0492C2;\n");
      out.write("                font-weight: bold;\n");
      out.write("                padding: 8px;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin: 4px 2px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                \n");
      out.write("                                 \n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            .container { \n");
      out.write("                height: 200px;\n");
      out.write("                position: relative;\n");
      out.write("   \n");
      out.write("                }\n");
      out.write("\n");
      out.write("            .center {\n");
      out.write("                margin: 0;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 35%;\n");
      out.write("                color: #0492C2;\n");
      out.write("                padding: 20px 40px;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                -ms-transform: translate(-50%, -50%);\n");
      out.write("                transform: translate(-50%, -50%);\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("            *{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("\t\t\t  \n");
      out.write("                user-select: none;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                font-family: 'Poppins', sans-serif;\n");
      out.write("            }\n");
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
      out.write("            .sidebar{\n");
      out.write("                position: fixed;\n");
      out.write("                width: 250px;\n");
      out.write("                height: 100%;\n");
      out.write("                left: -250px;\n");
      out.write("                background: white;\n");
      out.write("                transition: left 0.4s ease;\n");
      out.write("            }\n");
      out.write("            .sidebar.show{\n");
      out.write("                left: -30px;\n");
      out.write("            }\n");
      out.write("            .sidebar .text{\n");
      out.write("                color: #1f6d8f;\n");
      out.write("                font-size: 25px;\n");
      out.write("                font-weight: 600;\n");
      out.write("                line-height: 65px;\n");
      out.write("                text-align: center;\n");
      out.write("                background: white;\n");
      out.write("                letter-spacing: 1px;\n");
      out.write("            }\n");
      out.write("            .text{\n");
      out.write("                background: gray;\n");
      out.write("            }\n");
      out.write("            nav ul{\n");
      out.write("                background: #f7f7f7;\n");
      out.write("                height: 100%;\n");
      out.write("                width: 100%;\n");
      out.write("                list-style: none;\n");
      out.write("            }\n");
      out.write("            nav ul li{\n");
      out.write("                line-height: 60px;\n");
      out.write("                border-top: 1px solid rgba(0,0,0,0.1);\n");
      out.write("            }\n");
      out.write("            nav ul li:last-child{\n");
      out.write("                border-bottom: 1px solid rgba(0,0,0,0.05);\n");
      out.write("            }\n");
      out.write("            nav ul li a{ /*el font nfso*/\n");
      out.write("                position: relative;\n");
      out.write("                color: black;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 18px;\n");
      out.write("                padding-left: 40px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                display: block;\n");
      out.write("                width: 100%;\n");
      out.write("                border-left: 3px solid transparent;\n");
      out.write("            }\n");
      out.write("            nav ul li.active a{ /*el bta3a el nzla*/\n");
      out.write("                color: black;\n");
      out.write("                background: white;\n");
      out.write("                border-left-color: black;\n");
      out.write("            }\n");
      out.write("            nav ul li a:hover{\n");
      out.write("                background: #1f6d8f; /*de bta3t el t7ded 3l klam*/\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            nav ul ul{\n");
      out.write("                position: static;\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            nav ul .recru-show.show{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            nav ul .affairs-show.show1{\n");
      out.write("                display: block;\n");
      out.write("                font-size: 12px;\n");
      out.write("            }\n");
      out.write("            nav ul .eva-show.show2{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            nav ul .pay-show.show3{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            nav ul .emp-show.show4{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("             nav ul .pro-show.show6{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            nav ul ul li{\n");
      out.write("                line-height: 42px;\n");
      out.write("                border-top: none;\n");
      out.write("            }\n");
      out.write("            nav ul ul li a{\n");
      out.write("                font-size: 17px;\n");
      out.write("                color: #e6e6e6;\n");
      out.write("                padding-left: 80px;\n");
      out.write("            }\n");
      out.write("            nav ul li.active ul li a{\n");
      out.write("                color: black;\n");
      out.write("                background: white;\n");
      out.write("                border-left-color: transparent;\n");
      out.write("            }\n");
      out.write("            nav ul ul li a:hover{\n");
      out.write("                color: black!important;\n");
      out.write("                background: #1f6d8f!important;\n");
      out.write("            }\n");
      out.write("            nav ul li a span{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                right: 20px;\n");
      out.write("                transform: translateY(-50%);\n");
      out.write("                font-size: 22px;\n");
      out.write("                transition: transform 0.4s;\n");
      out.write("            }\n");
      out.write("            nav ul li a span.rotate{\n");
      out.write("                transform: translateY(-50%) rotate(-180deg);\n");
      out.write("            }\n");
      out.write("            .pro-btn{\n");
      out.write("                font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .affairs-btn{\n");
      out.write("                font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .eva-btn{\n");
      out.write("                 font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .payroll-btn{\n");
      out.write("                 font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .recru-btn{\n");
      out.write("                 font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .employee-btn{\n");
      out.write("                 font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .content{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("                color: #202020;\n");
      out.write("                z-index: -1;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .content .header{\n");
      out.write("                font-size: 45px;\n");
      out.write("                font-weight: 600;\n");
      out.write("            }\n");
      out.write("            .content p{\n");
      out.write("                font-size: 30px;\n");
      out.write("                font-weight: 500;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("             #myInput {\n");
      out.write("              background-image: url('/css/searchicon.png');\n");
      out.write("              background-position: 10px 12px;\n");
      out.write("              background-repeat: no-repeat;\n");
      out.write("              width: 100%;\n");
      out.write("              font-size: 16px;\n");
      out.write("              padding: 12px 20px 12px 40px;\n");
      out.write("              border: 1px solid #ddd;\n");
      out.write("              border-color: black ;\n");
      out.write("              margin-bottom: 12px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myUL {\n");
      out.write("              list-style-type: none;\n");
      out.write("              padding: 0;\n");
      out.write("              margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myUL li a {\n");
      out.write("              border: 1px solid #ddd;\n");
      out.write("              margin-top: -1px; /* Prevent double borders */\n");
      out.write("              background-color: #f6f6f6;\n");
      out.write("              padding: 12px;\n");
      out.write("              text-decoration: none;\n");
      out.write("              font-size: 18px;\n");
      out.write("              color: black;\n");
      out.write("              display: block\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myUL li a:hover:not(.header) {\n");
      out.write("              background-color: #eee;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>    \n");
      out.write("        <div class=\"navBar\">\n");
      out.write("\n");
      out.write("            <a href=\"#\">ABOUT US</a>\n");
      out.write("            <a href=\"#\">SERVICES</a> \n");
      out.write("            <a href=\"homePage.jsp\">HOME</a>\n");
      out.write("            <a   href=\"careers.jsp\">CAREERS</a>\n");
      out.write("            <img class=\"logo\" src = \"logo.jpg\" >\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <h1 ></h1>\n");
      out.write("       \n");
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
      out.write("                        <li><a href=\"#\">Add Employees</a></li>\n");
      out.write("                        <li><a href=\"#\">Show Employees</a></li>\n");
      out.write("                        <li><a href=\"#\">Request Vacation</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                    \n");
      out.write("                 <li>\n");
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
      out.write("                        <li><a href=\"Score.jsp\">Scores</a></li>\n");
      out.write("                        <li><a href=\"Report.jsp\">Reports</a></li>\n");
      out.write("                        <li><a href=\"Trainings.jsp\">Training</a></li>\n");
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
      out.write("                                <li><a href=\"#\">Cash Advance</a></li>\n");
      out.write("                                <li><a href=\"#\">Deductions</a></li>\n");
      out.write("                                <li><a href=\"#\">Payroll</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("\n");
      out.write("          <script>\n");
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
      out.write("            \n");
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
      out.write("            \n");
      out.write("            $('.pro-btn').click(function () {\n");
      out.write("                $('nav ul .pro-show').toggleClass(\"show6\");\n");
      out.write("                $('nav ul .sixth').toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("            $('nav ul li').click(function () {\n");
      out.write("                $(this).addClass(\"active\").siblings().removeClass(\"active\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("  \n");
      out.write("        <div class=\"center\">\n");
      out.write("        \n");
      out.write("            <div id=\"chartContainer\" style=\"height: 370px; width: 100%;\"></div>\n");
      out.write("            <script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n");
      out.write("\n");
      out.write("        </div>                   \n");
      out.write("                    \n");
      out.write("    </body>\n");
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

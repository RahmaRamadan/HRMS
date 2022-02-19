<%-- 
    Document   : deductionRewardData
    Created on : Apr 30, 2021, 1:39:11 AM
    Author     : egypt2
--%>

<%@page import="Application.Payroll.Payrolls"%>
<%@page import="Entity.Deductions_Data"%>
<%@page import="Entity.Deductions_Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="Entity.dedOrReward_Data"%>
<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.TimerTask"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.logging.Level"%>
<%@page import= "java.util.logging.Logger" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>
<%@page import= "java.time.LocalDate" %>
<%@page import= "java.util.Date" %>
<%@page import="java.util.Timer" %>
<%@page import="java.time.Duration" %>
<%@page import="java.time.temporal.TemporalQueries" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1 id="h">Salary update has been applied successfully</h1> 
        <hr id="line">
        <style>
            #h{
                font-family:initial;
                color: #09C;
            } 
            #line{
                height: 50px;
                background-color: #09C;
                margin-bottom: 20px;
            }
            #out1{
                color: #09C;
                font-size: 22px;
            }
            #out2{
                color: #09C;
                font-size: 22px;
            }
            #out3{
                color: #09C;
                font-size: 22px;
            }
            #out4{
                color: #09C;
                font-size: 22px;
            }

            #out11{
                font-style: italic;
                color: white;

                font-size: 22px;
            }
            #out21{
                font-style: italic;
                color: white;

                font-size: 22px;
            }
            #out31{
                font-style: italic;
                color: white;

                font-size: 22px;
            }
            #out41{
                font-style: italic;
                color: white;

                font-size: 22px;
            }

            p span{
                background-color: #09C;
                display: inlineblock;
                line-height:normal;
                border: 2px;
                white-space:pre-line;
                font-family: monospace;
                display: block;
            }
            #ss{
                size: 20px;
                width: 160px;
            }
        </style> 
        <%
            String message = "", color = "";

            try {
                dedOrReward_Data dedRew = new dedOrReward_Data(request.getParameter("salID"), request.getParameter("empName"),
                        request.getParameter("empID"), request.getParameter("deductionOrReward"), request.getParameter("datee"),
                        request.getParameter("amountt"), request.getParameter("reas"));

        %>
        <p id="out1"><%out.println("Name : ");%></p><p id = "out11"><b><span id="ss"><%  out.println(request.getParameter("empName"));%>  </span></b></p>

        <p id="out2"> <% out.println("ID : ");%></p><p id = "out11"><b><span id="ss"><%  out.println(request.getParameter("empID"));%>  </span></b></p>
        <p id="out3"> <% out.println(request.getParameter("deductionOrReward") + " amount : ");%></p><p id = "out31"><b><span id="ss"><%  out.println(request.getParameter("amountt")); %></span></b></p>
        <p id="out4"> <% out.println("Reason for " + request.getParameter("deductionOrReward") + " : ");%></p><p id = "out41"><b><span id="ss"><%  out.println(request.getParameter("reas")); %></span></b></p>


        <%

                boolean dedOrR = new Employees_Affairs().manageDed_rew(dedRew);

                color = "green";

                if (!dedOrR) {
                    out.print("Error Occured");
                } else {
                    boolean cash = new Payrolls().updateMonthlyCash();
                    boolean deduction = new Payrolls().updateMonthlyDeduction();
                }

            } catch (Exception ex) {
                out.println("ex: " + ex);
                ex.printStackTrace();

            }


        %>
    </body>
</html>

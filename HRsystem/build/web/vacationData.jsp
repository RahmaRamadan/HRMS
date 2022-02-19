<%-- 
    Document   : vacationData
    Created on : Apr 22, 2021, 9:47:33 PM
    Author     : egypt2
--%>



<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="DataAccess.EmployeesAffairs.MySQL_Vacation_DataAccess"%>
<%@page import="Entity.Vacation_Data"%>
<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.logging.Level"%>
<%@page import= "java.util.logging.Logger" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>
<%@page import= "java.time.LocalDate" %>
<%@page import= "java.util.Date" %>
<%@page import="java.time.temporal.TemporalQueries" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        
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
             #out5{
                color: #09C;
                font-size: 22px;
            }
             #out6{
                color: #09C;
                font-size: 22px;
            }
             #out7{
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
            #out51{
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
            #err{
                color: red;
                text-align: center;
                margin-top: 40px;
                font-family:sans-serif;
                font-size:40px;
            }
        </style> 
         <%
             try{
             Vacation_Data vac = new Vacation_Data(request.getParameter("nameField"),request.getParameter("idField"),
             request.getParameter("jobField"),request.getParameter("datee"),
             request.getParameter("vactions"), request.getParameter("numDays") );
             boolean addEmployees = new Employees_Affairs().checkVacation(vac);
               if(addEmployees){
            %>
             <h1 id="h">Your request has been submitted successfully</h1> 
        <hr id="line">
             <p id="out1"><%out.println("Name : ");%></p><p id = "out11"><b><span id="ss"><%  out.println(request.getParameter("nameField"));%>  </span></b></p>

         <p id="out2"> <% out.println("ID : ");%></p><p id = "out11"><b><span id="ss"><%  out.println(request.getParameter("idField"));%>  </span></b></p>
         <%

	MySQL_Vacation_DataAccess vacData = new MySQL_Vacation_DataAccess();
         if(vacData.getDaysBetween() >= 180 && vacData.getVacDays() > 0)
         {%>
         <p id="out3"> <% out.println("You were hired on : ");%></p><p id = "out31"><b><span id="ss"><%  out.println(vacData.getHiringDate()); %></span></b></p>
              
         <p id="out4"> <% out.println("PASSED 6 MONTHS"); %></p>
              
         <p id="out5"> <%out.println("Number of regular vacations available : ");%></p><p id = "out51"><b><span id="ss"><%  out.println(vacData.getVacDays()); %></span></b></p>
             
         <p id="out6"> <% out.println("Please wait for manager acceptance");%></p>
         
         <%
         }
        else
         {%>
         
         <p id="out7">  <%    out.println("You don't have any available vacations");}
            }

else{
%>
         <h3 id="err">Error Occurred, please make sure you entered the right ID</h3>
<%
}
}
         catch(Exception e){
          out.print(e);
            }

         %></p>
        
        
         
  
            
    </body>
</html>

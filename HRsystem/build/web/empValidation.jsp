<%-- 
    Document   : empValidation
    Created on : Jul 7, 2021, 4:32:22 PM
    Author     : egypt2
--%>


<%@page import="DataAccess.EmployeesAffairs.MySQL_Attendance_DataAccess"%>
<%@page import="DataAccess.EmployeesAffairs.MySQL_Employee_DataAccess"%>
<%@page import="Entity.Employee_Data"%>
<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.logging.LogManager"%>
<%@page import="java.util.logging.LogManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Validation</title>
        
    </head>
    <body>
         <%
            
              try
              {
                  
             boolean empLogin = new Employees_Affairs().loginValidation(request.getParameter("idd")
                     , request.getParameter("pass"), request.getParameter("uname"));
             Date CurrentDate = GregorianCalendar.getInstance().getTime();
             DateFormat df = DateFormat.getDateInstance();
       String dateString = df.format(CurrentDate);
       try{
       boolean attend = new Employees_Affairs().Attendance(dateString);
       }
       catch(Exception e){
           out.print(e);
       }
       
             MySQL_Attendance_DataAccess typeData = new MySQL_Attendance_DataAccess();
          
             if(empLogin){    
             if(!(typeData.getType().equals("Manager")) && (!(typeData.getDepID().equals("HR11"))))
             { response.sendRedirect("Trainings.jsp");}
             else{
                 response.sendRedirect("homePage.jsp");
             }
                 
             }
             else
             { 
               response.sendRedirect("empLogin2.jsp");
                
             }
             
      %>
      <form action="homePage.jsp" method="post">
    <%
    session.setAttribute("idd", request.getParameter("idd"));
    session.setAttribute("type", typeData.getType());
    session.setAttribute("hrType", typeData.getHRType());
    
        %>
       
    </form>
      <%
              }
       
              catch(Exception e){
                out.print(e);
                }

%>

    </body>
</html>

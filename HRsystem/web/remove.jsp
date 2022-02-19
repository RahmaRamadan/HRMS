<%-- 
    Document   : remove
    Created on : Feb 2, 2021, 7:02:38 PM
    Author     : egypt2
--%>


<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="DataAccess.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
   <%
       
       String message = "";
       String color = ""; 
     String id = request.getParameter("id");  
    boolean deleteEmp = new Employees_Affairs().deleteEmployee(id);     
       if(deleteEmp)
       {
           // alert emplyee is deleted
           color = "blue";
           out.print("Employee is deleted successfully");
    }
       else{
           // alert emp is not deleted
           color = "red";
           out.print("Error Occured");
 }
       %>
        <h4 style ="color: <%= color%>"><%= message%></h4>

<script>
    windows.location.replace("showEmployees.jsp");
</script>
</html>
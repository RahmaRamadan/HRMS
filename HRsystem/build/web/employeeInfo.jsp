<%@page import="DataAccess.DatabaseConnection"%>
<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.logging.Level"%>
<%@page import= "java.util.logging.Logger" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>


<html>
    <head>
        <title>Employee Information</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="cssEmployeeInfo.css">

    </head>

    <body>

        <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a   href="careers.jsp">CAREERS</a>
            <a href="homePage.jsp"<i class="fa fa-home"></i> HR HOME</a>
            <img class="logo" src = "logo.jpg" >
        </div>

        <%
            try {
                Connection con;
                PreparedStatement pat, pat1, pat2;
                ResultSet rs = null;
                DatabaseConnection db = new DatabaseConnection();
                con = db.getConnection();
                String query, query1, queryCombinedSalary;
                String employeeID = request.getParameter("id");

                // int empID = Integer.parseInt(employeeID);
                query = "SELECT salary.salaryID,employee.id,employee.first_name,salary.gross,cashadvance.description,deductions.description,COALESCE(deductions.amount,0) As deductions , COALESCE(cashadvance.amount,0) AS cashAdv,salary.netPay FROM employee JOIN salary ON ? = salary.emp_id JOIN deductions ON deductions.emp_id = ? JOIN cashadvance ON cashadvance.emp_id = ? WHERE employee.id = ?";
                pat = con.prepareStatement(query);
                //out.println("total: "+total);
                pat.setString(1, employeeID);
                pat.setString(2, employeeID);
                pat.setString(3, employeeID);
                pat.setString(4, employeeID);
                rs = pat.executeQuery();
                while (rs.next()) {

        %>
        <div id="printableArea">
            <table border = "1" class="styled-table">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><%=rs.getString("employee.first_name")%></td>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td><%=rs.getString("employee.id")%></td>
                    </tr>
                    <tr>
                        <td>Gross</td>
                        <td><%=rs.getString("salary.gross")%></td>
                    </tr>
                    <tr>
                        <td>Deduction</td>
                        <td><%=rs.getString("deductions")%></td>
                    </tr>
                    <tr>
                        <td>Deduction Description</td>
                        <td><%=rs.getString("deductions.description")%></td>
                    </tr>
                    <tr>
                        <td>Cash Advance</td>
                        <td><%=rs.getString("cashAdv")%></td>
                    </tr>
                    <tr>
                        <td>Cash Advance Description</td>
                        <td><%=rs.getString("cashadvance.description")%></td>
                    </tr>
                    <tr>
                        <td>Net Pay</td>
                        <td><%=rs.getString("salary.netPay")%></td>
                    </tr>
                </tbody>
            </table>
        </div>



        <% }
            } catch (Exception ex) {
                out.println("ex: " + ex);
                ex.printStackTrace();

            }%>  
        <button class="btn-print" onclick="printDiv('printableArea')">Print <i class="fa fa-print"></i></button>


        <a href="payroll.jsp"><Button class="back" style="width:80px;">Back </Button> </a>

        <script>
            function printDiv(divName) {
                var printContents = document.getElementById(divName).innerHTML;
                var originalContents = document.body.innerHTML;

                document.body.innerHTML = printContents;

                window.print();

                document.body.innerHTML = originalContents;
            }
        </script>

    </body>
</html>

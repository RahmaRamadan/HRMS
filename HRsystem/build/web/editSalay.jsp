<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="Application.Payroll.Payrolls"%>
<%@page import="Entity.Salary_Data"%>
<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.logging.Level"%>
<%@page import= "java.util.logging.Logger" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Details</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="cssEditSalary.css">

    </head>
    <body>
        <%
            Connection con;
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
                try {
 
                    Salary_Data salary = new Salary_Data("", request.getParameter("emp_id"), request.getParameter("gross"), "", "", request.getParameter("netPay"), "","");
                    boolean update = new Payrolls().updateSalary(salary);               
                    color = "#0492C2";
                    message = "Salary Updated Successfully";

                } catch (Exception ex) {
                    out.println("ex: " + ex);
                    ex.printStackTrace();
                    color = "red";
                    message = "Error Occured";
                }
            }
        %>
        <div class="form-group col-12 p-0">
            <h4 style ="color: <%= color%>"><%= message%></h4>
        </div>
        <form id="form" method="post" action="editSalay.jsp" class="form-horizontal">
            <%
                try {
                    PreparedStatement pat;
                    ResultSet rs;
                    DatabaseConnection db = new DatabaseConnection();
                    con = db.getConnection();
                    String id = request.getParameter("id");
                    pat = con.prepareStatement("select * from salary where emp_id = ?");
                    pat.setString(1, id);
                    rs = pat.executeQuery();

                    while (rs.next()) {

            %>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <h2 style="text-align: center">Salary Details</h2>
                </div>
            </div>
            <hr/>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Employee ID </label>
                    <input type="text" name="emp_id" class="form-control" id ="emp_id"  value = "<%=rs.getString("emp_id")%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Gross </label>
                    <input type="text" name="gross" class="form-control" id ="gross"  value = "<%=rs.getString("gross")%>">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Net Pay </label>
                    <input type="text" name="netPay" class="form-control" id ="netPay"  value = "<%=rs.getString("salary.netPay")%>">
                </div>
            </div>

            <br/>
            <div class="form-group" align="right">
                <div class="col-sm-2">
                    <Button class="btn btn-success" style="width: 80px">Submit</Button>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
            <% }
                } catch (Exception ex) {
                    out.println("ex: " + ex);
                    ex.printStackTrace();
                    color = "red";
                    message = "Error Occured";
                }
            %>
        </form>
        <div class="col-sm-12" align="right">
            <a href="payroll.jsp"><Button class="btn btn-success" style="width:80px;">Back </Button> </a>
        </div>                          
    </body>
</html>

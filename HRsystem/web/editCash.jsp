<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="Application.Payroll.Payrolls"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.CashAdvance_Data"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        <link rel="stylesheet" href="cssEditCash.css">
    </head>
    <body>
        <%
            Connection con;
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
                try {
                  
                    CashAdvance_Data cash = new CashAdvance_Data(request.getParameter("date"),
                            request.getParameter("emp_id"), "", request.getParameter("amount"),"");
                    boolean update = new Payrolls().updateCashAdvance(cash);
                  
                    color = "#0492C2";
                    message = "Cash Advance Amount Updated Successfully";

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
        <form id="form" method="post" action="editCash.jsp" class="form-horizontal">
            <%
                try {
                    PreparedStatement pat;
                    ResultSet rs;
                    DatabaseConnection db = new DatabaseConnection();
                    con = db.getConnection();
                    String id = request.getParameter("id");
                    pat = con.prepareStatement("select * from cashadvance where emp_id = ?");
                    pat.setString(1, id);
                    rs = pat.executeQuery();

                    while (rs.next()) {

            %>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <h2 style="text-align: center">Cash Advance Details</h2>
                </div>
            </div>
            <hr/>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Employee ID </label>
                    <input type="text" name="emp_id" class="form-control" id ="emp_id"  value = "<%= rs.getString("emp_id")%>">

                </div>     
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Date </label>
                    <input type="text" name="date" class="form-control" id ="date"  value = "<%= rs.getString("date")%>">

                </div>     
            </div>

            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-4 mx-auto"> 
                    <label > Amount </label>
                    <input type="text" name="amount" class="form-control" id ="amount"  value = "<%=rs.getString("amount")%>">
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
            <a href="cashAdvance.jsp"><Button class="btn btn-success" style="width:80px;">Back </Button> </a>
        </div>                          
    </body>
</html>

<%-- 
    Document   : AddMonthlySalary
    Created on : 14-Jul-2021, 22:08:30
    Author     : dell
--%>


<%@page import="Application.Payroll.Payrolls"%>
<%@page import="Entity.Salary_Data"%>
<%@page import="java.sql.Connection"%>
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
        <meta charset="utf-8">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Details</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        <link rel="stylesheet" href="cssMonthlySalary.css">
    </head>
    <body>

        <%
            Connection con;
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
                try {
                    Salary_Data salary = new Salary_Data("", request.getParameter("empID"), request.getParameter("amount"), "", "", "", "", request.getParameter("date"));
                    boolean addSalary = new Payrolls().addMonthlySalary(salary);
                    boolean updateSalary = new Payrolls().updateMonthlySalary();
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
         <body>
        <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="careers.jsp">CAREERS</a>
            <a href="homePage.jsp"<i class="fa fa-home"></i> HR HOME</a>
            <img class="logo" src = "logo.jpg" >
        </div>


        <div class="btn btn-suc">
            <span class="fas fa-bars"></span>
        </div>
        <nav class="sidebar">
            <div class="text"> HR System</div>
            <ul>
                <li class="active"><a href="#">Dashboard</a></li>

                <li>
                    <a href="#" class="recru-btn">Recruitment
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="recru-show">
                        <li><a href="#">Post a Job</a></li>
                        <li><a href="#">Jobs</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="affairs-btn">Employee Affairs
                        <span class="fas fa-caret-down second"></span>
                    </a>
                    <ul class="affairs-show">
                        <li><a href="add.jsp">Add Employees</a></li>
                        <li><a href="showEmployees.jsp">Show Employees</a></li>
                        <li><a href="vacation.jsp">Request Vacation</a></li>
                        <li><a href="showAnalysis.jsp">Show Analysis</a></li>
                        <li><a href="deductions.jsp">Make Deductions/Rewards</a></li>
                        <li><a href="AddMonthlySalary.jsp">Add Monthly Salary</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="pro-btn">Project Management
                        <span class="fas fa-caret-down sixth"></span>
                    </a>
                    <ul class="pro-show">
                        <li><a href="add.jsp">Add Milestone</a></li>
                    </ul>
                </li>


                <li>
                    <a href="#" class="eva-btn">Evaluation
                        <span class="fas fa-caret-down third"></span>
                    </a>
                    <ul class="eva-show">
                        <li><a href="Score.jsp">View Scores</a></li>
                        <li><a href="TrainMang.jsp">Training Management</a></li> 
                        <li><a href="Trainings.jsp">View Training</a></li>
                    </ul>
                </li>


                <li>
                    <a href="#" class="payroll-btn">Payroll
                        <span class="fas fa-caret-down forth"></span>
                    </a>
                    <ul class="pay-show">
                        <li>
                            <a href="#" class="employee-btn">Employees
                                <span class="fas fa-caret-down fifth"></span>
                            </a>
                            <ul class="emp-show">
                                <li><a href="cashAdvance.jsp">Cash Advance</a></li>
                                <li><a href="deductions_1.jsp">Deductions</a></li>
                                <li><a href="payroll.jsp">Payroll</a></li>
                            </ul>
                        </li>

                    </ul>
                </li>
            </ul>
        </nav>
        <div class="form-group col-12 p-0">
            <h4 style ="color: <%= color%>"><%= message%></h4>
        </div>
        <div class ="container">
            <form id="contain" method="post" action="AddMonthlySalary.jsp" class="form-horizontal">

                <div class="form-group">
                    <div class="col-sm-4"></div>

                    <h2 id="empDetails">Insert Monthly Salary</h2>

                </div>
                <hr/>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="id"> Employee ID </label>
                        <input type="text" name="empID" class="form-control" id ="empID">

                    </div>     
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="firstname"> Date </label>
                        <input type="text" name="date" class="form-control" id ="date">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="lastname"> Salary </label>
                        <input type="text" name="amount" class="form-control" id ="amount">
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
                <br>
            </form>
            <div class="col-sm-12" align="right">
                <a href="payroll.jsp"><Button class="btn btn-success" style="width:80px;">Back </Button> </a>
            </div>   
        </div>
            <script>
                $('.btn').click(function () {
                    $(this).toggleClass("click");
                    $('.sidebar').toggleClass("show");
                });
                $('.recru-btn').click(function () {
                    $('nav ul .recru-show').toggleClass("show");
                    $('nav ul .first').toggleClass("rotate");
                });
                $('.affairs-btn').click(function () {
                    $('nav ul .affairs-show').toggleClass("show1");
                    $('nav ul .second').toggleClass("rotate");
                });

                $('.eva-btn').click(function () {
                    $('nav ul .eva-show').toggleClass("show2");
                    $('nav ul .third').toggleClass("rotate");
                });
                $('.payroll-btn').click(function () {
                    $('nav ul .pay-show').toggleClass("show3");
                    $('nav ul .forth').toggleClass("rotate");
                });
                $('.employee-btn').click(function () {
                    $('nav ul .emp-show').toggleClass("show4");
                    $('nav ul .fifth').toggleClass("rotate");
                });

                $('.pro-btn').click(function () {
                    $('nav ul .pro-show').toggleClass("show6");
                    $('nav ul .sixth').toggleClass("rotate");
                });
                $('nav ul li').click(function () {
                    $(this).addClass("active").siblings().removeClass("active");
                });

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

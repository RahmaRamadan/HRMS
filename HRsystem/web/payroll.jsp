<%@page import="Application.Payroll.Payrolls"%>
<%@page import="Entity.Salary_Data"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Employee Registration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        <link rel="stylesheet" href="cssPayroll.css">

    </head>
    <body>
        
        <div class="divScroll">
        <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="careers.jsp">CAREERS</a>
            <a href="navBar.jsp"<i class="fa fa-home"></i> HR HOME</a>
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
           

        <div class="form-group">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h2 style="text-align: left " class="head">Employee's Salary Details</h2> 
            </div>
        </div>
        <div class="col-sm-2">
            <form action="" method="get"  >
                <div class="search">
                    <input type="text" class="search" name="q" placeholder="Search here..."/>
                </div>
            </form>
        </div>
        <br/>
        <button class="print-button" onclick="printDiv('printableArea')"><span class="print-icon"></span></button>

        <div id="printableArea"media="print">

            <br/>
           
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Employee Name</th>
                        <th scope="col">Employee ID</th>
                        <th scope="col">Gross</th>
                        <th scope="col">Deductions</th>
                        <th scope="col">Cash Advance</th>
                        <th scope="col">Net Pay</th>
                    </tr>

                </thead>
                <tbody>
                    
                    <%

                        try {

                            String search = request.getParameter("q");
                            boolean s = new Payrolls().updateMonthlySalary();
                            ArrayList<Salary_Data> salary = new Payrolls().Get_Salary_Data(search);
                            
                            //System.out.println("searrrrrch: "+search);
                            for (int i = 0; i < salary.size(); i++) {


                    %>

                

                    <tr>
                        <th scope="row"><%= salary.get(i).getEmployeeName()%> </th>
                        <td> <%= salary.get(i).getEmployeeID()%></td>
                        <td> <%= salary.get(i).getGross()%></td>
                        <td> <%= salary.get(i).getDeductions()%></td>
                        <td> <%= salary.get(i).getCashAdv()%></td>
                        <td> <%= salary.get(i).getNetPay()%></td>

                        
                        <td><a class="btn btn-success" id="edit" href="editSalay.jsp?id=<%= salary.get(i).getEmployeeID()%>" role="button">Edit</a>
                            <a class="btn btn-danger" id="remove" href="removeSalary.jsp?id=<%= salary.get(i).getEmployeeID()%>" role="button">Remove</a>
                            <a class="btn btn-info" id="info" href="employeeInfo.jsp?id=<%= salary.get(i).getEmployeeID()%>" role="button">Info</a>
                            <a class="btn btn-info" id="info" href="viewStatistics.jsp?id=<%= salary.get(i).getEmployeeID()%>" role="button">Chart</a>
                    </tr>

                    <% }
                        } catch (Exception ex) {
                            out.println("ex: " + ex);
                            ex.printStackTrace();
                        }
                    %>
                </tbody>

            </table>
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
        </div>
    </body>
</html>

<%-- 
    Document   : showEmployees
    Created on : Feb 4, 2021, 7:56:39 PM
    Author     : egypt2
--%>

<%@page import="DataAccess.DatabaseConnection"%>
<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Employee_Data"%>
<%@page import="Application.HR_Employee"%>
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
        <title>Employee Registration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        
        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
            body {
                
                background-repeat: no-repeat;
                background-attachment: fixed;
                /*background-size: 100% 100%;*/
                top:100px;
            }
            *{
               
                user-select: none;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            .navBar {
  overflow: hidden;
  padding-right: 20px;
  padding-left: 40px;
  padding-top: 20px;
}

.navBar a {
  float: right;
  color: #0065A2;
  text-align: center;
  padding: 20px 20px;
  text-decoration: none;
  font-size: 18px;
}

.navBar a:hover {
 /* background-color: #0065A2;
  color: whitesmoke;*/
 background: none;
  color: #0492C2;
}

.navBar a.back {
  color: cadetblue;
  float: left;
}
.logo {
  color: white;
  float: left;
  width: 120px;
  height: 70px;
}
             .btn-suc{
                position: absolute;
               top: 100px;
                left: 40px;
                height: 45px;
                width: 45px;
                text-align: center;
                background: #eae9e9;
                border-radius: 3px;
                cursor: pointer;
                transition: left 0.4s ease;
            }
            .btn-suc.click{
                left: 220px;
            }
            .btn-suc span{
                color: #0492C2;
                font-size: 28px;
                line-height: 40px;
            }
            .btn-suc.click span:before{
                content: '\f00d';
            }
            .sidebar{
                position: fixed;
                width: 250px;
                height: 100%;
                left: -250px;
                background: white;
                transition: left 0.4s ease;
            }
            .sidebar.show{
                left: -30px;
            }
            .sidebar .text{
                color: #1f6d8f;
                font-size: 25px;
                font-weight: 600;
                line-height: 65px;
                text-align: center;
                background: white;
                letter-spacing: 1px;
            }
            .text{
                background: gray;
            }
            nav ul{
                background: #f7f7f7;
                height: 100%;
                width: 100%;
                list-style: none;
            }
            nav ul li{
                line-height: 60px;
                border-top: 1px solid rgba(0,0,0,0.1);
            }
            nav ul li:last-child{
                border-bottom: 1px solid rgba(0,0,0,0.05);
            }
            nav ul li a{ /*el font nfso*/
                position: relative;
                color: black;
                text-decoration: none;
                font-size: 18px;
                padding-left: 40px;
                font-weight: 500;
                display: block;
                width: 100%;
                border-left: 3px solid transparent;
            }
            nav ul li.active a{ /*el bta3a el nzla*/
                color: black;
                background: white;
                border-left-color: black;
            }
            nav ul li a:hover{
                background: #1f6d8f; /*de bta3t el t7ded 3l klam*/
                color: white;
            }
            nav ul ul{
                position: static;
                display: none;
            }
            nav ul .recru-show.show{
                display: block;
            }
            nav ul .affairs-show.show1{
                display: block;
                font-size: 12px;
            }
            nav ul .eva-show.show2{
                display: block;
            }
            nav ul .pay-show.show3{
                display: block;
            }
            nav ul .emp-show.show4{
                display: block;
            }
            
             nav ul .pro-show.show6{
                display: block;
            }
            nav ul ul li{
                line-height: 42px;
                border-top: none;
            }
            nav ul ul li a{
                font-size: 17px;
                color: #e6e6e6;
                padding-left: 80px;
            }
            nav ul li.active ul li a{
                color: black;
                padding-left: 5px;
                background: white;
                border-left-color: transparent;
            }
            nav ul ul li a:hover{
                color: black!important;
                background: #1f6d8f!important;
            }
            nav ul li a span{
                position: absolute;
                top: 50%;
                right: 20px;
                transform: translateY(-50%);
                font-size: 22px;
                transition: transform 0.4s;
            }
            nav ul li a span.rotate{
                transform: translateY(-50%) rotate(-180deg);
            }
            .pro-btn{
                font-size: 13px;
            }
            .affairs-btn{
                font-size: 13px;
            }
            .eva-btn{
                 font-size: 13px;
            }
            .payroll-btn{
                 font-size: 13px;
            }
            .recru-btn{
                 font-size: 13px;
            }
            .employee-btn{
                 font-size: 13px;
            }
            .content{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                color: #202020;
                z-index: -1;
                text-align: center;
            }
            .content .header{
                font-size: 45px;
                font-weight: 600;
            }
            .content p{
                font-size: 30px;
                font-weight: 500;
            }
            #emp{
                color: #0492C2;
                margin-left:300px;
            }
            .form-control{
                margin-left: 300px;
            }
            .btn-success{
                background-color:#0492C2; /*#2832C2;*/
}

.btn-success:hover{
    background-color: cornflowerblue;
}

.btn-danger:hover{
    background-color: #FA8072;
}

.table-hover{
    color: #241571;
    margin-left:280px;
    top:20px;
    font-size: 17px;
    font-family:sans-serif;
    width: 80%;
}

        </style>
    </head>
    <body>
        
         <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a   href="careers.jsp">CAREERS</a>
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
            
                <h2 id="emp" style="text-align: left">Employee Details</h2>
          
        </div>
         <div class="col-sm-2">
             <form action="" method="get">
                 <input type="text" class="form-control" align="right" name="q" placeholder="Search here..."/><br/>
             </form>
          </div>
        
        <br/>
        <table class="table table-hover" >
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Position</th>
                </tr>
            </thead>
            <tbody>
            <%
                String search = request.getParameter("q");
               ArrayList<Employee_Data> employees = new Employees_Affairs().getEmployees(search);
               // ArrayList<Employee_Data> employees = new ArrayList<>();
                for (int i=0 ;i <employees.size();i++){
                %>
                <tr>
                    <th scope="row"> <%= employees.get(i).getID() %></th>
                    <td> <%=employees.get(i).getFName() %></td>
                    <td> <%=employees.get(i).getLName() %></td>
                    <td> <%=employees.get(i).getAddress() %></td>
                    <td> <%=employees.get(i).getUsername() %></td>
                    <td> <%=employees.get(i).getSalary() %></td>
                    <td> <%=employees.get(i).getTitle() %></td>
                    <td><a class="btn btn-success" href="update.jsp?id=<%=employees.get(i).getID() %>" role="button">Edit</a>
                        <a class="btn btn-danger" href="remove.jsp?id=<%=employees.get(i).getID()%>" role="button">Remove</a>
                </tr>
                <% } %>
            </tbody>
        </table>
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
        </script>
    </body>
</html>

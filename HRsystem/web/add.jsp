<%-- 
    Document   : add
    Created on : Feb 2, 2021, 5:52:12 PM
    Author     : egypt2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Application.EmployeesAffairs.Employees_Affairs"%>
<%@page import="Entity.Employee_Data"%>
<%@page import="java.util.Date"%>
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
                background-size: 100% 100%;
                font-family:"Open Sans", Helvetica, Arial, sans-serif;
                font-weight:300;
                font-size: 12px;
                line-height:30px;
                color:#777;
                background:window;

            }

            * {
                margin:0;
                padding:0;
                user-select: none;   
                font-family: 'Poppins', sans-serif;
                box-sizing:border-box;
                -webkit-box-sizing:border-box;
                -moz-box-sizing:border-box;
                -webkit-font-smoothing:antialiased;
                -moz-font-smoothing:antialiased;
                -o-font-smoothing:antialiased;
                font-smoothing:antialiased;
                text-rendering:optimizeLegibility;
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
                background: white;
                padding-left: 5px;
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


            #empDetails{
                font-size:40px;
                color:#0492C2;
                font-style:inherit;
                text-align:inherit;
            } 



            .container {
                max-width:800px;
                width:100%;
                margin:0 auto;
                position:relative;
            }



            .btn-success1{
                background-color:#0492C2;
            }

            .btn-success1:hover{
                background-color:cornflowerblue;
            }

            .form-group{
                font-size: 15px;
                font-style:normal;
            }
            
            #sk{
                width: 260px;
            }

        </style>
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
          
            String message = "";
            String color = "";
            if (request.getMethod().compareToIgnoreCase("post") == 0) {
              try{
             Employee_Data emp = new Employee_Data(request.getParameter("id"),request.getParameter("first_name"),
                   request.getParameter("last_name"), request.getParameter("gender"),
                   request.getParameter("username"),request.getParameter("passwordd"),
                   request.getParameter("address"),request.getParameter("salary"), request.getParameter("position"),
                   "0", request.getParameter("hiring_date"), request.getParameter("age"),
                   request.getParameter("empOrManager"),request.getParameter("dep_id"),
                   request.getParameter("type"), request.getParameter("hrComponent"));
             
             
             ArrayList<String> empSkills = new ArrayList<>();
             String[] skills = request.getParameterValues("skills");
              for(int i = 0 ; i < skills.length ; i++)
              {
                  empSkills.add(i, skills[i]);
              }
              emp.setSkills(empSkills);
             
             boolean addEmployees = new Employees_Affairs().addEmployee(emp);
             color = "green";
                if (addEmployees) {
                    
                    message = "Employee Added Successfully";
                } else {
                    color = "red";
                    message = "Error Occured";
                }
             
                 } catch (Exception ex) {
                    out.println("ex: " + ex);
                  
                }

            }
        %>
    


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
            <h4 style="text-align: center" style ="color: <%= color%>"><%= message%></h4>
        </div>
        <div class ="container">
            <form id="contain" method="post" action="add.jsp" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-4"></div>

                    <h2 id="empDetails">Employee Details</h2>

                </div>
                <hr/>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="id"> ID </label>
                        <input type="text" name="id" class="form-control" id ="id">

                    </div>     
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="firstname"> First Name </label>
                        <input type="text" name="first_name" class="form-control" id ="first">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="lastname"> Last Name </label>
                        <input type="text" name="last_name" class="form-control" id ="last">
                    </div>
                </div>
                 <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="gender"> Gender </label>
                        <input type="text" list="genderr" autocomplete="off" name="gender" class="form-control" id ="gen">
                        <datalist id="genderr">
                <option>Male</option>
                <option>Female</option>
                </datalist>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="username"> User Name </label>
                        <input type="text" name="username" class="form-control" id ="uname">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="password"> Password </label>
                        <input type="password" name="passwordd" value="000" class="form-control" id ="pass">
                        <input type="checkbox" onclick="myFunction()"> Show Password
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="address"> Address</label>
                        <input type="text" name="address" class="form-control" id ="addressE">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="salary"> Salary</label>
                        <input type="text" name="salary" class="form-control" id ="salary">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="position"> Position</label>
                        <input type="text" name="position" class="form-control" id ="position">
                    </div>
                </div>
              
                
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="hiring_date"> Hiring Date </label>
                        <input type="date" name="hiring_date" class="form-control" id ="hiring_date">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="age"> Age </label>
                        <input type="text" name="age" class="form-control" id ="age">
                    </div>
                </div>
                
                 <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="dep_id"> Department ID </label>
                        <input type="text" list="depID" autocomplete="off" name="dep_id" class="form-control" id ="dep_id">
                        <datalist id="depID">
                <option>HR11</option>
                <option>FIN11</option>
                <option>MAR11</option>
                <option>SAL11</option>
                <option>IT11</option>
                <option>ACC11</option>
                <option>GEN11</option>
                </datalist>
                    </div>
                </div>
                
                 <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                        <label for="type"> Department </label>
                        <input type="text" list="typee" autocomplete="off" name="type" class="form-control" id ="type">
                        <datalist id="typee">
                <option>Human Resources</option>
                <option>Finance</option>
                <option>Marketing</option>
                <option>Sales</option>
                <option>Information Technology</option>
                <option>Accounting</option>
                <option>General</option>
                </datalist>
                        
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 
                       
                <label for="hrComp">Choose HR Section:</label>
               
                <input type="text" list="hrComp" autocomplete="off" name="hrComponent" class="form-control" id ="hrComponent"/>
                <datalist id="hrComp">
                <option>Employee Affairs</option>
                <option>Recruitment</option>
                <option>Payroll</option>
                <option>Evaluation</option>
                </datalist>
                 </div>
                </div>
                
              <div class="form-group">
                <table style="margin-left: 33%">
                       <tr>
                           <td>
                              <div id="inputFormSkill">
                                    <table>
                                        <tr>
                                            <td>
                                                <label>Skill</label> <input id="sk" type="text" name="skills" class="form-control m-input" placeholder="Enter a Skill" autocomplete="off" required>
                                            </td>
                                        </tr>
                                    </table> 
                                    <div class="input-group mb-3"> </div>
                                </div>

                            </td>
                       </tr>
                        <tr>
                            <td>
                                <div id="newSkill"></div>
                             
                                <input  style="background-color: white; color:blue; right: 500px; border: none ; font-size: 20px " id="addSkill" value="Add Extra Skill" type="button">

                            </td>
                        </tr>

                    </table>
              </div>
                
                
                <br style="margin-top: 4px">
                <div class="form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4 mx-auto"> 

                        <input type="radio" id="emp" name="empOrManager" value="employee">
                        <label for="emp" style="font-family:verdana; font-size: 15px;"> Employee </label>  &nbsp; &nbsp;
                        <input type="radio" id="mang" name="empOrManager" value="manager">
                        <label for="mang" style="font-family:verdana; font-size: 15px;"> Manager </label>
                    </div>
                </div>
                <br>


                <div class="form-group" align="center">
                    <div class="col-sm-2">
                        <Button class="btn btn-success1" style="width: 120px">Submit</Button>
                    </div>
                    <div class="col-sm-4">
                    </div>
                </div>
                <br/>
            </form>

        </div>
        <br/>
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
            function myFunction() {
                var x = document.getElementById("pass");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }



        </script>
        
        <script type="text/javascript">

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
    $('nav ul li').click(function () {
        $(this).addClass("active").siblings().removeClass("active");
    });
    // add row
    $("#addSkill").click(function () {
        var html = '';
        html += '<div id="inputFormSkill">';

        html += '<div class="input-group mb-3">';
        html += '<br>';
        html += '<table><tr><td>Skill <input type="text" name="skills" class="form-control m-input" placeholder="Enter a Skill" autocomplete="off">';
        html += '<div class="input-group-append">';

        html += '<input style="background-color: red; color:white" id="removeSkill" value="Remove" type="button"> </td></tr></table>';
        html += '</div>';
        html += '</div>';

        $('#newSkill').append(html);
    });

    // remove row
    $(document).on('click', '#removeSkill', function () {
        $(this).closest('#inputFormSkill').remove();
    });




</script>
    </body>
</html>
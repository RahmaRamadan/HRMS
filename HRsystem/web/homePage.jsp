<%-- 
    Document   : homePage
    Created on : Feb 5, 2021, 12:28:13 AM
    Author     : egypt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
         <link rel="stylesheet" href="style.css">
          <link rel="stylesheet" href="navigationBar2.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet"
              href ="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-
              awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com./bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
            
             *
                {
                    margin: 0;
                    padding: 0;
                }
                #nav-bar{
                    position: sticky;
                    top: 0;
                    z-index: 10;
                    background:#0065A2;
                    
                }
                .navbar-brand img{
                    height: 70px;
                    width: 120px;
                    padding-left: 30px;
                    
                }
                
                .navbar-nav li{
                    padding: 0 10px;
                }
                
                .navbar-nav li a{
                    float: right;
                    text-align: left;
                }
                
                #nav-bar ul li a:hover{
                    background: none;
                    color: blue;
                }
                
                .navbar-toggler{
                    border: none;
                }
                
                .nav-link{
                    color: #555;
                    position:static;
                    font-weight: 600;
                    font-size: 16px;                   
                }
            body {
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
                 background-image:url("hr7.jpg");
                 
            }
            *{
                margin: 0;
                padding: 0;
                user-select: none;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            .btn{
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
            .btn.click{
                left: 220px;
            }
            .btn span{
                color: darkblue;
                font-size: 25px;
                line-height: 40px;
            }
            .btn.click span:before{
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

            .content{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                color: #202020;
                z-index: -1;
                text-align: left;
            }
            .content .header{
                font-size: 45px;
                font-weight: 600;
            }
            .content p{
                font-size: 30px;
                font-weight: 500;
            }
            
            #hd{
                color: #eae9e9;
                margin-left: 300px;
                font-weight: bold;
            }
            
            #par{
                color: #eae9e9;
                margin-left: 300px;
                margin-top: 40px;
                font-style: italic;
            }
            
            footer{
    position:absolute;
    bottom: 0;
    left: 0;
    right: 0;
    background: #eae9e9;
    height: 60px;
    width: 100vw;
    font-family: "Open Sans";
    color: #2C3E4C;
    display: flex;
        flex-direction: column;


    
}

.socials{
    list-style:none;
    display:inline-block;
    align-items: center;
    justify-content: center;
    
}
.socials li{
    margin: 0 10px;
}
.socials a{
    text-decoration: none;
    color: #48AAAD;
}
.socials a i{
    font-size: 1.1rem;
    transition: color .4s ease;

}
.socials a:hover i{
    color: #2C3E4C;;
}

.footer-bottom{
    background: #eae9e9;
    width: 100vw;
    text-align: center;
    height: 300px;
}

.footer-bottom p{
    font-size: 14px;
    word-spacing: 2px;
    text-transform: capitalize;
}
.footer-bottom span{
    text-transform: uppercase;
    opacity: .8;
    font-weight: 200;
}

.affairs-show{
    font-size: 10px;

}

.fas fa-caret-down second{
    left: 0px;
}
        </style>
    </head>
    <body>
        
<div class="navBar">
            <a href="index.html">LOGOUT</a> 
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="viewEmployeeMilestones.jsp">MY MILESTONES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>
         <%
            try{
               
            String type = session.getAttribute("type").toString();
            String HRType = session.getAttribute("hrType").toString();        
            %>
      
        <div class="btn">
            <span class="fas fa-bars"></span>
        </div>
        <nav class="sidebar">
            <div class="text"> HR System</div>
            <ul>
                <li class="active"><a href="#">Dashboard</a></li>
          <%if(type.equals("Manager") || HRType.equals("Recruitment")) { %>
                <li>
                    <a href="#" class="recru-btn">Recruitment
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="recru-show">
                        <li><a href="addJob.html">Post a Job</a></li>
                        <li><a href="recuHome.jsp">Jobs</a></li>
                    </ul>
                </li>
                <% } %>

                 <%if(type.equals("Manager") || HRType.equals("Employee Affairs")) { %>
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
                <% } %>
                
                <%if(type.equals("Manager")) { %>
                <li>
                    <a href="#" class="pro-btn">Projects
                        <span class="fas fa-caret-down sixth"></span>
                    </a>
                    <ul class="pro-show">
                        <li><a href="addProject.html">Add Project</a></li>
                         <li><a href="viewProjects.jsp">Posted Projects</a></li>
                    </ul>
                </li>
                <% } %>
                

                <%if(type.equals("Manager") || HRType.equals("Evaluation")) { %>
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

                <% } %>
                

                 <%if(type.equals("Manager") || HRType.equals("Payroll")) { %>
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
                 <% } %>
            </ul>
              <%
                }
                catch(Exception e){
                out.print(e);
                 }%>
        </nav>
        <h1 id="hd">Egyptian International <br/> Development Company</h1>
        <p id="par"> Manage and access all sensitive employee data, track employees' <br/>
            attendance and evaluate their performance,<br/> ALL THROUGH OUR WEBSITE!</p>
        <footer> 
        <div class="footer-content">
           
        </div>
        <div class="footer-bottom">
             <h3>HR Management System</h3>
            <p>An Egyptian Human Resources Intelligent System</p>
            <ul class="socials">
                <li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                <li><a href="https://twitter.com/?lang=en"><i class="fa fa-twitter"></i></a></li>
                <li><a href="https://www.youtube.com/"><i class="fa fa-youtube"></i></a></li>
                
            </ul>
            <p>copyright &copy;2021 EIDC. designed by <span>FCAI Students</span></p>
        </div>
        
        
        
        
        </footer>
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

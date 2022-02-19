<%-- 
    Document   : deductions
    Created on : Apr 29, 2021, 12:30:50 AM
    Author     : egypt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <title>Deductions and Rewards</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

* {
	
	padding:0;
	box-sizing:border-box;
	-webkit-box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-font-smoothing:antialiased;
	-moz-font-smoothing:antialiased;
	-o-font-smoothing:antialiased;
	font-smoothing:antialiased;
	text-rendering:optimizeLegibility;
}

body {
	font-family:"Open Sans", Helvetica, Arial, sans-serif;
	font-weight:300;
	font-size: 12px;
	line-height:30px;
	color:#777;
	background:white;
}

.container {
	max-width:500px;
	width:100%;
                height: 800px;
	margin:0 auto;
	position:relative;
}

.navBar {
                overflow: hidden;
                padding-right: 20px;
                padding-left: 40px;
                padding-top: 20px;
                }

            .navBar a {
                float: right;
                color: #0492C2;
                background: none;
                text-align: center;
                padding: 20px 20px;
                text-decoration: none;
                font-size: 18px;
                }
            .navBar a:hover {
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

                height: 50px;
                width: 100px;
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


#contact {
	background:buttonface;
	padding:25px;
	margin:50px 0;
}

#contact h3 {
	color: #0492C2;
	display: block;
	font-size: 30px;
	font-weight:bold;
        margin:5px 0 25px;
}



fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="text"], #contact input[type="text"], #contact input[type="date"],#contact input[type="number"],#contact textarea {
	width:100%;
	border:1px solid #CCC;
	background:#FFF;
	margin:0 0 5px;
	padding:10px;
}

#contact input[type="text"]:hover, #contact input[type="text"]:hover, #contact input[type="text"]:hover, #contact input[type="date"]:hover,#contact input[type="number"]:hover, #contact textarea:hover {
	-webkit-transition:border-color 0.3s ease-in-out;
	-moz-transition:border-color 0.3s ease-in-out;
	transition:border-color 0.3s ease-in-out;
	border:1px solid #AAA;
}

#contact textarea {
	height:100px;
	max-width:100%;
  resize:none;
}

#contact button[type="submit"] {
	cursor:pointer;
	width:100%;
	border:none;
	background:#0492C2;
	color:#FFF;
	margin:0 0 5px;
	padding:10px;
	font-size:15px;
}

#contact button[type="submit"]:hover {
	background:#09C;
	-webkit-transition:background 0.3s ease-in-out;
	-moz-transition:background 0.3s ease-in-out;
	transition:background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active { box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5); }

#contact input:focus, #contact textarea:focus {
	outline:0;
	border:1px solid #999;
}
::-webkit-input-placeholder {
 color:#888;
}
:-moz-placeholder {
 color:#888;
}
::-moz-placeholder {
 color:#888;
}
:-ms-input-placeholder {
 color:#888;
}

#salID{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 20px;
}   
#empID{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 20px;
}   

#empName{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 20px;
}

#reas{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin-top: 10px;
  padding-top: 10px;
}
#ded{
    font-size: 20px;
    font-style:normal;
    margin: 0 0 20px;
}

#reward{
    font-size: 20px;
    font-style:normal;
    margin: 0 0 20px;
}
#datee{
     height: 35px;
	max-width:100%;
        width:550px;
  resize:none;
  margin: 0 0 10px;
}   

#amountt
{
    margin: 10px;
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

        <div class="container">
	<form id="contact" action="deductionRewardData.jsp" method="post">
             <h3>&#128528 Deductions / Rewards &#128522</h3>
             <input type="text" id ="empID" name="empID" placeholder="Employee ID"><br>
             <input type="text" id="empName" name="empName" placeholder="Employee name"><br>
           
             <input type="radio" id="ded" name="deductionOrReward" value="Deduction">
             <label for="ded" style="font-family:verdana"> Deduction </label><br>
  <input type="radio" id="reward" name="deductionOrReward" value="Reward">
  <label for="reward" style="font-family:verdana"> Reward </label><br>
  <input type="text" id="amountt" name="amountt" placeholder="Amount (in pounds)">
  <input name ="datee" placeholder="Date" type="date" tabindex="4" required> <br>  
  <textarea type="textbox" style="font-family:verdana" name="reas" placeholder="Reason" id="reason" rows="4" cols="50"></textarea>
 <!--  <input type="button" value="Submit" id="contact-submit" onclick="return take_values()">-->
		<button name="submit" type="submit" id="contact-submit">Apply to employee's salary</button>
	</form>
        </div>

    </body>
</html>

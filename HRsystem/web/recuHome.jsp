<%-- 
    Document   : RecuHome
    Created on : Feb 1, 2021, 9:20:15 PM
    Author     : maria
--%>

<%@page import="Entity.Recruitment.Job"%>
<%@page import="DataAccess.Recruitment.MySQL_Job_DataAccess"%>
<%@page import="DataAccess.Recruitment.Employee_Job_DataAccess_Interface"%>
<%@page import="java.util.HashMap"%>

<%@page import="Entity.Department "%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.ArrayList"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en" dir="ltr">
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="search.css">
        <link rel="stylesheet" href="navigationBar2.css">
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>



        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" href="verticalNavBar.css">
        <title>Jobs</title>

        <style>
       
            body {
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
                 background-image:url("hr7.jpg");
                 
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
    <body style="background-image: none;">

        
        <div class="navBar">
            <a href="index.html">LOGOUT</a> 
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>

  
    <body>
 
                <div class="navBar">
            <a href="index.html">LOGOUT</a>
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="viewEmployeeMilestones.jsp">My Milestones</a> 
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
                        <li><a href="recuHome.jsp">View Posted Jobs</a></li>
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
                        <li><a href="add.jsp">Add Milestone</a></li>
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
        <% 
            Employee_Job_DataAccess_Interface ej = new MySQL_Job_DataAccess();%>


        <% if (ej.checkThereAreJobs()) {
                ArrayList<Job> myJobs = ej.getAllJobs();
                 Map<Department, ArrayList<Job>> jobs = new HashMap();
                for (int j = 0; j < myJobs.size(); j++) {
                    if (jobs.containsKey(myJobs.get(j).getCategory())) {
                        ArrayList<Job> jobsTemp = jobs.get(myJobs.get(j).getCategory());
                        jobsTemp.add(myJobs.get(j));
                        jobs.put(myJobs.get(j).getCategory(), jobsTemp);
                    } else {
                        ArrayList<Job> jobsTemp = new ArrayList();
                        jobsTemp.add(myJobs.get(j));
                        jobs.put(myJobs.get(j).getCategory(), jobsTemp);
                    }
                }


        %> <h1 style="text-align: center; color:  darkslateblue;"> Posted Jobs</h1>
        <h2 style="text-align: center; color: darkslateblue;">Total (<% out.print(myJobs.size());%>) Jobs</h2>
        <br><br>
        <div id="myMenu" >
             <table style="background-color: white;margin-left: auto; margin-right: auto; width: 900px; font-size: 15px">
           
            <tr>
                <td>
                <div class="left"  >



                    <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search.." title="Type in a category">



                    <div id="allJobs">



                        <ul id="jobID" style="list-style-type:none">
                         <%   for (Map.Entry<Department, ArrayList<Job>> pair : jobs.entrySet()) { %>
                                <div id=<%= pair.getKey().toString() %>  >
                                    <h1 style="color:white; background-color: #0065A2">
                                        <%   out.print(pair.getKey().toString());  %>
                                    </h1>  
                                    <%   for (int i = 0; i < pair.getValue().size(); i++) { %>
                                    <li style="background-color: #f7f7f7;"><a style="color: #0065A2" href=showJob.jsp?jobID=<% out.print(pair.getValue().get(i).getID());%>> <% out.print(pair.getValue().get(i).getTitle()); %> </a></li>
                                 
                                        <% }
                                        %>  
                                    
                                </div>
                           </ul> <%
                                }} else {
                                    out.print("There isn't any posted jobs.");
                                }
                            %>
                    </div>


                </div>
                </td>
            </tr>
             </table>


                
        </div>
        <br>
        <br>

        <br><br>

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
            $('nav ul li').click(function () {
                $(this).addClass("active").siblings().removeClass("active");
            });
            function filter()
            {
                var x, y;
                if (document.querySelector('#option:checked') !== null)
                {
                    x = document.getElementById("allJobs")
                    x.style.display = "none";
                    y = document.getElementById("myJobs")
                    y.style.display = "block";



                } else {
                    x = document.getElementById("allJobs")
                    x.style.display = "block";
                    y = document.getElementById("myJobs")
                    y.style.display = "none";


                }
            }
            function myFunction() {
                var input, filter, ul, li, a, i;
                input = document.getElementById("mySearch");
                filter = input.value.toUpperCase();
                ul = document.getElementById("myMenu");
                li = ul.getElementsByTagName("li");


                for (i = 0; i < li.length; i++) {

                    a = li[i].getElementsByTagName("a")[0];
                    if ((a.innerHTML.toUpperCase().indexOf(filter) === 1) || (filter === "")) {

                        li[i].style.display = "";
                    } else {
                        li[i].style.display = "none";
                    }
                }
            }
        </script>


    </body>
</html>



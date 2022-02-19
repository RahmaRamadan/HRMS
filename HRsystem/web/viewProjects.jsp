<%-- 
    Document   : RecuHome
    Created on : Feb 1, 2021, 9:20:15 PM
    Author     : maria
--%>

<%@page import="Entity.TimeTracking.Project"%>
<%@page import="Algorithms.TimeTracking.ProjectManager"%>
<%@page import="Entity.DepartmentID"%>
<%@page import="java.util.HashMap"%>

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
        <title>Projects</title>

    </head>
   <body style="background-image: none;">

        
        <div class="navBar">
            <a href="index.html">LOGOUT</a> 
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>


        <div class="btn">
            <span class="fas fa-bars"></span>
        </div>
        <nav class="sidebar" >
            <div class="text"> HR System</div>
            <ul>
                <li class="active"><a href="#">Dashboard</a></li>

                <li>
                    <a href="#" class="recru-btn">Recruitment
                        <span class="fas fa-caret-down first"></span>
                    </a>
                    <ul class="recru-show">
                        <li><a href="addJob.html">Post a Job</a></li>
                        <li><a href="recuHome.jsp">Jobs</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="affairs-btn">Employee Affairs
                        <span class="fas fa-caret-down second"></span>
                    </a>
                    <ul class="affairs-show">
                        <li><a href="#">Add Employees</a></li>
                        <li><a href="#">Show Employees</a></li>
                        <li><a href="#">Request Vacation</a></li>
                    </ul>
                </li>


                <li>
                    <a href="#" class="eva-btn">Evaluation
                        <span class="fas fa-caret-down third"></span>
                    </a>
                    <ul class="eva-show">
                        <li><a href="#">View Score</a></li>
                        <li><a href="#">Create Reports</a></li>
                        <li><a href="#">Print Reports</a></li>
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
                                <li><a href="#">Cash Advance</a></li>
                                <li><a href="#">Deductions</a></li>
                                <li><a href="#">Payroll</a></li>
                            </ul>
                        </li>

                    </ul>
                </li>
            </ul>
        </nav>


           <% int projectID = 1;
            ProjectManager pm = new ProjectManager();
            Project project = pm.getProjectByID(projectID);%>


        <% 
                ArrayList<Project> allProjects = pm.getProjects();
                 Map<DepartmentID, ArrayList<Project>> projects = new HashMap();
                for (int j = 0; j < allProjects.size(); j++) {
                    if (projects.containsKey(allProjects.get(j).getDepartment())) {
                        ArrayList<Project> jobsTemp = projects.get(allProjects.get(j).getDepartment());
                        jobsTemp.add(allProjects.get(j));
                        projects.put(allProjects.get(j).getDepartment(), jobsTemp);
                    } else {
                        ArrayList<Project> jobsTemp = new ArrayList();
                        jobsTemp.add(allProjects.get(j));
                        projects.put(allProjects.get(j).getDepartment(), jobsTemp);
                    }
                }


        %> <h1 style="text-align: center; color:  darkslateblue;"> Posted Projects</h1>
        <h2 style="text-align: center; color: darkslateblue;">Total (<% out.print(allProjects.size());%>) Projects</h2>
        <br><br>
        <div id="myMenu" >
             <table style="background-color: white;margin-left: auto; margin-right: auto; width: 900px; font-size: 15px">
           
            <tr>
                <td>
                <div class="left"  >



                    <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search.." title="Type in a category">



                    <div id="allProjects">



                        <ul id="jobID" style="list-style-type:none">
                         <%   for (Map.Entry<DepartmentID, ArrayList<Project>> pair : projects.entrySet()) { %>
                                <div id=<%= pair.getKey().toString() %>  >
                                    <h1 style="color:white; background-color: #0065A2">
                                        <%   out.print(pair.getKey().toString());  %>
                                    </h1>  
                                    <%   for (int i = 0; i < pair.getValue().size(); i++) { %>
                                    <li style="background-color: #f7f7f7;"><a style="color: #0065A2" href=viewProject.jsp?projectID=<% out.print(pair.getValue().get(i).getID());%>> <% out.print(pair.getValue().get(i).getTitle()); %> </a></li>
                                 
                                        <% }
                                        %>  
                                    
                                </div>
                           </ul> <%
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
                    x = document.getElementById("allProjects")
                    x.style.display = "none";
                    y = document.getElementById("myJobs")
                    y.style.display = "block";



                } else {
                    x = document.getElementById("allProjects")
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



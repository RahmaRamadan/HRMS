<%-- 
    Document   : viewProject
    Created on : Jul 19, 2021, 9:29:56 PM
    Author     : maria
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="Algorithms.TimeTracking.TimeTrackingStatistics"%>
<%@page import="Entity.TimeTracking.Milestone_State"%>
<%@page import="Entity.TimeTracking.Project"%>
<%@page import="Algorithms.TimeTracking.ProjectManager"%>
<%@page import="Application.TimeTracking.Time_Tracking"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     int ID = Integer.parseInt(request.getParameter("projectID"));
            session.setAttribute("projectID", ID); 
    Time_Tracking tt = new Time_Tracking();
            ProjectManager pm = tt.getProjectManager();
            Project project = pm.getProjectByID(ID);
            
            TimeTrackingStatistics st = tt.getTimeTrackingStatistics();

  
    Gson gsonObj = new Gson();
   
    
    List<Map<Object, Object>> temp2 = st.getMilestonesScoreDistrubution(project);

    List<Map<Object, Object>> temp3 = st.getProjectStateRates(project);
    List<Map<Object, Object>> temp4 = st.getProjectsNeededSkillsCount(project);
   
    String dataPoints2 = gsonObj.toJson(temp2);
    String dataPoints3 = gsonObj.toJson(temp3);
    String dataPoints4 = gsonObj.toJson(temp4);
   

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="navigationBar2.css">
        <link rel="stylesheet" href="search.css">
        <link rel="stylesheet" href="styling.css">

        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
            <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <link rel="stylesheet" href="verticalNavBar.css">
        <title>View Project</title>
        <script>
           
            function myFunction(id) {
                document.getElementById(id).classList.toggle("show");
            }
            CanvasJS.addColorSet("greenShades",
                    [//colorSet Array

                        "#2F4F4F",
                        "#008080",
                        "#2E8B57",
                        "#3CB371",
                        "#90EE90"
                    ]);
            window.onload = function () {
                
               
                
                 var chart2 = new CanvasJS.Chart("chartContainer2", {
                    animationEnabled: true,
                    exportFileName: "Milestones Level Distribution",
                    exportEnabled: true,
                    theme: "light1",
                    colorSet: "greenShades",
                    title: {
                        text: "Milestones Level Distribution"
                        , titleFontFamily: "comic sans ms"
                    },
                    axisX: {
                        title: "Level"
                    },
                    axisY: {
                        title: "Count",
                        includeZero: true
                    },
                    data: [{
                            type: "column",
                            yValueFormatString: "#,##0.0# ",
                            dataPoints: <%out.print(dataPoints2);%>
                        }]
                });
                chart2.render();



                var chart3 = new CanvasJS.Chart("chartContainer3", {
                    animationEnabled: true,
                    exportFileName: "Milestone States ",
                    exportEnabled: true,
                    theme: "light1",
                    colorSet: "greenShades",
                    title: {
                        text: "Milestone States Distribution"
                        , titleFontFamily: "comic sans ms"
                    },
                    axisX: {
                        title: "State"
                    },
                    axisY: {
                        title: "Count",
                        includeZero: true
                    },
                    data: [{
                            type: "column",
                            yValueFormatString: "#,##0.0# ",
                            dataPoints: <%out.print(dataPoints3);%>
                        }]
                });
                chart3.render();

var chart4 = new CanvasJS.Chart("chartContainer4", {
                    animationEnabled: true,
                    exportFileName: "Milestone States ",
                    exportEnabled: true,
                    theme: "light1",
                    colorSet: "greenShades",
                    title: {
                        text: "Project Needed Skills "
                        , titleFontFamily: "comic sans ms"
                    },
                    axisX: {
                        title: "skill"
                    },
                    axisY: {
                        title: "Needed in # of milestones",
                        includeZero: true
                    },
                    data: [{
                            type: "column",
                            yValueFormatString: "#,##0.0# ",
                            dataPoints: <%out.print(dataPoints4);%>
                        }]
                });
                chart4.render();


            }
            function addSymbols(e) {
                var suffixes = ["", "K", "M", "B"];

                var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
                if (order > suffixes.length - 1)
                    order = suffixes.length - 1;

                var suffix = suffixes[order];
                return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
            }
           
        </script>
    </head>
    <body style="background-image: none;">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    

        <div class="navBar">
 <a href="index.html">LOGOUT</a>
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <a   href="viewProjects.jsp">PROJECTS</a>
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



   
        <table  style= " margin-left: 300px; margin-right: auto; width: 1200px; font-size: 20px; ">
            <tr>
                <td>
                    <h1><%= project.getTitle()%></h1> 
                </td>
            </tr>
            <tr>
                <td>
                    <div class="bar" style="text-align: center" >
                        <div class="dropdown">
                            <button class="dropbutton" onclick="myFunction('choices')"><i class="fa fa-edit"></i>

                            </button>
                            <div class="dropdown-content" id="choices">
                                <a href="deleteProject" >Delete </a>
                                <a href="updateProject.jsp" >Update </a>
                                   

                            </div>
                        </div> 
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <h3 style="color: #0065A2;"><%= project.getDepartment().toString()%></h3> 
                </td>
            </tr>
            <tr>
                <td>
                    <p><%= project.getDescription()%></p> 
                </td>
            </tr>
            <tr>
                <td>
                    <br>
                </td>


            </tr>
            <tr>
                <td>
                    <h3>Milestones</h3>
                </td>
            </tr>

            <tr style="background-color: #eee; color: #0065A2;">
                <td style="padding:0px;" >
                    Title
                </td>
                <td>
                    State
                </td>
                <td>
                    Start Date
                </td>
                <td>
                    End Date
                </td>
                <td style="padding:20px;">
                    Level
                </td>
                <td >
                    Assigned Employee ID
                </td>
                <td>
                    Required Skills
                </td>
            </tr>
            <tr >
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
                <td>
                    <hr>
                </td>
            </tr>
            <% for (int i = 0; i < project.getMilestones().size(); i++) {%>
            <tr>
                <td>
                    <%= project.getMilestones().get(i).getName()%>
                </td>
                <td>
                    <%= project.getMilestones().get(i).getState().toString().replace("_", " ")%>
                </td>
                <td>
                    <%= project.getMilestones().get(i).getStartDate()%>
                </td>
                <td>
                    <%= project.getMilestones().get(i).getEndDate()%>
                </td>
                <td>
                    <%= project.getMilestones().get(i).getScore()%>
                </td>              
                <td>
                    <%= project.getMilestones().get(i).getEmployeeID()%>
                </td>
                <% String skills="";
                    for(int k=0 ; k <project.getMilestones().get(i).getSkills().size(); k++) { 
                        skills+=project.getMilestones().get(i).getSkills().get(k)+". ";
                    
                }%>
                <td>
                    <%= skills%>
                </td>


            </tr>
            
            <% }%>
            <tr>
                <td>
                    <br>
                </td>
            </tr>
        </table>
        <i class="fa fa-line-chart"></i>
        <h2 style="text-align: center">
            <button  style="font-size: 20px; color: white; background-color: #1f6d8f;border-radius: 8px;padding: 5px;border: none;" type="submit" onclick="showDashboard()">Dashboard</button>
            <button style="font-size: 20px; color: white; background-color: #1f6d8f;border-radius: 8px;padding: 5px;border: none;"  onclick="showConfirm()">Confirm Milestones</button>

        </h2>
        <br> <br>
         <div id="dashboard" > 

            <br>


            <div id="chartContainer2" style="height: 300px; width: 50%; margin-left: 400px"></div>
            <br>
            <div id="chartContainer3" style="height: 300px; width: 50%; margin-left: 400px"></div>
          <br>
            <div id="chartContainer4" style="height: 300px; width: 50%; margin-left: 400px"></div>
            <br>
     
            <br>






        </div>
        <div id="showConfirm" hidden>
           
            
                <table style= " margin-left: auto; margin-right: auto; width: 600px; font-size: 20px; ">
                    <tr>
                        <th>
                            Employee ID
                        </th>
                        <th>
                            Milestone Title
                        </th>
                        <th>
                            State
                        </th>
                    </tr>
                     <% for (int i = 0; i < project.getMilestones().size(); i++) {   %>
                    <% if(project.getMilestones().get(i).getState().equals(Milestone_State.Completed_Not_Confirmed)){  %>
                    <tr>
                        <td>
                            <%= project.getMilestones().get(i).getEmployeeID() %> 
                        </td>
                        <td>
                             <%= project.getMilestones().get(i).getName()%> 
                        </td>
                        <td>
                            <a  style="color: #0065A2" href=confirmMilestone?milestoneID=<%= project.getMilestones().get(i).getID() %>> CONFIRM</a>
                        </td>
                    </tr>
                    <% }} %>
                    
                </table>

                    <br>
                    <br>
                    <br>


        
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
            $('nav ul li').click(function () {
                $(this).addClass("active").siblings().removeClass("active");
            });
            function showDashboard() {

                var x = document.getElementById("showConfirm");
                var y = document.getElementById("dashboard");

                y.style.display = "block";
                x.style.display = "none";


            }
            function showConfirm() {

                var x = document.getElementById("showConfirm");
                var y = document.getElementById("dashboard");

                x.style.display = "block";
                y.style.display = "none";

            }

        </script>

    </body>
</html>

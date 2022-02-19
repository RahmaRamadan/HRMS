<%-- 
    Document   : showJob
    Created on : Feb 3, 2021, 3:29:52 PM
    Author     : maria
--%>


<%@page import="Entity.Recruitment.Applicant_Type"%>
<%@page import="Entity.Recruitment.Job"%>
<%@page import="Application.Recruitment.RecruitmentDashboard"%>
<%@page import="DataAccess.Recruitment.MySQL_Job_DataAccess"%>
<%@page import="DataAccess.Recruitment.Employee_Job_DataAccess_Interface"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    int ID = Integer.parseInt(request.getParameter("jobID"));
    session.setAttribute("jobID", ID);

    Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
    Job job = jobDataAccess.getJobByID(ID);
    Gson gsonObj = new Gson();
    RecruitmentDashboard rd = new RecruitmentDashboard(job.getScore(),job.getApplicants());
    List<Map<Object, Object>> temp1 = rd.genderDistribution();
    List<Map<Object, Object>> temp2 = rd.genderScore();

    List<Map<Object, Object>> temp3 = rd.skillsDistribution();
    List<Map<Object, Object>> temp4 = rd.getRatioAboveAndBelowRequiredScore();
    String dataPoints = gsonObj.toJson(temp1);
    String dataPoints2 = gsonObj.toJson(temp2);
    String dataPoints3 = gsonObj.toJson(temp3);
    String dataPoints4 = gsonObj.toJson(temp4);


%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="navigationBar2.css">
        <link rel="stylesheet" href="search.css">
        <link rel="stylesheet" href="style.css">

        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script type="text/javascript" src="canvasjs.min.js"></script>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


        <link rel="stylesheet" href="verticalNavBar.css">
        <link rel="stylesheet" href="styling.css">
        <title>Job</title>
        <script>
            /* When the user clicks on the button, 
             toggle between hiding and showing the dropdown content */
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

                var chart1 = new CanvasJS.Chart("chartContainer1", {
                    //  theme: "light2",
                    animationEnabled: true,
                    exportFileName: "Gender Distribution of Applicants",
                    exportEnabled: true,
                    colorSet: "greenShades",
                    title: {
                        text: "Gender Distribution of Applicants",
                        titleFontFamily: "comic sans ms"
                    },
                    data: [{
                            type: "pie",
                            showInLegend: true,
                            legendText: "{label}",
                            toolTipContent: "{label}: <strong>{y}%</strong>",
                            indexLabel: "{label} {y}%",
                            dataPoints: <%out.print(dataPoints);%>
                        }]
                });

                chart1.render();


                var chart2 = new CanvasJS.Chart("chartContainer2", {
                    animationEnabled: true,
                    exportFileName: "Gender Distribution of Applicants",
                    exportEnabled: true,
                    theme: "light1",
                    colorSet: "greenShades",
                    title: {
                        text: "Average of Score per Gender"
                        , titleFontFamily: "comic sans ms"
                    },
                    axisX: {
                        title: "Gender"
                    },
                    axisY: {
                        title: "Average of Score",
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
                    exportFileName: "Skills Count",
                    exportEnabled: true,
                    theme: "light1",
                    colorSet: "greenShades",
                    title: {
                        text: "Applicants' Skills "
                        , titleFontFamily: "comic sans ms"
                    },
                    axisX: {
                        title: "Gender"
                    },
                    axisY: {
                        title: "Frequency",
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
                    //  theme: "light2",
                    animationEnabled: true,
                    exportFileName: "Ratio of Applicants have Skills Above/Below Job requirements",
                    exportEnabled: true,
                    colorSet: "greenShades",
                    title: {
                        text: "Ratio of Applicants have Skills Above/Below Job requirements",
                        titleFontFamily: "comic sans ms"
                    },
                    data: [{
                            type: "pie",
                            showInLegend: true,
                            legendText: "{label}",
                            toolTipContent: "{label}: <strong>{y}%</strong>",
                            indexLabel: "{label} {y}%",
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

        
        <div class="navBar">
            <a href="index.html">LOGOUT</a> 
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>
        
         <%
            
               
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
        </nav>


        <table style="text-align: center; width: 1000px ; padding-left: 500px">
            <tr>
                <td > <h1 style="text-align: center; "> <% out.print(job.getTitle());%></h1></td>

            </tr>
            <tr>

                <td> <div class="bar" style="text-align: center">
                        <div class="dropdown">
                            <button class="dropbutton" onclick="myFunction('choices')"><i class="fa fa-edit"></i>

                            </button>
                            <div class="dropdown-content" id="choices">
                                <a href="deleteJob?jobIDDelete="<%out.print(job.getID()); %> >Delete </a>
                              <a href="updateJob.jsp?jobID="<%out.print(job.getID()); %> >Update </a>

                            </div>
                        </div> 
                    </div>
                </td>
            </tr>
        </table>


        <h2 style="text-align: center"> <% out.print("Posted on: " + job.getTime());%> </h2>
        <p style="text-align: center"> <% out.print(job.getDescription());%> </p>
         <p style="text-align: center"> Required Skills:</p>
        <%  for (int i=0 ; i<job.getRequiredSkills().length; i++) {
        %> <p style="text-align: center" > <%= job.getRequiredSkills()[i] %> </p> <%
        }%>
        <i class="fa fa-line-chart"></i>
        <h2 style="text-align: center">
            <button  style="font-size: 20px; color: white; background-color: #1f6d8f;border-radius: 8px;padding: 5px;border: none;" type="submit" onclick="showDashboard()">Dashboard</button>
            <button style="font-size: 20px; color: white; background-color: #1f6d8f;border-radius: 8px;padding: 5px;border: none;"  onclick="showApplicants()">Show Applicants</button>
            <button style="font-size: 20px; color: white; background-color: #1f6d8f;border-radius: 8px;padding: 5px;border: none;" type="submit" onclick="showTrackApplicants()">Track Applicants</button> 
        </h2>

        <div id="dashboard"> 

            <br>
            <div id="chartContainer1" style="height: 300px; width: 50%; margin-left: 400px"></div>
            <br>

            <div id="chartContainer2" style="height: 300px; width: 50%; margin-left: 400px"></div>
            <br>
            <div id="chartContainer3" style="height: 300px; width: 50%; margin-left: 400px"></div>
          <br>
            <div id="chartContainer4" style="height: 300px; width: 50%; margin-left: 400px"></div>
            <br>
            <br>






        </div>
        <div id="showApplicants" hidden >
            <br>
            <br>
            <h2 style="text-align: center">Applied Applicants</h2>
            <table  border=2 style= " margin-left: auto; margin-right: auto; width:1000px; text-align: center; border-color: #1f6d8f; border-collapse: collapse; ">


                <p style="text-align: center"> <br><% if (job.getApplicants() != null) { %>
                <tr>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>SKILLS</th> 
                    <th> EDUCATION</th>
                    <th>EXPERIENCE</th>
                    <th>TOTAL YEARS OF EXPERIENCE</th>
                    <th>REJECT</th>
                    <th>TRACK</th>
                </tr> <%
                    for (int i = 0; i < job.getApplicants().size(); i++) {
                        int totalYearsExperience = 0;
                        for (int k=0 ; k<job.getApplicants().get(i).getExperience().size();k++)
                        {
                            totalYearsExperience+=job.getApplicants().get(i).getExperience().get(k).getYears();
                        }
                        if (job.getApplicants().get(i).getState().equals(Applicant_Type.applied)) {
                            
                %>
                <tr>

                    <td><%= job.getApplicants().get(i).getName()%></td>
                    <td><%= job.getApplicants().get(i).getEmail()%></td>
                    <td>  <% for (int j = 0; j < job.getApplicants().get(i).getSkills().length; j++) {
                            out.print(job.getApplicants().get(i).getSkills()[j] + ".  ");
                           
                        }%>
                    </td>
                    <td><% out.print(job.getApplicants().get(i).getEducation().getDegree()+" in "+job.getApplicants().get(i).getEducation().getField()); %></td>
                    <td>  <% for (int j = 0; j < job.getApplicants().get(i).getExperience().size(); j++) {
                            out.print(job.getApplicants().get(i).getExperience().get(j).getTitle() +" for: "+job.getApplicants().get(i).getExperience().get(j).getYears() + " years.  ");
                    %> <br> <%
                        }%>
                    </td>
                    <td><%=totalYearsExperience %></td>
                    
                    <td> <a href=deleteApplicant?applicantID=<%=job.getApplicants().get(i).getID()%>&jobID=<%= job.getID() %>><i class="fa fa-user-times" style="color:red"></i> </a></td>
                    <td> <a href=sendInitialAcceptance?applicantID=<%=job.getApplicants().get(i).getID()%>&jobID=<%= job.getID() %> ><i class="fa fa-check"></i> </a></td>



                </tr><%
                        }
                    }
                %> <tr>
                    <td>-</td>
                    <td>-</td>
                      <td>-</td>
                    <td>-</td>
                    <td>-</td>
                         <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>   <%
                        // view gender stat
                        // view skills stat 
                        // view education stat
                        // average fitness if less than 0.5 tell to update skills
                    } else {
                        out.print("There are no applicants yet.");
                    }%> </p>



            </table>

        </div>
        <div id="trackApplicants" hidden>
            <br>
            <br>
            <h2 style="text-align: center"> Initially Selected Applicants</h2>
            <table  border=2 style= " margin-left: auto; margin-right: auto; width:1000px; text-align: center; border-color: #1f6d8f; border-collapse: collapse;">


                <p style="text-align: center"> <br><% if (job.getApplicants() != null) { %>
                <tr>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>SKILLS</th>
             <th> EDUCATION</th>
                    <th>EXPERIENCE</th>
                    <th>TOTAL YEARS OF EXPERIENCE</th>
                    <th>REJECT</th>
                    </tr> <%
                        for (int i = 0; i < job.getApplicants().size(); i++) {
                            if (job.getApplicants().get(i).getState().equals(Applicant_Type.initiallyAccepted)) {
                     
                    
                        int totalYearsExperience = 0;
                        for (int k=0 ; k<job.getApplicants().get(i).getExperience().size();k++)
                        {
                            totalYearsExperience+=job.getApplicants().get(i).getExperience().get(k).getYears();
                        }
                     
                %>
                <tr>

                    <td><%= job.getApplicants().get(i).getName()%></td>
                    <td><%= job.getApplicants().get(i).getEmail()%></td>
                    <td>  <% for (int j = 0; j < job.getApplicants().get(i).getSkills().length; j++) {
                            out.print(job.getApplicants().get(i).getSkills()[j] + ".  ");
                        }%>
                    </td>
                     <td><% out.print(job.getApplicants().get(i).getEducation().getDegree()+" in "+job.getApplicants().get(i).getEducation().getField()); %></td>
                    <td>  <% for (int j = 0; j < job.getApplicants().get(i).getExperience().size(); j++) {
                            out.print(job.getApplicants().get(i).getExperience().get(j).getTitle() +" for: "+job.getApplicants().get(i).getExperience().get(j).getYears() + " years.  ");
                    %> <br> <%
                        }%>
                    </td>
                    <td><%=totalYearsExperience %></td>
                    <td> <a href=deleteApplicant.java?applicantID=<%job.getApplicants().get(i).getID();%>><i class="fa fa-user-times " style="color:red"></i> </a></td>
                 


                </tr><%
                        }
                    }
                %> <tr>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                 
                </tr>   <%
                        // view gender stat
                        // view skills stat 
                        // view education stat
                        // average fitness if less than 0.5 tell to update skills
                    } else {
                        out.print("There are no initially accepted applicants yet.");
                    }%> </p>



            </table>

        </div>
                    <br>
                    <br>
                    <br>


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
            function showApplicants() {

                var x = document.getElementById("showApplicants");
                var y = document.getElementById("dashboard");
                var z = document.getElementById("trackApplicants");
                x.style.display = "block";
                y.style.display = "none";
                z.style.display = "none";

            }
            function showDashboard() {

                var x = document.getElementById("showApplicants");
                var y = document.getElementById("dashboard");
                var z = document.getElementById("trackApplicants");
                y.style.display = "block";
                x.style.display = "none";
                z.style.display = "none";

            }
            function showTrackApplicants() {

                var x = document.getElementById("showApplicants");
                var y = document.getElementById("dashboard");
                var z = document.getElementById("trackApplicants");
                z.style.display = "block";
                y.style.display = "none";
                x.style.display = "none";

            }



        </script>
    </body>
</html>

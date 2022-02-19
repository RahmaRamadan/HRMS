<%-- 
    Document   : viewEmployeeMilestones
    Created on : Jul 20, 2021, 6:18:23 AM
    Author     : maria
--%>


<%@page import="Entity.TimeTracking.Milestone_State"%>
<%@page import="Entity.TimeTracking.Milestone"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Application.TimeTracking.MyProjectsManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My projects</title>

        <link rel="stylesheet" href="navigationBar2.css">
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>



        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" href="verticalNavBar.css">
      

    </head>
    <body style="background-image: none;">

        
                <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="index.html"><i class="fa fa-home"></i>HOME</a> 


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
   </head>
    <body>
        <%
            String myID = session.getAttribute("idd").toString();
            MyProjectsManager pm = new MyProjectsManager();
            ArrayList<Milestone> milestones = pm.getMyMilestones(myID);
        %>
        <form action="updateProjectState" >
            <table style="font-size: 24px; margin: auto; padding: 20px;">
                <tr>

                    <td>
                        Title
                    </td>

                    <td>
                        Start Date
                    </td>
                    <td>
                        End Date
                    </td>
                    <td>
                        Level
                    </td>
                    <td>
                        State
                    </td>
                </tr>
                <% for (int i = 0; i < milestones.size(); i++) {
                if(!milestones.get(i).getState().equals(Milestone_State.Completed_Confirmed )){
                %>
                
                <tr>

                    <td>
                        <%= milestones.get(i).getName()%>
                    </td>

                    <td>
                        <%= milestones.get(i).getStartDate()%>
                    </td>
                    <td>
                        <%= milestones.get(i).getEndDate()%>
                    </td>
                    <td>
                        <%= milestones.get(i).getScore()%>
                    </td>              


                    <td>
                        <select name="state"  style="font-size:20px; color: #1f6d8f; "  class="form-control m-input">
                            <option value="<%= milestones.get(i).getID()%>,In_Progress"> In Progress </option>
                            <option value="<%= milestones.get(i).getID()%>,Completed_Not_Confirmed"> Completed </option>
                            <option value="<%= milestones.get(i).getID()%>,Not_Started"> Not Started </option>
          
                        </select>
                    </td>
                    <td>
                        <button style="font-size:20px; color: #1f6d8f; "  class="form-control m-input" type="submit" >Update Changes</button>
                    </td>

                </tr>
                <% }}%>
            </table>
        </form>
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
           
        </script>


    </body>
</html>



       
    </body>
</html>

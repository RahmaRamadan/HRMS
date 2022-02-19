<%-- 
    Document   : updateProject
    Created on : Jul 19, 2021, 9:02:09 PM
    Author     : maria
--%>

<%@page import="Entity.TimeTracking.Project"%>
<%@page import="Algorithms.TimeTracking.ProjectManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>update Project</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">



        <link rel="stylesheet" href ="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-
              awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com./bootstrap/4.1.3/js/bootstrap.min.js"></script>



        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <link rel="stylesheet" href="verticalNavBar.css">
        <link rel="stylesheet" href="navigationBar2.css">

    </head>
    <body>
        <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="index.html"><i class="fa fa-home"></i>HOME</a> 

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

        <% int projectID = Integer.parseInt(request.getParameter("projectID"));
            ProjectManager pm = new ProjectManager();
            Project project = pm.getProjectByID(projectID);%>

        <h1 style="text-align: center">Update Project Data</h1>
        <hr>
        <form action="updateJob" >
            <table style="margin-left: 400px; width: 900px " >

                <tr>

                    <td>
                        <table>

                            <tr>

                                <td>Title<input class="form-control m-input" type="text" name="title" value=" <%= project.getTitle()%> " required/></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>
                            <tr> 


                                <td>Department<select name="category" required class="form-control m-input">
                                        <option value="Sales"> Sales </option>
                                        <option value="Maketing"> Maketing </option>
                                        <option value="Management"> Management </option>
                                        <option value="IT"> IT </option>
                                        <option value="HR"> HR </option>
                                    </select></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>




                            <tr>
                                <td>Description<textarea name="description" rows="4" cols="40" class="form-control m-input" value=" <%= project.getDescription()%> "></textarea></td>

                            </tr>

                        </table>

                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3>
                            Milestones
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                </tr>
                <tr><td>

                        <table style=" width:1000px; ">
                            <tr>
                                <th>
                                    Title
                                </th>
                                <th>
                                    Start Date
                                </th>
                                <th>
                                    End Date
                                </th>
                                <th>
                                    Skills
                                </th>
                                <th>
                                    Level
                                </th>
                            </tr>
                            <% for (int i = 0; i < project.getMilestones().size(); i++) {%>
                            <tr>
                                <td>
                                    <input  type="text" name="milestoneTitle" class="form-control m-input" placeholder="Title" autocomplete="off" value=" <%= project.getMilestones().get(i).getName()%>"  required>

                                </td>
                                <td>
                                    <input  type="date" name="startDate" class="form-control m-input"  required value=" <%= project.getMilestones().get(i).getStartDate().toString()%>"  >

                                </td>
                                <td>
                                    <input  type="date" name="endDate" class="form-control m-input"  value=" <%= project.getMilestones().get(i).getEndDate().toString()%>"   required>

                                </td>
                                <% String s = "";
                                    for (int j = 0; j < project.getMilestones().get(i).getSkills().size(); j++) {
                                        s += project.getMilestones().get(i).getSkills().get(j);
                                    }%>
                                <td>
                                    <input  type="text" name="skills" class="form-control m-input" placeholder="Enter skills delimeted by |" autocomplete="off" value=" <%= s%>"  required>

                                </td>

                                <td><select name="score" required class="form-control m-input" >
                                        <option value="Very_Easy"> Very Easy </option>
                                        <option value="Easy"> Easy </option>
                                        <option value="Medium"> Medium </option>
                                        <option value="Hard"> Hard </option>
                                        <option value="Very_Hard"> Very Hard </option>
                                        <option selected="selected">
                                            <%= project.getMilestones().get(i).getScore().toString().replace("_", " ") %>
                                        </option>

                                    </select></td>
                             



                            </tr>

                            <% }%>
                        </table> 




                    </td></tr>


            </table>
            <br>
            <br>


        </form>
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





        </script>
    </body>
</html>


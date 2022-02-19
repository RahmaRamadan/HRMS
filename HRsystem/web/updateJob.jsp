<%-- 
    Document   : updateJob
    Created on : Apr 16, 2021, 11:06:14 PM
    Author     : maria
--%>

<%@page import="Entity.Recruitment.Job"%>
<%@page import="Application.Recruitment.Recruitment"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="DataAccess.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Job</title>
       
        <link rel="stylesheet" href="navigationBar2.css">
        <link rel="stylesheet" href="search.css">
       

        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script type="text/javascript" src="canvasjs.min.js"></script>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


        <link rel="stylesheet" href="verticalNavBar.css">
        <link rel="stylesheet" href="styling.css">
    </head>
    <body style="background-image: none;">

        
        <div class="navBar">
            <a href="index.html">LOGOUT</a> 
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="homePage.jsp"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>

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
        <%
            
             int ID = Integer.parseInt(session.getAttribute("jobID").toString());
             
              Recruitment jobHandling = new Recruitment();
              Job job = jobHandling.getJobByID(ID);
        %>

             <h1 style="text-align: center">Update (<%= job.getTitle() %>) </h1>
        <br>
        <form action="updateJob" >
            <table style="margin-left: 400px; width: 900px " >
                
                <tr>
                    <td>  <h3>Basic Info</h3></td>
                    <td>
                        <table>

                            <tr>
                                <td>Title</td>
                                
                                <td><input type="text" name="title" value=<%= job.getTitle() %> required/></td>

                            </tr>
                            <tr> <td>
                                    Job Category
                                </td>
                                <td> <select name="category"  required style="width: 210px;">
                                        <option value="Sales"> Sales </option>
                                        <option value="Maketing"> Maketing </option>
                                        <option value="Management"> Management </option>
                                        <option value="IT"> IT </option>
                                        <option value="HR"> HR </option>
                                         <option selected="selected">
                                            <%= job.getCategory() %>
                                        </option>
                                    </select></td>

                            </tr>

                            <tr> <td>
                                    Job Type
                                </td>
                                <td> <select name="type" required style="width: 210px;">
                                        <option value="Internship"> Internship </option>
                                        <option value="Part_Time"> Part_Time </option>
                                        <option value="Full_Time"> Full_Time </option>
                                        <option value="FreeLancing"> FreeLancing </option>
                                        <option value="Contract"> Contract </option>
                                         <option selected="selected">
                                            <%= job.getType() %>
                                        </option>
                                    </select></td>

                            </tr>

                            <tr><td>Description</td>
                                <td><textarea name="description" rows="4" cols="40"  ><%= job.getDescription() %></textarea></td>

                            </tr>

                        </table>

                    </td>
                </tr>


                <tr><td><br></td></tr>     
     <tr><td><hr></td><td><hr></td></tr> 
    <tr><td><br></td></tr> 
                <tr>
                    <td><h3> Required  Education    </h3></td>


                    <td>
                        <table>
                            <tr>
                                <td>
                                    Required Degree <select name="degree" required  value= <%= job.getRequiredEducation().getDegree().toString() %>>
                                        <option value="Not_Specified"> Not_Specified </option>
                                        <option value="Undergraduate"> Undergraduate </option>
                                        <option value="Bachelor"> Bachelor </option>
                                        <option value="Master"> Master </option>
                                        <option value="PhD"> PhD </option>
                                    </select>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                     Experience Years <select name="years" required value= <%= job.getYears() %> >
                            <option value="0"> 0 </option>
                            <option value="1"> 1 </option>
                            <option value="2"> 2 </option>

                            <option value="3"> 3 </option>
                            <option value="4"> 4 </option>

                            <option value="5"> 5 </option>
                            <option value="6"> 6 </option>

                            <option value="7"> 7 </option>
                            <option value="8"> 8 </option>
                            <option value="9"> 9 </option>
                            <option value="10"> 10 </option>
                            <option value="11"> over ten years </option>
                            

                        </select>
                                </td>
                            </tr>
                            <tr>
                                <td>GPA
                                    <input type="text" name="GPA" value=<%= job.getRequiredEducation().getGPA() %>  required/>
                                </td>
                            </tr>
                        </table>


                   
           
        </td>

    </tr>
    <tr><td><hr></td><td><hr></td></tr> 
    <tr><td><br></td></tr>    
    <tr><td><h3>Required Skills</h3></td><td>

            <table>
                <%
                    for(int i=0 ; i<job.getRequiredSkills().length ; i++){
                    %>
                
                <tr><td>

                        <div id="inputFormSkill">
                            <table>
                                <tr>
                                    <td>
                                         <input value=<%= job.getRequiredSkills()[i] %> type="text" name="skills" class="form-control m-input" placeholder="Enter Skill" autocomplete="off" required>

    
                                    </td>
                                </tr>
                            </table> 
                            <div class="input-group mb-3">


                            </div>
                        </div>


                    </td></tr>
                <% } %>
                
                
                
                <tr><td>
                        <div id="newSkill"></div>
                        <br>

                        <input  style="background-color: white; color:blue; right: 500px; border: none " id="addSkill" value="Add Extra Skill" type="button">

                    </td></tr>



            </table>

        </td></tr>
    
    <tr><td><hr></td><td><hr></td></tr> 
    <tr><td><br></td></tr>
    <tr><td></td><td><button style="font-size: 30px; color: blue;" type="submit" onclick="">Update</button></td></tr>

</table>


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
    $("#addSkill").click(function () {
        var html = '';
        html += '<div id="inputFormSkill">';

        html += '<div class="input-group mb-3">';
        html += '<br>';
        html += '<table><tr><td> <input type="text" name="skills" class="form-control m-input" placeholder="Enter a Skill" autocomplete="off">';
        html += '<div class="input-group-append">';

        html += '<input class="form-control m-input" style="background-color: red; color:white" id="removeSkill" value="X" type="button"> </td></tr></table>';
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

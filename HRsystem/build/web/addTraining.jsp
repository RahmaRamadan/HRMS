<%-- 
    Document   : addTraining
    Created on : Jul 15, 2021, 9:02:35 PM
    Author     : Zak
--%>

<%@page import="Algorithms.Evaluation.Trainings_Management"%>
<%@page import="Entity.Training"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Training</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  >
  
        <style>
            
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
            
            .btn-primary{
                    display: block;
                    right: 140px;
                    width: 300px;
                    max-width: 100%;
                    margin: 0 auto;
                    margin-bottom: 0;
                    overflow: hidden;
                    position: relative;
                    transform: translatez(0);
                    text-decoration: none;
                    box-sizing: border-box;
                    font-size: 24px;
                    font-weight: normal;
                    box-shadow: 0 9px 18px rgba(0,0,0,0.2);
                    text-align: center;
                    border-radius: 40px;
                    padding: 7px;
                    color: white;
                    transition: all 0.2s ease-out 0s;
                }
                #hh
                {
                    color: blue;
                    text-align: center;
                    font-size: 30px;
                }
                #err{
                    color: red;
                    text-align: center;
                    font-size: 30px;
                }
                #sk{
                    width: 328px;
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
              Training t = new Training(Integer.parseInt(request.getParameter("id")),request.getParameter("title"), 
                      request.getParameter("startDate"), request.getParameter("endDate"), request.getParameter("description"),
                      Integer.parseInt(request.getParameter("score")));
             
              ArrayList<String> trainingSkills = new ArrayList<>();
              String[] skills = request.getParameterValues("skills");
              for(int i = 0 ; i < skills.length ; i++)
              {
                  trainingSkills.add(i, skills[i]);
              }
              t.setSkills(trainingSkills);
              
              boolean add_Training  ;
              Trainings_Management training = new Trainings_Management();
               add_Training =   training.addTraining(t);
               color = "green";
                if (add_Training) {
                    %>        
                    <h4 id="hh">Training Added Successfully</h4>
                     <%
                } else {
                    color = "red";
%>
                <h4 id="err">Error Occured</h4>
                    <%
                   // message = "Error Occured";
                }
             
                 } catch (Exception ex) {
                    out.println("ex: " + ex);
                  
                }

            }
            
        %>
        
        <h1 style="text-align: center">Enter Training Data</h1>
        <hr>
        <form  method="post" action="addTraining.jsp" >
            <table style="margin-left: 500px; width: 900px " >
                
                <tr>
                    <td>  <h3>Training Info</h3></td>
                    <td>
                        <table>

                            <tr>
                                
                                <td><h6>ID</h6><input class="form-control m-input" type="text" name="id" value="" required/></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>
                            
                            <tr>
                                
                                <td><h6>Title</h6><input class="form-control m-input" type="text" name="title" value="" required/></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>
                            
                            
                            <tr>
                                
                                <td><h6>Start Date</h6><input class="form-control m-input" type="text" name="startDate" value="" required/></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>
                            
                            
                            <tr>
                                
                                <td><h6>End Date</h6><input class="form-control m-input" type="text" name="endDate" value="" required/></td>

                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>
                            
                     
                            <tr>
                                <td><h6>Description</h6><textarea name="description" rows="4" cols="40" class="form-control m-input"></textarea></td>

                            </tr>
                            
                             <tr>
                                <td>
                                    <br>
                                </td>
                            </tr>

                            <tr>
                                <td><h6>Score</h6><input class="form-control m-input" type="text" name="score" value="" required/></td>

                            </tr>
                        </table>

                    </td>
                </tr>
                
            <tr><td><hr></td><td><hr></td></tr> 
            <tr><td><br></td></tr>    
            <tr><td><h3>Required Skills</h3></td><td>
              
                   
                    <table>

                       <tr><td>

                                <div id="inputFormSkill">
                                    <table>
                                        
                                        <tr>
                                            <td>
                                                <div id="sk">
                                                <h6>Skill</h6> <input type="text" name="skills" class="form-control m-input" placeholder="Enter a Skill" autocomplete="off" required>
                                            </div>
                                                </td>
                                        </tr>
                                        
                                    </table> 
                                    <div class="input-group mb-3"> </div>
                                </div>

                            </td></tr>
                        <tr><td>
                                <div id="newSkill"></div>
                             
                                <input  style="background-color: white; color:blue; right: 500px; border: none ; font-size: 20px " id="addSkill" value="Add Extra Skill" type="button">

                            </td></tr>
                     
                    </table>

                </td></tr>

            <tr><td><hr></td><td><hr></td></tr> 
            <tr><td><br></td></tr>
            <tr><td></td><td>
            <button  class = "btn-primary" type="submit" onclick="">Add Training</button></td></tr>

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
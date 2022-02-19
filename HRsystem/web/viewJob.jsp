<%-- 
    Document   : viewJob
    Created on : Jan 30, 2021, 2:43:21 AM
    Author     : maria
--%>

<%@page import="Entity.Recruitment.Job"%>
<%@page import="Application.Recruitment.Recruitment"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="navigationBar2.css">
          <link rel="stylesheet" href="search.css">
        <title>Job</title>

    </head>

    <body>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
          <%  int ID = Integer.parseInt(request.getParameter("myMenu"));
                    session.setAttribute("searchedJob", ID); %>
                    
        <div class="navBar">

            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="index.html"><i class="fa fa-home"></i>HOME</a> 
            <a   href="careers.jsp">CAREERS</a>
            <img class="logo" src = "logo.jpg" >

        </div>
    

        <%
            Recruitment jobHandler = new Recruitment();
            Job job = jobHandler.getJobByID(ID);
            
        %>
        <h1 style="text-align: center; padding: 20px"> <% out.print(job.getTitle());%> </h1>
        <h3 style="text-align: center"> <% out.print("Posted on: " + job.getTime());%> </h3>
        <p style="text-align: center"> <% out.print(job.getDescription());%> </p>
        <p style="text-align: center"> <% out.print("Required Degree: a "+job.getRequiredEducation().getDegree()+", in: "+job.getRequiredEducation().getField());%> </p>
        <p style="text-align: center"> <% out.print("Required Skills: ");for(int i=0 ; i<job.getRequiredSkills().length; i++){ %><br><%out.print(job.getRequiredSkills()[i]);}%> </p>
             <a style="text-align: right; position: sticky; text-align: center; " class="nav-link" href="apply.html"><h2>APPLY</h2></a>
    </body>
</html>

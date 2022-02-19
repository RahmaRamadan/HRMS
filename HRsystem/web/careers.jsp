<%-- 
    Document   : careers.jsp
    Created on : Jan 30, 2021, 12:33:39 AM
    Author     : maria
--%>

<%@page import="Entity.Recruitment.Job"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="Entity.Department"%>
<%@page import="Application.Recruitment.Recruitment"%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="navigationBar2.css">
    
        <link rel="stylesheet" href="search.css">

        <title>Careers</title>


    </head>

    <body style="background-image: none;">



        <div class="navBar">
           
            <a href="#">ABOUT US</a>
            <a href="#">SERVICES</a> 
            <a href="index.html"><i class="fa fa-home"></i>HOME</a> 
            <img class="logo" src = "logo.jpg" >

        </div>




        <% Recruitment jobHandling = new Recruitment();
            if (jobHandling.checkThereAreJobs()) {

                //   Sales,Maketing,Management,IT,HR
                ArrayList<Job> allJobs = jobHandling.getAllJobs();
                // creating a map of all jobs and their category
                Map< Department, ArrayList<Job>> jobs = new HashMap();
                for (int j = 0; j < allJobs.size(); j++) {
                    if (jobs.containsKey(allJobs.get(j).getCategory())) {
                        ArrayList<Job> jobsTemp = jobs.get(allJobs.get(j).getCategory());
                        jobsTemp.add(allJobs.get(j));
                        jobs.put(allJobs.get(j).getCategory(), jobsTemp);
                    } else {
                        ArrayList<Job> jobsTemp = new ArrayList();
                        jobsTemp.add(allJobs.get(j));
                        jobs.put(allJobs.get(j).getCategory(), jobsTemp);
                    }
                }


        %> <h1 style="text-align: center; color: darkslateblue; ">JOIN US</h1>
        <h2 style="text-align: center; color: darkslateblue"><% out.print(allJobs.size());%> Openings</h2>




        <table style="margin-left: auto; margin-right: auto; width: 900px; font-size: 15px">
           
            <tr>
                <td>
                    <div class="left" >


                        <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search.." title="Type in a category " >
                        <ul id="myMenu">
                            <%
                            for (Map.Entry<Department, ArrayList<Job>> pair : jobs.entrySet()) { %>
                                <div id=<%= pair.getKey().toString() %>  >
                                    <h1 style="color:white; background-color: #0065A2">
                                        <%   out.print(pair.getKey().toString());  %>
                                    </h1>  
                                    <%   for (int i = 0; i < pair.getValue().size(); i++) { %>
                                    <li ><a style="color: #0065A2; " href=viewJob.jsp?myMenu=<% out.print(pair.getValue().get(i).getID());%>> <% out.print(pair.getValue().get(i).getTitle());%> </a></li>
                                        <% }
                                        %>  
                                    
                                </div>
                                        
                                <%   }

                            } else { %> <p>There are no current jobs.</p>
                            <% }%>
                        </ul>

                    </div>



                </td>
            </tr>
        </table>


        <br>
        <script>
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

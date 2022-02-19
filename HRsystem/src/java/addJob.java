/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Algorithms.Recruitment.Semantic_Similarity;
import Algorithms.Recruitment.Semantic_Similarity_Interface;
import Application.Recruitment.Recruitment;

import Entity.Department;
import Entity.Recruitment.Degree;
import Entity.Recruitment.Education;
import Entity.Recruitment.Job;
import Entity.Recruitment.JobType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maria
 */
@WebServlet(urlPatterns = {"/addJob"})
public class addJob extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(1);
            HttpSession session = request.getSession();
              
            String username = (String) session.getAttribute("idd");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String requiredDegree = request.getParameter("degree");
            String field = request.getParameter("field");
            String type = request.getParameter("type");
            int years = Integer.parseInt(request.getParameter("years"));
            String[] skills = request.getParameterValues("skills");
            double GPA = Double.parseDouble(request.getParameter("GPA")); 
           //out.print(GPA);
           out.print(2);
            String category= request.getParameter("category");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Semantic_Similarity_Interface in = new Semantic_Similarity();
          // out.print(1);
          out.print(3);
            Job job = new Job(-1,title, description,new Education(Degree.valueOf(requiredDegree),field,GPA),years, now.toString(),username,JobType.valueOf(type), Department.valueOf(category));
            out.print(4);
            job.setRequiredSkills(skills);
             double score = in.getJobRequiredSimilarity(job);
           // out.print(score);
             job.setScore(score);
            out.print(5);
            Recruitment jh = new Recruitment();
            try{
            if(jh.insertJob(job))
            {
                out.println("<script>");
                out.println("alert('The job is added')");
                out.println("window.location.replace('recuHome.jsp');");
                out.println("</script>");
            }
            else{
             out.print("<script>");
                out.println("alert('Unfortunately, the job is not added')");
                out.println("window.location.replace('recuHome.jsp');");
                out.println("</script>");   
            }
        }
        catch (Exception e)
        {
            out.println("<script>");
              
                out.println("window.location.replace('recuHome.jsp');");
                out.println("</script>");
        }  
    }}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

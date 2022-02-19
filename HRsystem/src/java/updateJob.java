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
@WebServlet(urlPatterns = {"/updateJob"})
public class updateJob extends HttpServlet {

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
           HttpSession session = request.getSession();
           
             
          //  String username = (String) session.getAttribute("me");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String requiredDegree = request.getParameter("degree");
            String type = request.getParameter("type");
            int years = Integer.parseInt(request.getParameter("years"));
            String[] skills = request.getParameterValues("skills");
            double GPA = Double.parseDouble(request.getParameter("GPA")); 
            String category= request.getParameter("category");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            
            Semantic_Similarity_Interface in = new Semantic_Similarity();
            Recruitment jh = new Recruitment();
            
            Job job = new Job((int) session.getAttribute("jobID"),title, description,new Education(Degree.valueOf(requiredDegree),type,GPA),years, now.toString(),"101",JobType.valueOf(type), Department.valueOf(category));
            double score = in.getJobRequiredSimilarity(job);
           
            //out.print(1);
            job.setScore(score);
            
            job.setRequiredSkills(skills);
            
            
            if(jh.updateJob(job))
            {
                out.print("<script>");
                out.print("alert('The job is updated')");
                out.print("</script>");
            }
            else{
             out.print("<script>");
                out.print("alert('The job is not updated')");
                out.print("</script>");   
            }
        }
        }


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
            Logger.getLogger(updateJob.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updateJob.class.getName()).log(Level.SEVERE, null, ex);
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

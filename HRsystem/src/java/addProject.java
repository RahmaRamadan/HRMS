/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithms.TimeTracking.GeneticAlgorithm;
import Algorithms.TimeTracking.ProjectManager;
import Entity.DepartmentID;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import Entity.TimeTracking.Project;
import Entity.TimeTracking.Score;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/addProject"})
public class addProject extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

         //   String username = (String) session.getAttribute("idd");
            String title = request.getParameter("title");
            DepartmentID department = DepartmentID.valueOf(request.getParameter("department"));
            String description = request.getParameter("description");
            String[] milestoneTitles = request.getParameterValues("milestoneTitle");
            String[] startDates = request.getParameterValues("startDate");
            String[] endDates = request.getParameterValues("endDate");
            String[] skills = request.getParameterValues("skills");
            String[] scores = request.getParameterValues("score");
            ArrayList<Milestone> milestones = new ArrayList<>();
            ProjectManager pm = new ProjectManager();
            for (int i = 0; i < skills.length; i++) {
                String[] skills_ = skills[i].split("\\|");

                ArrayList<String> skillsList = new ArrayList<>();

                for (String s : skills_) {
                    skillsList.add(s.trim());

                }
                milestones.add(new Milestone(pm.generateMilestoneID() + i, milestoneTitles[i], Date.valueOf(startDates[i]), Date.valueOf(endDates[i]), Score.valueOf(scores[i]), Milestone_State.Not_Started, "-1", skillsList));
            }

            Project project = new Project(pm.generateProjectID(), title, description, department);
            System.out.println(pm.generateProjectID() + " " + title + " " + description + " " + department);
            project.setMilestones(milestones);

            try {
                out.print(1);
                if (!pm.addProject(project)) {
                    out.print("<script>");
                    out.println("alert('Unfortunately, The project itself is not added')");
                    //   out.println("window.location.replace('viewProjects.jsp');");
                    out.println("</script>");

                }

             //   out.print(2);
                GeneticAlgorithm ga = new GeneticAlgorithm();
             //   out.print(3);
                ga.runGeneticAlgorithm(milestones);
               // out.print(4);
                
                out.print("<script>");
                out.println("alert('The project is added')");
                out.println("window.location.replace('viewProjects.jsp');");
                out.println("</script>");

            } catch (Exception e) {
                out.print("<script>");
                out.println("alert('Unfortunately, The project is added but the Genetic Algorithm has failed')");
                out.println("window.location.replace('viewProjects.jsp');");
                out.println("</script>");

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
        } catch (Exception ex) {
            Logger.getLogger(addProject.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(addProject.class.getName()).log(Level.SEVERE, null, ex);
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

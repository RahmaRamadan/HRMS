/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithms.Evaluation.Score_Management;
import Algorithms.TimeTracking.ProjectManager;
import DataAccess.DatabaseConnection;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import Entity.TimeTracking.Score;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(urlPatterns = {"/confirmMilestone"})
public class confirmMilestone extends HttpServlet {

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
            int milestoneID = Integer.parseInt(request.getParameter("milestoneID"));
              ProjectManager pm = new ProjectManager();
              Milestone milestone = pm.getMilestoneByID(milestoneID);
              Score_Management sm = new Score_Management();
            if(  pm.setMilestoneCompleted(milestoneID) && sm.Update_Score(milestone.getEmployeeID(), milestone.getScore().ordinal()*10))
            {
                
                   out.print("<script>");
                out.println("alert('The milestone is confirmed')");
                out.println("window.location.replace('viewProjects.jsp');");
                out.println("</script>"); 
            }
            else{
                   out.print("<script>");
                out.println("alert('Unfortunately, the milestone is not confirmed')");
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
            Logger.getLogger(confirmMilestone.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(confirmMilestone.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Application.Recruitment.Recruitment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/sendInitialAcceptance"})
public class sendInitialAcceptance extends HttpServlet {

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
             int applicantID = Integer.parseInt(request.getParameter("applicantID"));
           int jobID = Integer.parseInt(request.getParameter("jobID"));
            out.print(2);
            Recruitment jobHandling = new Recruitment();
           out.print(3); 
            
            if(jobHandling.setApplicantInitiallyAccepted(applicantID)){
                
                 
            
              out.println("<html>");
                    out.println("<body>");
                    out.println("<script>");
                    out.println("alert('The Applicant is initially accepted.')");
                     out.println("window.location.replace('showJob.jsp?jobID="+jobID+"');");
                    out.println("</script>");
                    out.println("</body>");
                     out.println("</html>");
               
            } 
            else{ 
                out.println("<html>");

                out.println("<body>");
                out.println("<script>");
                out.println("alert('failed to accept the applicant.')");
                 out.println("window.location.replace('showJob.jsp?jobID="+jobID+"');");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
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
            Logger.getLogger(sendInitialAcceptance.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sendInitialAcceptance.class.getName()).log(Level.SEVERE, null, ex);
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

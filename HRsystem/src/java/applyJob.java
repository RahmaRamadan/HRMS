/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Application.Recruitment.Application;
import Application.Recruitment.Recruitment;
import Entity.Recruitment.Applicant;
import Entity.Recruitment.Applicant_Type;
import Entity.Recruitment.Degree;
import Entity.Recruitment.Education;
import Entity.Recruitment.Experience;
import Entity.Recruitment.Job;
import Entity.Recruitment.JobType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author maria
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/applyJob"})
public class applyJob extends HttpServlet {

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
          
            int jobID = (int) session.getAttribute("searchedJob");
            String name = request.getParameter("fName") + " " + request.getParameter("lName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String[] titles = request.getParameterValues("titles");
            String[] type = request.getParameterValues("type");
            String []years = request.getParameterValues("years");
            String degree = request.getParameter("degree");
            String [] skills = request.getParameterValues("skills");
            String field =  request.getParameter("field");
            Double GPA = Double.parseDouble(request.getParameter("GPA"));
            Application application = new Application();
            Recruitment jd = new Recruitment();
            
            Job job = jd.getJobByID(jobID);
            
            
            
            Applicant applicant = new Applicant(-1,email,jobID,name,phone,gender,Applicant_Type.applied);
            applicant.setEducation(new Education(Degree.valueOf(degree),field,GPA));
            ArrayList <Experience> ex = new ArrayList <>();
          
            for(int i=0 ;i<titles.length;i++)
            {
                ex.add(new Experience(titles[i],JobType.valueOf(type[i]),Integer.parseInt(years[0])));
               // out.print(titles[i]);
            }
            //out.print(jobID);
            applicant.setExperience(ex);
            applicant.setSkills(skills);
            try{
          //  out.print(job.getTitle());
           if(application.apply(applicant,job)){
                out.print("<script>");
                out.print("alert('You have applied successfully!');");
                out.println("window.location.replace('careers.jsp');");
                out.print("</script>");
                
           }
           else{
                out.print("<script>");
                out.print("alert('Unfortunately, you have not applied successfully!');");
                out.println("window.location.replace('careers.jsp');");
                out.print("</script>");
               
           }

            

        }
        catch(Exception e)
        {
            out.print("<script>");
                out.print("alert('Sorry, a failture has happened');");
                out.println("window.location.replace('careers.jsp');");
                out.print("</script>");
               
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
            Logger.getLogger(applyJob.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(applyJob.class.getName()).log(Level.SEVERE, null, ex);
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

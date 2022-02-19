
package Application.Recruitment;

import Application.HR_Component;
import DataAccess.Recruitment.MySQL_Job_DataAccess;
import Entity.Recruitment.Job;
import java.sql.SQLException;
import java.util.ArrayList;
import DataAccess.Recruitment.Employee_Applicant_DataAccess_Interface;
import DataAccess.Recruitment.Employee_Job_DataAccess_Interface;
import DataAccess.Recruitment.MySQL_Applicant_DataAccess;
import Entity.Recruitment.Applicant;
import Entity.Recruitment.Applicant_Type;
import Entity.Department;

/**
 *
 * @author maria
 */
public class Recruitment extends HR_Component {
    
    public boolean checkThereAreJobs() throws SQLException{
        Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
          return (jobDataAccess.checkThereAreJobs());
  
    }
     public ArrayList<Job> getAllJobs() throws SQLException{
         Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
         return jobDataAccess.getAllJobs();
     } 
     public Job getJobByID(int ID) throws SQLException{
         Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
         return jobDataAccess.getJobByID(ID);
     }
     public boolean insertJob(Job job) throws SQLException
     {
         Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
         job.setID(jobDataAccess.generateJobID());
         return jobDataAccess.insertJob(job);
     }
     public boolean deleteJobByID(int ID) throws SQLException {
         Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
         return jobDataAccess.deleteJobByID(ID);
     }
 
    public boolean updateJob(Job job) throws SQLException {
        Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
        
         return jobDataAccess.updateJob(job);
    }
    public boolean setApplicantInitiallyAccepted(int applicantID) throws SQLException
    {
        Employee_Applicant_DataAccess_Interface applicantDataAccess = new MySQL_Applicant_DataAccess();
       
       return applicantDataAccess.updateApplicantType(applicantID, Applicant_Type.initiallyAccepted);
    }
        public boolean setApplicantAccepted(int applicantID) throws SQLException
    {
        Employee_Applicant_DataAccess_Interface applicantDataAccess = new MySQL_Applicant_DataAccess();
        Applicant applicant = applicantDataAccess.getApplicantByID(applicantID);
       return applicantDataAccess.updateApplicantType(applicantID, Applicant_Type.accepted);
    }
        public boolean deleteApplicant(int applicantID) throws SQLException{
            Employee_Applicant_DataAccess_Interface applicantDataAccess = new MySQL_Applicant_DataAccess();
            return applicantDataAccess.deleteApplicant(applicantID);
        }
        public Applicant getApplicantByID(int applicantID) throws SQLException
        { Employee_Applicant_DataAccess_Interface applicantDataAccess = new MySQL_Applicant_DataAccess();
        
            return applicantDataAccess.getApplicantByID(applicantID);
        }
            public ArrayList<Department> getJobsCategory() throws SQLException{
              Employee_Job_DataAccess_Interface jobDataAccess = new MySQL_Job_DataAccess();
             return jobDataAccess.getJobsCategory();
            }
            
}

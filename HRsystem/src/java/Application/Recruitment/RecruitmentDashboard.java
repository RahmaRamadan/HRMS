/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Recruitment;


import Algorithms.Recruitment.ApplicantStatistics;

import Entity.Recruitment.Applicant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class RecruitmentDashboard {
       ApplicantStatistics applicantStatistics;
       public RecruitmentDashboard(double jobRequiredScore,ArrayList<Applicant> applicants){
                   
      applicantStatistics = new ApplicantStatistics(applicants,jobRequiredScore);
      }
       
      public List<Map<Object, Object>> genderDistribution() throws SQLException{
          return applicantStatistics.getGenderCount();
          
      }
      
      public List<Map<Object, Object>> genderScore() throws SQLException{
          return applicantStatistics.getGenderScore();
      }
      public List<Map<Object, Object>> skillsDistribution() throws SQLException{
          return applicantStatistics.getSkillsCount();
      }
      public List<Map<Object, Object>> getRatioAboveAndBelowRequiredScore() throws SQLException
      {
         
          return applicantStatistics.getNBelow_NAbove();
                
      }

}

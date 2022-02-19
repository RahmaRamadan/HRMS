/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Recruitment;

import Algorithms.Recruitment.Semantic_Similarity;
import Algorithms.Recruitment.Semantic_Similarity_Interface;
import DataAccess.Recruitment.MySQL_Applicant_DataAccess;
import Entity.Recruitment.Applicant;
import Entity.Recruitment.Job;
import java.sql.SQLException;
import DataAccess.Recruitment.Applicant_Applicant_DataAccess_Interface;

/**
 *
 * @author maria
 */
public class Application {
    
    public boolean apply(Applicant applicant,Job job) throws SQLException
    {
        
        Semantic_Similarity_Interface ss =  new Semantic_Similarity();
        applicant.setScore(ss.getApplicantJobSimilarity(applicant, job));
        System.out.println(111111);
        Applicant_Applicant_DataAccess_Interface ad = new MySQL_Applicant_DataAccess();
        System.out.println(ss.getApplicantJobSimilarity(applicant, job)+" helllllo");
        return ad.insertApplicant(applicant);
    }
    public int generateApplicantID() throws SQLException
    {
        Applicant_Applicant_DataAccess_Interface ad = new MySQL_Applicant_DataAccess();
        return ad.generateApplicantID();
    }
    
}

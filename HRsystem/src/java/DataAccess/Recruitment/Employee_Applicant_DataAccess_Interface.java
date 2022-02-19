/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Recruitment;

import Entity.Recruitment.Applicant;
import Entity.Recruitment.Applicant_Type;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Employee_Applicant_DataAccess_Interface {
    ArrayList<Applicant> getApplicants(int jobID) throws SQLException ;
    boolean deleteApplicant(int applicantID) throws SQLException ;
    boolean updateApplicant(Applicant applicant) throws SQLException ;
    boolean updateApplicantType(int applicantIDS, Applicant_Type at)  throws SQLException ;
    Applicant getApplicantByID(int applicantID) throws SQLException ;
    
    
}

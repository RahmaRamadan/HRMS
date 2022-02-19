/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Recruitment;

import Entity.Recruitment.Applicant;
import java.sql.SQLException;


/**
 *
 * @author maria
 */
public interface Applicant_Applicant_DataAccess_Interface {
    public boolean insertApplicant(Applicant applicant) throws SQLException;
    public int   generateApplicantID() throws SQLException;
   
   
    
}

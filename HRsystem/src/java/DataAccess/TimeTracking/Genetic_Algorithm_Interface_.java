/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.TimeTracking;

import Entity.TimeTracking.Milestone;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Genetic_Algorithm_Interface_ {
     public ArrayList<Milestone> getMyMilestones(String employeeid) throws Exception;
     public boolean assignEmployees(ArrayList<String> employeesIDs, ArrayList<String> milestonesIDs)  throws SQLException, Exception ;
}

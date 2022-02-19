/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.TimeTracking;

import DataAccess.DatabaseConnection;
import Entity.TimeTracking.Score;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Milestone_DataAccess_Interface {

    public boolean addMilestone(int projectID, Milestone milestone) throws SQLException, Exception;

    public ArrayList<Milestone> getProjectMilestone(int projectID) throws SQLException, Exception;

    public boolean deleteMilestone(int milestoneid) throws SQLException, Exception;

    public boolean deleteMilestoneByProject(int projectid) throws SQLException, Exception;

    public boolean updateMilestone(int projectID, Milestone milestone) throws SQLException, Exception;

    public boolean setMilestoneState(int milestoneID, String state) throws SQLException, Exception;

    public boolean assignEmployees(ArrayList<String> employeesIDs, ArrayList<String> milestonesIDs) throws SQLException, Exception;

    public ArrayList<String> getMilestoneSkills(int milestoneID) throws SQLException, Exception;
    
    public  int generateMilestoneID() throws SQLException, Exception;
    
    public Milestone getMilestoneByID(int milestoneID) throws SQLException, Exception;
}

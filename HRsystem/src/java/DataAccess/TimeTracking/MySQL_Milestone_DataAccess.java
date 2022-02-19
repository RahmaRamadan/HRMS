package DataAccess.TimeTracking;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rana
 */
import DataAccess.DatabaseConnection;
import Entity.TimeTracking.Score;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import java.sql.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rana
 */
public class MySQL_Milestone_DataAccess implements Milestone_DataAccess_Interface, Genetic_Algorithm_Interface_ {

    public int generateMilestoneID() throws SQLException, Exception {

        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        int n = 0;
        ResultSet rs = statement.executeQuery("SELECT MAX(ID) FROM milestone");
        while (rs.next()) {
            n = rs.getInt(1);
        }
        rs.close();
        statement.close();
        conn.close();
        n += 1;
        return n;
    }

    public boolean addMilestone(int projectID, Milestone milestone) throws SQLException, Exception {

      
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();

        if (conn == null) {
            return false;
        }
        try {
            Statement statement = conn.createStatement();

            String query = " insert into milestone (ID, projectID, startDate, endDate, assignedEmpID, requiredTimeInMin, importance, state,title)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?,?);";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, milestone.getID());
            preparedStmt.setInt(2, projectID);
            preparedStmt.setDate(3, milestone.getStartDate());
            preparedStmt.setDate(4, milestone.getEndDate());
            preparedStmt.setString(5, milestone.getEmployeeID()); // changed
            preparedStmt.setDouble(6, milestone.getDuration());
            preparedStmt.setString(7, milestone.getScore().toString());
            preparedStmt.setString(8, milestone.getState().toString());
            preparedStmt.setString(9, milestone.getName());
            // execute the preparedstatement
            preparedStmt.execute();

            for (int i = 0; i < milestone.getSkills().size(); i++) {
                query = " insert into milestone_skills (milestoneID, skill,projectID)"
                        + " values (?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, milestone.getID());
                preparedStmt.setString(2, milestone.getSkills().get(i));
                preparedStmt.setInt(3, projectID);

                // execute the preparedstatement
                preparedStmt.execute();
            }
            preparedStmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<Milestone> getProjectMilestone(int projectID) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();

        String query = "SELECT * FROM milestone where projectID = " + projectID + " ;";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<Milestone> milestones = new ArrayList<>();
        while (rs.next()) {
            ArrayList<String> skills = new ArrayList<>();
            
           Milestone milestone = new Milestone(rs.getInt("ID"), rs.getString("title"), rs.getDate("startDate"), rs.getDate("endDate"), Score.valueOf(rs.getString("importance")), Milestone_State.valueOf(rs.getString("state")), rs.getString("assignedEmpID"), skills);
           milestones.add(milestone);
            

            }
                
        rs.close();

        statement.close();
        conn.close();
        for (int i=0 ; i<milestones.size(); i++)
        {
            Milestone temp = milestones.get(i);
            temp.setSkills(getMilestoneSkills(temp.getID()));
            milestones.set(i,temp );
        }
        
        return milestones;
    }

    @Override
    public ArrayList<String> getMilestoneSkills(int milestoneID) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();

        String query = "SELECT * FROM milestone_skills where milestoneid=" + milestoneID + " ;";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ArrayList<String> skills = new ArrayList<>();
        while (rs.next()) {

            skills.add(rs.getString("skill"));

        }
        rs.close();

        statement.close();
        conn.close();
        return skills;
    }

    @Override
    public boolean deleteMilestone(int milestoneid) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        try {
            statement.executeUpdate("DELETE FROM milestone_skills WHERE milestoneID=" + milestoneid + ";");
            statement.executeUpdate("DELETE FROM milestone WHERE ID=" + milestoneid + ";");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            statement.close();
            conn.close();

            return false;
        }
    }

    @Override
    public boolean deleteMilestoneByProject(int projectid) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        try {
            statement.executeUpdate("DELETE FROM milestone_skills WHERE projectID=" + projectid + ";");
            statement.executeUpdate("DELETE FROM milestone WHERE projectID=" + projectid + ";");

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            statement.close();
            conn.close();

            return false;
        }
    }

    public boolean updateMilestone(int projectID, Milestone milestone) throws SQLException, Exception {
        boolean b1 = deleteMilestone(milestone.getID());
        boolean b2 = addMilestone(projectID, milestone);
        return b1 && b2;

    }

    public boolean setMilestoneState(int milestoneID, String state) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        try {

            statement.executeUpdate("UPDATE milestone SET state='" + state + "' WHERE ID=" + milestoneID + ";");

            statement.close();
            conn.close();

            conn.close();

            return true;

        } catch (SQLException e) {
            statement.close();
            return false;
        }
    }
    
        @Override
    public ArrayList<Milestone> getMyMilestones(String employeeid) throws Exception {

        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();

        String query = "SELECT * FROM milestone where assignedEmpID = '" + employeeid + "' ;";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        ArrayList<Milestone> milestones = new ArrayList<>();
        
             while (rs.next()) {
            ArrayList<String> skills = new ArrayList<>();
            
           Milestone milestone = new Milestone(rs.getInt("ID"), rs.getString("title"), rs.getDate("startDate"), rs.getDate("endDate"), Score.valueOf(rs.getString("importance")), Milestone_State.valueOf(rs.getString("state")), rs.getString("assignedEmpID"), skills);
           milestones.add(milestone);
            

            }
                
        rs.close();

        statement.close();
        conn.close();
        for (int i=0 ; i<milestones.size(); i++)
        {
            Milestone temp = milestones.get(i);
            temp.setSkills(getMilestoneSkills(temp.getID()));
            milestones.set(i,temp );
        }
        
        return milestones;
    }

    @Override
    public boolean assignEmployees(ArrayList<String> employeesIDs, ArrayList<String> milestonesIDs) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        try {
            for (int i = 0; i < employeesIDs.size(); i++) {

                statement.executeUpdate("UPDATE milestone SET assignedEmpID='" + employeesIDs.get(i) + "' WHERE ID=" + milestonesIDs.get(i) + ";");

            }

            statement.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            statement.close();
            conn.close();

            return false;
        }
    }
    @Override
     public Milestone getMilestoneByID(int milestoneID) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();

        String query = "SELECT * FROM milestone where ID = " + milestoneID + " ;";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);

        Milestone milestone = null;
        while (rs.next()) {
            ArrayList<String> skills = new ArrayList<>();
            
           milestone = new Milestone(rs.getInt("ID"), rs.getString("title"), rs.getDate("startDate"), rs.getDate("endDate"), Score.valueOf(rs.getString("importance")), Milestone_State.valueOf(rs.getString("state")), rs.getString("assignedEmpID"), skills);
                    
            }
                
        rs.close();

        statement.close();
        conn.close();
         
            milestone.setSkills(getMilestoneSkills(milestone.getID()));

        return milestone;
    }

}

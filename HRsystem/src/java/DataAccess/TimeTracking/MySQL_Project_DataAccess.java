/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.TimeTracking;

/**
 *
 * @author rana
 */
import DataAccess.DatabaseConnection;
import Entity.DepartmentID;
import Entity.TimeTracking.Score;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import Entity.TimeTracking.Project;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rana
 */
public class MySQL_Project_DataAccess implements Project_DataAccess_Interface, Employee_Project_DataAccess_Interface {

    @Override
    public int generateProjectID() throws SQLException, Exception {

        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
        Statement statement = conn.createStatement();

        int n = 0;
        ResultSet rs = statement.executeQuery("SELECT MAX(ID) FROM project");
        while (rs.next()) {
            n = rs.getInt(1);
        }
        statement.close();
        conn.close();
        n += 1;
        return n;
    }

    @Override
    public boolean addProject(Project project) throws SQLException, Exception {
        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection conn = dc.getConnection();
System.out.println("not doneeee");
        if (conn == null) {
            
            return false;
        }
        try {
            Statement statement = conn.createStatement();

            String query = " insert into project (ID, title, departmentID, description)"
                    + " values (?, ?, ? ,?);";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, project.getID());
            preparedStmt.setString(2, project.getTitle());
            preparedStmt.setString(3, project.getDepartment().toString());
            preparedStmt.setString(4, project.getDescription());
            // execute the preparedstatement
            System.out.println(preparedStmt);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
            System.out.println("dooneeeeeeee");

            for (int i = 0; i < project.getMilestones().size(); i++) {
                mi.addMilestone(project.getID(), project.getMilestones().get(i));
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteProject(int projectID) throws SQLException, Exception {
        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        try {
            mi.deleteMilestoneByProject(projectID); // it also deletes skills

            DatabaseConnection dc = new DatabaseConnection();
            java.sql.Connection conn = dc.getConnection();


            Statement statement = conn.createStatement();

            statement.executeUpdate("DELETE FROM project WHERE ID=" + projectID + ";");

            statement.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateProject(Project project) throws Exception {
        boolean b1 = deleteProject(project.getID());
        boolean b2 = addProject(project);
        return b1 && b2;

    }

    @Override
    public ArrayList<Project> getProjects() throws Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection connection = dc.getConnection();
        java.sql.Statement statement = connection.createStatement();

        ArrayList<Project> allProjects = new ArrayList<>();

        ResultSet rs = statement.executeQuery("SELECT * FROM project ;");

        while (rs.next()) {
            Project project = new Project(rs.getInt("ID"), rs.getString("title"), rs.getString("description"), DepartmentID.valueOf(rs.getString("departmentID")));

            allProjects.add(project);

        }
        statement.close();
        connection.close();

        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        for (int i = 0; i < allProjects.size(); i++) {
            Project project = allProjects.get(i);
            project.setMilestones(mi.getProjectMilestone(project.getID()));

            allProjects.set(i, project);
        }

        return allProjects;
    }

    @Override
    public Project getProjectByID(int projectid) throws Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection connection = dc.getConnection();
        java.sql.Statement statement = connection.createStatement();

        Project project = null;

        ResultSet rs = statement.executeQuery("SELECT * FROM project WHERE ID= "+ projectid+";");

        while (rs.next()) {
            project = new Project(rs.getInt("ID"), rs.getString("title"), rs.getString("description"), DepartmentID.valueOf(rs.getString("departmentID")));

        }
        statement.close();
        connection.close();
        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        project.setMilestones(mi.getProjectMilestone(project.getID()));
        
        return project;

    }

    @Override
    public boolean setMilestoneCompletedNotConfirmed(int mID) throws Exception {
        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        return mi.setMilestoneState(mID, Milestone_State.Completed_Not_Confirmed.toString());
    }

    @Override
    public boolean setMilestoneInProgress(int mID) throws Exception {
        Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        return mi.setMilestoneState(mID, Milestone_State.In_Progress.toString());
    }
    private ArrayList<String> getMilestoneSkills(int milestoneID) throws SQLException, Exception {
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



    public Map<Integer, ArrayList<String>> getMilestoneSkills(ArrayList<Milestone> milestones) throws Exception {
        Map<Integer, ArrayList<String>> milestonesofProject = new HashMap();
         Milestone_DataAccess_Interface mi = new MySQL_Milestone_DataAccess();
        for (int i=0 ; i<milestones.size(); i++)
        {
            milestonesofProject.put(milestones.get(i).getID(),mi.getMilestoneSkills(milestones.get(i).getID()));
        }
        return milestonesofProject;
          
    }



}

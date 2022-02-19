/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.TimeTracking;

import DataAccess.TimeTracking.Milestone_DataAccess_Interface;
import DataAccess.TimeTracking.MySQL_Milestone_DataAccess;
import DataAccess.TimeTracking.MySQL_Project_DataAccess;
import DataAccess.TimeTracking.Project_DataAccess_Interface;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Project;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class ProjectManager {

    private Project_DataAccess_Interface projectInterface;
    private Milestone_DataAccess_Interface mi;

    public ProjectManager() {
        projectInterface = new MySQL_Project_DataAccess();
        mi = new MySQL_Milestone_DataAccess();
    }

    public boolean addProject(Project project) throws Exception {
        return projectInterface.addProject(project);
    }
    public int generateProjectID() throws Exception
    {
    return projectInterface.generateProjectID();
    }
    public int generateMilestoneID() throws Exception
    {
         return mi.generateMilestoneID() ;
    }

    public boolean updateProject(Project project) throws Exception {
        return projectInterface.updateProject(project);
    }

    public boolean deleteProject(int projectID) throws Exception {
        return projectInterface.deleteProject(projectID);
    }

    public ArrayList<Project> getProjects() throws Exception {
        return projectInterface.getProjects();
    }

    public Project getProjectByID(int projectid) throws Exception {
        return projectInterface.getProjectByID(projectid);
    }

    public boolean addMilestoneToProject(int projectID, Milestone milestone) throws Exception {
        return mi.addMilestone(projectID, milestone);
    }

    public boolean deleteMilestone(int milestoneID) throws Exception {

        return mi.deleteMilestone(milestoneID);

    }

    public boolean updateMilestone(int projectID, Milestone milestone) throws Exception {
        return mi.updateMilestone(projectID, milestone);

    }
    public boolean setMilestoneCompleted(int mileID) throws Exception
    {
        return mi.setMilestoneState(mileID, "Completed_Confirmed");

}
public Milestone getMilestoneByID(int mID) throws Exception
{
    return mi.getMilestoneByID(mID);
}}


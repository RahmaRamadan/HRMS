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

import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Project;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public interface Project_DataAccess_Interface {
    
   
    public boolean addProject(Project project)throws SQLException, Exception ;
    public boolean updateProject(Project project) throws  Exception;
    public boolean deleteProject(int projectID) throws SQLException, Exception;
    public  ArrayList<Project> getProjects() throws SQLException,Exception;
    public Project getProjectByID(int projectid)throws  Exception ;
    public int generateProjectID() throws SQLException, Exception ;
   
   

    
   
         
}

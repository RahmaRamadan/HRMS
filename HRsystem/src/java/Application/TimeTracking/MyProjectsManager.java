/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.TimeTracking;

import Algorithms.TimeTracking.TimeTrackingStatistics;
import DataAccess.TimeTracking.Employee_Project_DataAccess_Interface;
import DataAccess.TimeTracking.MySQL_Project_DataAccess;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Project;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class MyProjectsManager {
    
    private TimeTrackingStatistics timeTrackingStatistics;
    
    public MyProjectsManager()
    {
       
       
      
    }
   
    public TimeTrackingStatistics getTimeTrackingStatistics() throws Exception
    {timeTrackingStatistics = new TimeTrackingStatistics();
        return timeTrackingStatistics;
    }
    public ArrayList<Milestone> getMyMilestones(String empID) throws Exception
    {
        Employee_Project_DataAccess_Interface pi = new MySQL_Project_DataAccess();
        return pi.getMyMilestones(empID);
    }
    public boolean setMilestoneInProgress(int mID) throws Exception
    {
         Employee_Project_DataAccess_Interface pi = new MySQL_Project_DataAccess();
         return pi.setMilestoneInProgress(mID);
    }
            
            
    public boolean  setMilestoneCompletedNotConfirmed(int mID) throws Exception
    { Employee_Project_DataAccess_Interface pi = new MySQL_Project_DataAccess();
        return pi.setMilestoneCompletedNotConfirmed(mID);
    }
    
    
}

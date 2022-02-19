/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.TimeTracking;

import Algorithms.TimeTracking.GeneticAlgorithm;
import Algorithms.TimeTracking.ProjectManager;
import Algorithms.TimeTracking.TimeTrackingStatistics;
import Application.HR_Component;
import DataAccess.TimeTracking.MySQL_Project_DataAccess;
import DataAccess.TimeTracking.Project_DataAccess_Interface;
import Entity.TimeTracking.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class Time_Tracking  extends HR_Component {
    private ProjectManager  projectManager ;
    private TimeTrackingStatistics timeTrackingStatistics;
    private GeneticAlgorithm GA;
    public Time_Tracking()
    {
       projectManager=new ProjectManager();     
       GA = new GeneticAlgorithm();
    }
    
    public ProjectManager getProjectManager()
    {
        return projectManager;
    }
    public TimeTrackingStatistics getTimeTrackingStatistics() throws Exception
    {
         timeTrackingStatistics= new TimeTrackingStatistics();
         return timeTrackingStatistics;
    }
    public GeneticAlgorithm getGeneticAlgorithm()
    {
        return GA;
    }
    
}

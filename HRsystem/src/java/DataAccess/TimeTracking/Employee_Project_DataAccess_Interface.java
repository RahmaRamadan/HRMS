/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.TimeTracking;

import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Project;
import java.util.ArrayList;

/**
 *
 * @author maria
 */

public interface Employee_Project_DataAccess_Interface {
    public boolean setMilestoneCompletedNotConfirmed(int mID)throws Exception; // let it completed_not confirmed
    public boolean setMilestoneInProgress(int mID)throws Exception;
    public ArrayList<Milestone> getMyMilestones(String empID)throws Exception  ;
    
}

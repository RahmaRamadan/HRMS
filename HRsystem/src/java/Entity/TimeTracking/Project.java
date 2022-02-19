/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.TimeTracking;

/**
 *
 * @author rana
 */

import Entity.DepartmentID;
import Entity.TimeTracking.Milestone;
import java.sql.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rana
 */
public class Project {
    int ID;
    String title;
    String description;
    DepartmentID department;
    double totalScore;
    ArrayList<Milestone> milestones = new ArrayList<>();
    
    public Project(int ID, String Title, String Description, DepartmentID depart)
   {
       this.ID = ID;
       this.title = Title;
       this.description = Description;
       this.department =depart;
      
   }


   public void setMilestones(ArrayList<Milestone> milestones)
   {

      this.milestones = milestones;      
   }
   public void setTitle(String title)
   {
       this.title = title; 
   }
   public void setDepartment(DepartmentID depart)
   {
       this.department = depart; 
   }
   public void setDescription(String desc)
   {
       this.description = desc; 
   }   
   public void setTotalScore(double ts)
   {
       this.totalScore = ts; 
   }   
     public int getID()
   {
       return ID;
   }
   
   public String getTitle()
   {
       return title;
   }
    
   public String getDescription()
   {
       return description;
   }
    
   public DepartmentID getDepartment()
   {
       return department;
   }
       
   public double getTotalScore()
   {
       return totalScore;
   }
    
   public ArrayList<Milestone> getMilestones()
   {
       return milestones;
   }

}


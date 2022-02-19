/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.TimeTracking;



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
public class Milestone {
    private int ID;
    private Date startDate;
    private Date endDate;
    private String name;
    private ArrayList <String> skills ;
    private Score score;
    private String employeeID;
    private Milestone_State state;
    private double duration ;
    
   public Milestone(int MilestoneID,String Name,Date Start_Date, Date End_Date, Score score,Milestone_State State, String employeeid, ArrayList <String> skills_ )
   {
       this.ID = MilestoneID;
       
       this.startDate = Start_Date;
       this.endDate = End_Date;
       this.name = Name;
       this.score = score;
       this.state = State;
       this.employeeID = employeeid;
       this.duration = (endDate.getTime()- startDate.getTime())/(2.8*10000000);
        skills = skills_;
       
     
   }
   
   
   
   public void setSkills(ArrayList<String> Skills)
   {
        skills = Skills;
   }
   public void setName(String Name)
   {
       name= Name;
   }
   public void setStartDate(Date sd)
   {
       startDate = sd;
       duration = endDate.getTime() - startDate.getTime(); 
   }
   public void setEndDate(Date ed)
   {
       endDate = ed;
       duration = endDate.getTime() - startDate.getTime(); 
   }
   public void setEmployeeID(String empID)
   {
       employeeID = empID;
   }
   public void setDuration(Double durat)
   {
       duration = durat;
   }
      
   public void setState(Milestone_State state)
   {
       this.state = state;
       
   }
   public int getID()
   {
       return ID;
   }
   
  
   public Date getStartDate()
   {
       return startDate;
   }
   
   public Date getEndDate()
   {
       return endDate;
   }
   
   public String getName()
   {
       return name;
   }
   
   public ArrayList<String> getSkills()
   {
       return skills;
   }
   
   public Score getScore()
   {
       return score;
   }
   public Milestone_State getState()
   {
       return state;
   }
   
   public String getEmployeeID()
   {
       return employeeID;
   }
      public Double getDuration()
   {
       return duration ;
   }
    
}

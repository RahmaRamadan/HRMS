package Entity;
import java.sql.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zak
 */
public class Training
{
    int ID , Score ;
    String Name , Description , Department , Start_Date , End_Date ;
    ArrayList<String> Skills = new ArrayList<>();
    ArrayList<Double> Enroll_Scores = new ArrayList<>();
     
    public Training(int id , String name ,   String s , String e, String Des ,  int score)
    {
        ID = id ;
        Name = name ;
        Description = Des ;
        Start_Date = s ;
        End_Date = e ;
        Score = score ;
    }

    public Training() {
    }
    
    public void setID(int id)
    {
        ID = id ;
    }
    
    public int getID()
    {
        return ID ;
    }
    
      public void setName(String n)
    {
        Name = n ;
    }
    
     public String getName()
    {
        return Name ;
    }
    
      public void setDescription(String d)
    {
        Description = d ;
    }
    
     public String getDescription()
    {
        return Description ;
    }
    
      public void setDepartment(String d)
    {
        Description = d ;
    }
    
     public String getDepartment()
    {
        return Department ;
    }
    
     public void setStart_Date(String s)
    {
        Start_Date = s ; 
    }
    
     public String getStart_Date()
    {
        return Start_Date ;
    }
    
      public void setEnd_Date(String e)
    {
        End_Date = e  ; 
    }
    
     public String getEnd_Date()
    {
        return End_Date ;
    }
    
     public void setScore(int s)
    {
        Score = s ;
    }
    
     public int getScore()
    {
        return Score ;
    }
     
     public void setSkills(ArrayList<String> s)
     {
         Skills = s ;
     }
     
     public ArrayList<String> getSkills()
     {
         return Skills  ;
     }
     
     public void setEnrollScores(ArrayList<Double> scores)
     {
         Enroll_Scores = scores;
     }
     
     public ArrayList<Double> setEnrollScores()
     {
         return Enroll_Scores;
     }
}

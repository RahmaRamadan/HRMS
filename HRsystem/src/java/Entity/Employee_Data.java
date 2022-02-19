/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Employee_Data {
    private String ID;
    private String fName;
    private String lName;
    private String gender;
    private String username;
    private String password;
    private String address;
    private String salary;
    private String title;
    private String nVacations;
    private String hiringDate;
    private String age;
    private String empTypee;
    private String departmentID;
    private String depart;
    private String hrComp;
    private int score;
//    private ArrayList<Monthly_Salary> salaries;
    private ArrayList<String> Skills = new ArrayList<>();
    private ArrayList<Integer> Employee_Scores = new ArrayList<>();
    
    // setter and getter and constructor
    
    public Employee_Data() {}
    
    
    public Employee_Data (String id, String fname, String lname,String gen,String user_name,String pass, String add, String salar, String title_ , String nVacations_, String hiring_Date, String age_,String empType, String departID, String dep, String comp)
    {
    ID = id;
    fName = fname;
    lName= lname;
    gender = gen;
    username= user_name;
    password= pass;
    address=add;
    salary= salar;
    title= title_;
    nVacations= nVacations_;
    hiringDate=hiring_Date;
    age= age_;
    empTypee = empType; 
   departmentID = departID;
   depart = dep;
   hrComp = comp;
        
    }
/*    public void setSalaries(ArrayList<Monthly_Salary> salaries_)
    {
        salaries=salaries_;
    }*/
    
    public void setID(String id)
    {
        ID = id ;
    }
    
    public String getID()
    {
        return ID;
    }
    public void setFName(String f)
    {
      fName = f;
    }
    public String getFName()
    {
        return fName;
    }
    public void setLName(String l)
    {
      lName = l;
    }
    public String getLName()
    {
        return lName;
    }
    
      public void setScore(int s)
    {
        score = s ;
    }
    
    public int getScore()
    {
        return score ;
    }
    public String getGender()
    {
        return gender;
    }
    public String getUsername()
    {
   return username;
    }
    public String getPassword()
    {     return password;
        
    }
    public String getAddress(){
        return address;
    }
    public String getSalary()
    {
        return salary;
    }
    public String getTitle()
    {
        return title;
    }
    public String getNVacations()
    {
        return nVacations;
    }
    public String getHiringDate()
    {
        return hiringDate;
    }
    public String getAge()
    {
        return age;
    }
    public String getEmpType()
    {
        return empTypee;
    }
    public String getDepartmentID()
    {
        return departmentID;
    }
    public String getDepartment()
    {
        return depart;
    }
    public void setSkills(ArrayList<String> s)
    {
        Skills = s ;
    } 
    public ArrayList<String> getSkills()
    {
        return Skills  ;
    }
    
    public void setEmployeeScores(ArrayList<Integer> s)
    {
        Employee_Scores = s ;
    } 
    public ArrayList<Integer> getEmployeeScores()
    {
        return Employee_Scores  ;
    }
    
    public String getHrComp()
    {
       if(hrComp != null) return hrComp;
       else return "not HR employee";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Recruitment;

import java.util.ArrayList;
import java.lang.String;

/**
 *
 * @author maria
 */
public class Applicant {

    private int ID;
    private String email;
    private int jobID;
    private String name;
    private String phone;
    private Education education;
    private ArrayList<Experience> experience;
    private String[] skills;
    private double score;
    private String gender ;
    private Applicant_Type state;
    

    public Applicant(int id,String e,int j , String n, String p,String g,Applicant_Type s) {
        ID = id;
        jobID = j;
        name = n;
        email = e;
        phone = p;
        score = 0;
        gender =g;
        state = s;
       
    }
    public void setID(int  id) {
        ID = id;

    }
    public void setEducation(Education e) {
        education = e;

    }

    public void setExperience(ArrayList<Experience> e) {
        experience = e;

    }

    public void setSkills(String[] s) {
        skills = s;

    }
    public void setScore(double s){
        score = s;
    }

  public int getID()
  {
      return ID;
  }

    public int getJobID() {
        return jobID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Education getEducation() {
        return education;

    }

    public ArrayList<Experience> getExperience() {
        return experience;

    }

    public String [] getSkills() {
        return skills;

    }
    public double getScore()
    {
        return score;
    }
    public String getGender()
    {
        return gender;
    }
    public Applicant_Type getState(){
        return state;
    }

}

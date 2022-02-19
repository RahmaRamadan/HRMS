/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Recruitment;

import Entity.Department;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Job {

    private int ID;
    private String title;
    private String description;
    private Education requiredEducation;
    private String[] requiredSkills;
    private String time;
    private int years;
    private String posterUsername;
    private JobType type;
    private ArrayList<Applicant> applicants;
    private Department category;
    private double score;

    public Job(int id, String tit, String de, Education rd, int ye, String tim, String pe, JobType ty, Department cat) {
        
        ID = id;
        title = tit;
        description = de;
        requiredEducation = rd;
        years = ye;
        time = tim;
        posterUsername = pe; 
        requiredSkills = new String[1];
        type = ty;
        category = cat;
       

    }

    public void setRequiredSkills(String[] rs) {
        requiredSkills = rs;
    }

    public void setApplicants(ArrayList<Applicant> app) {
        applicants = app;
    }

    public void setID(int id) {
        ID = id;
    }

    public int getID() {
        return ID;
    }
    public void setScore(double s)
    {
        score = s;
    }
    public double getScore()
    {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Education getRequiredEducation() {
        return requiredEducation;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public String getTime() {
        return time;
    }

    public int getYears() {
        return years;
    }

    public String getPosterUsername() {
        return posterUsername;
    }

    public JobType getType() {
        return type;
    }

    public ArrayList<Applicant> getApplicants() {
        return applicants;
    }

    public Department getCategory() {
        return category;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Recruitment;
import Entity.Recruitment.Applicant;
import Entity.Recruitment.Job;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author maria
 */
public class Semantic_Similarity implements Semantic_Similarity_Interface{
    


    @Override
    public double getApplicantJobSimilarity(Applicant applicant, Job job) {
         String s = null;
         String n="";
        try {
            
            String applicantEducation = applicant.getEducation().getDegree().toString()+"-"+applicant.getEducation().getField();
            applicantEducation = applicantEducation.replace(" ", "_");
            
            String applicantExperience = "";
            for(int i=0 ;i<applicant.getExperience().size();i++)
            {
                applicantExperience+=applicant.getExperience().get(i).getTitle()+"-"+applicant.getExperience().get(i).getYears();
                 if(i<applicant.getExperience().size()-1) applicantExperience+=",";
            }
            applicantExperience = applicantExperience.replace(" ", "_");
            String applicantSkills = "";
            for(int i =0; i<applicant.getSkills().length;i++)
            {
                applicantSkills+=applicant.getSkills()[i];
                if(i<applicant.getSkills().length-1) applicantSkills+="-";
            }
            applicantSkills = applicantSkills.replace(" ", "_");
            
            
            String jobEducation=job.getRequiredEducation().getDegree().toString()+"-"+job.getRequiredEducation().getField();
            jobEducation = jobEducation.replace(" ", "_");
            
            String jobSkills="";
             for(int i =0; i<job.getRequiredSkills().length;i++)
            {
                jobSkills+=job.getRequiredSkills()[i];
                if(i<job.getRequiredSkills().length-1) jobSkills+="-";
            }
            jobSkills = jobSkills.replace(" ", "_");
            
            System.out.println(applicantEducation+" "+applicantExperience+" "+applicantSkills+" "+jobEducation+" "+jobSkills);
            Process p = Runtime.getRuntime().exec("python C:\\Users\\maria\\OneDrive\\Desktop\\GPCodes\\applicantScore.py "+applicantEducation+" "+applicantExperience+" "+applicantSkills+" "+jobEducation+" "+jobSkills);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
           // System.out.println("Here is the standard output of the command:\n");
            
            while ((s = stdInput.readLine()) != null) {
             n=s;  
            }
          //  System.exit(0);
        }
        catch (IOException e) {
          //  System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
       // System.out.print(Double.parseDouble(n));
       return Double.parseDouble(n);
    }

    @Override
    public double getJobRequiredSimilarity(Job job) {
       // System.out.println("here");
          String s = null;
         String n="";
        try {  
            String jobSkills="";
             for(int i =0; i<job.getRequiredSkills().length;i++)
            {
                jobSkills+=job.getRequiredSkills()[i];
                if(i<job.getRequiredSkills().length-1) jobSkills+="-";
            }
            jobSkills = jobSkills.replace(" ", "_");
          
            Process p = Runtime.getRuntime().exec("python C:\\Users\\maria\\OneDrive\\Desktop\\GPCodes\\jobScore.py "+job.getYears()+" "+jobSkills);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
           // System.out.println("Here is the standard output of the command:\n");
        
            
            while ((s = stdInput.readLine()) != null) {
             n=s;  
            }
          //  System.exit(0);
        }
        catch (IOException e) {
          //  System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        
       return Double.parseDouble(n);
    }
    
    
}

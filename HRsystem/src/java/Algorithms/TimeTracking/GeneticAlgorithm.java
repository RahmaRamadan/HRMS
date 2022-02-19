/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.TimeTracking;

import DataAccess.TimeTracking.Genetic_Algorithm_Interface_;
import DataAccess.EmployeesAffairs.Genetic_Algorithm_Interface;
import DataAccess.EmployeesAffairs.MySQL_Employee_DataAccess;
import DataAccess.TimeTracking.MySQL_Milestone_DataAccess;
import Entity.Employee_Data;
import Entity.TimeTracking.Milestone;
import Entity.TimeTracking.Milestone_State;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class GeneticAlgorithm {

    public boolean runGeneticAlgorithm(ArrayList<Milestone> milestones) throws Exception {
        // call database function to get employees 

        // for each month available time is        30-max(totalusedTime,day)+1  
        // prepare 2 strings
        String milestonesSkills = "";
        String milestonesRequiredTime = "";

        for (int i = 0; i < milestones.size(); i++) {

            milestonesSkills += milestones.get(i).getID() + ":";
            for (int j = 0; j < milestones.get(i).getSkills().size(); j++) {
                milestonesSkills += milestones.get(i).getSkills().get(j);
                if (j < milestones.get(i).getSkills().size() - 1) {
                    milestonesSkills += "-";
                }
            }
            if (i < milestones.size() - 1) {
                milestonesSkills += ",";
            }
            milestonesRequiredTime += milestones.get(i).getID() + ":" + milestones.get(i).getDuration();

            if (i < milestones.size() - 1) {
                milestonesRequiredTime += ",";
            }
        }
        milestonesSkills=milestonesSkills.replace(" ", "_");
        
        System.out.println(milestonesSkills);
        for (int i = 0; i < milestones.size(); i++) {

        }
        // pass them into the code
        Genetic_Algorithm_Interface gene = new MySQL_Employee_DataAccess();
        Genetic_Algorithm_Interface_ gai = new MySQL_Milestone_DataAccess();
        ArrayList<Employee_Data> employees = gene.getEmployees("");
        ArrayList<Integer> availableTimes = new ArrayList<>();
        String availableTime = "";
        String empSkills = "";
        
        for (int i = 0; i < employees.size(); i++) {
            ArrayList<Milestone> milestones_ = gai.getMyMilestones(employees.get(i).getID());
            int totalHours = 0;
            for (int j = 0; j < milestones_.size(); j++) {
                if (milestones_.get(j).getState().equals(Milestone_State.In_Progress) || milestones_.get(j).getState().equals(Milestone_State.Not_Started)) {
                    totalHours += milestones_.get(j).getDuration();
                }

            }
            int num = (25 * 8) - totalHours;
            availableTime += employees.get(i).getID() + ":" + num;
            if (i < employees.size() - 1) {
                availableTime += ",";
            }

            empSkills += employees.get(i).getID() + ":"; 
            // System.out.println("mmmmmmmmm1");
            ArrayList<String> tempo = gene.get_employee_Skills(employees.get(i).getID());
             //System.out.println("mmmmmmmmm2");
            for (int j = 0; j < tempo.size(); j++) {
                empSkills += tempo.get(j);
                if (j < tempo.size() - 1) {
                    empSkills += "-";
                }
            }
            if (i < employees.size() - 1) {
                empSkills += ",";
            }

        }
        empSkills = empSkills.replace(" ", "_");

        String s = null;
        String solution = "";
         
        try {

       //     System.out.println(milestonesSkills.trim() + " " + milestonesRequiredTime.trim() + " "+"101:Machine_learning-Python-deep_learning,102:NLP-python,104:java-python-uml,110:software_engineering-java,109:python-java-software_engineering,120:java-python-uml"+" "+"101:40,102:34,104:54,110:200,109:234,120:22");
            Process p = Runtime.getRuntime().exec("python C:\\Users\\maria\\OneDrive\\Desktop\\GPCodes\\geneticAlgorithm.py " + milestonesSkills.trim() + " " + milestonesRequiredTime.trim() + " "+empSkills.trim()+" "+availableTime.trim());
           // System.out.println("ta3aaaaaaaal");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            // System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                solution += s;
                System.out.println(s);
            }
            //  System.exit(0);
        } catch (IOException e) {
            //  System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
      //  System.out.println(solution);
        // System.out.print(Double.parseDouble(n));
        // parse the output and send it to dataAccess to update new values 
        ArrayList<String> employeesIDs = new ArrayList<>();
        ArrayList<String> milestonesIDs = new ArrayList<>();
        solution = solution.replace("{", "");
        solution = solution.replace("}", "");
        solution = solution.replace("'", "");
       
        solution = solution.replace(" ", "");
        String[] pairs = solution.split("],");
        for (int i = 0; i < pairs.length; i++) {
            String empMilesStr = pairs[i].replace(" ", "");
            //System.out.println(empMilesStr);
            String[] empMiles = empMilesStr.split(":");
            String temp = empMiles[1].replace("[", "");
            temp = temp.replace("]", "");
            String[] milest = temp.split(",");
            for (int j = 0; j < milest.length; j++) {
                if(!milest[j].equals(null)){
                employeesIDs.add(empMiles[0]);
                milestonesIDs.add(milest[j]);
                System.out.println(empMiles[0]+" "+ milest[j]);

            }}
        }
        
   
        return gai.assignEmployees(employeesIDs, milestonesIDs);

    }
}
